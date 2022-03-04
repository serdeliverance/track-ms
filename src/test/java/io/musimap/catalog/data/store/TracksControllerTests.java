package io.musimap.catalog.data.store;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.musimap.catalog.data.store.adapter.out.persistence.entities.TrackDocument;
import io.musimap.catalog.data.store.adapter.out.persistence.entities.TrackPatch;
import io.musimap.catalog.data.store.adapter.out.persistence.entities.TrackRequest;
import io.musimap.catalog.data.store.repositories.TracksRepository;
import io.musimap.catalog.data.store.temporale.TracksService;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class TracksControllerTests {

    @Autowired
    private TracksRepository tracksRepository;

    @Autowired
    private TracksService tracksService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    private String trackId;

    @Test
    public void testCreateGetUpdate() throws Exception {

        TrackRequest trackRequest = new TrackRequest();
        trackRequest.album =
                trackRequest.title = UUID.randomUUID().toString();
        trackRequest.artist = UUID.randomUUID().toString();
        trackRequest.instrumental = false;
        trackRequest.title = UUID.randomUUID().toString();

        TrackDocument.Reference reference1 = new TrackDocument.Reference();
        reference1.id = UUID.randomUUID().toString();
        reference1.source = UUID.randomUUID().toString();

        TrackDocument.Reference reference2 = new TrackDocument.Reference();
        reference2.id = UUID.randomUUID().toString();
        reference2.source = UUID.randomUUID().toString();

        trackRequest.references = Arrays.asList(reference1, reference2);

        this.mockMvc.perform(
                post("/tracks/")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(trackRequest)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$." + TrackDocument.ATTR_ALBUM).value(trackRequest.album))
                .andExpect(jsonPath("$." + TrackDocument.ATTR_TITLE).value(trackRequest.title))
                .andExpect(jsonPath("$." + TrackDocument.ATTR_ARTIST).value(trackRequest.artist))
                .andExpect(jsonPath("$." + TrackDocument.ATTR_INSTRUMENTAL).value(trackRequest.instrumental))
                .andExpect(jsonPath("$." + TrackDocument.ATTR_REFERENCES, IsCollectionWithSize.hasSize(2)))
                .andDo(result -> this.trackId = new ObjectMapper().readTree(result.getResponse().getContentAsString()).get(TrackDocument.ATTR_ID).asText());

        this.mockMvc.perform(
                get("/tracks/" + this.trackId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$." + TrackDocument.ATTR_ALBUM).value(trackRequest.album))
                .andExpect(jsonPath("$." + TrackDocument.ATTR_TITLE).value(trackRequest.title))
                .andExpect(jsonPath("$." + TrackDocument.ATTR_ARTIST).value(trackRequest.artist))
                .andExpect(jsonPath("$." + TrackDocument.ATTR_INSTRUMENTAL).value(trackRequest.instrumental))
                .andExpect(jsonPath("$." + TrackDocument.ATTR_REFERENCES, IsCollectionWithSize.hasSize(2)));


        TrackPatch trackPatch = new TrackPatch();
        trackPatch.title = UUID.randomUUID().toString();
        trackPatch.artist = UUID.randomUUID().toString();
        trackPatch.album = UUID.randomUUID().toString();

        this.mockMvc.perform(
                patch("/tracks/" + this.trackId)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(trackPatch)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$." + TrackDocument.ATTR_ALBUM).value(trackPatch.album))
                .andExpect(jsonPath("$." + TrackDocument.ATTR_TITLE).value(trackPatch.title))
                .andExpect(jsonPath("$." + TrackDocument.ATTR_ARTIST).value(trackPatch.artist))
                .andExpect(jsonPath("$." + TrackDocument.ATTR_INSTRUMENTAL).value(trackRequest.instrumental))
                .andExpect(jsonPath("$." + TrackDocument.ATTR_REFERENCES, IsCollectionWithSize.hasSize(2)));
    }

    @Test
    public void testDelete() throws Exception {

        // TODO

    }

    @Test
    public void testList() throws Exception {

        // TODO

    }

    // TODO add any additional tests required

}
