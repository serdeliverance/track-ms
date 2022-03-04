package io.musimap.catalog.data.store.adapter.in.web;

import io.musimap.catalog.data.store.adapter.in.web.dto.TrackDTO;
import io.musimap.catalog.data.store.adapter.out.persistence.entities.TrackDocument;
import io.musimap.catalog.data.store.domain.entities.Track;
import io.musimap.catalog.data.store.port.in.CreateTrackService;
import io.musimap.catalog.data.store.port.in.DeleteTrackService;
import io.musimap.catalog.data.store.port.in.RetrieveTracksService;
import io.musimap.catalog.data.store.port.in.UpdateTrackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import static io.musimap.catalog.data.store.adapter.in.web.mappers.TrackMapper.domainToDto;
import static io.musimap.catalog.data.store.adapter.in.web.mappers.TrackMapper.dtoToDomain;
import static io.musimap.catalog.data.store.adapter.out.persistence.mappers.TrackMapper.documentToDomain;

@Validated
@RestController
@RequestMapping("/tracks")
@Slf4j
public class TracksController {

    private CreateTrackService createTrackService;
    private DeleteTrackService deleteTrackService;
    private RetrieveTracksService retrieveTracksService;
    private UpdateTrackService updateTrackService;

    public TracksController(CreateTrackService createTrackService, DeleteTrackService deleteTrackService, RetrieveTracksService retrieveTracksService, UpdateTrackService updateTrackService) {
        this.createTrackService = createTrackService;
        this.deleteTrackService = deleteTrackService;
        this.retrieveTracksService = retrieveTracksService;
        this.updateTrackService = updateTrackService;
    }

//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Autowired
//    private TracksService tracksService;
//
//    @Autowired
//    private ObjectMapper objectMapper;

    /**
     * Use this endpoint to create some dump track entries
     */
    @SuppressWarnings("unused")
    @PostMapping("/dump")
    public ResponseEntity createDump() {

        log.info("Creating dump tracks...");

        for (int i = 0; i < 1000; i++) {
            TrackDocument trackDocument = new TrackDocument();
            trackDocument.id = UUID.randomUUID().toString();
            trackDocument.album = UUID.randomUUID().toString();
            trackDocument.title = UUID.randomUUID().toString();
            trackDocument.artist = UUID.randomUUID().toString();
            trackDocument.instrumental = false;
            trackDocument.createdAt = new Date();

            TrackDocument.Reference reference1 = new TrackDocument.Reference();
            reference1.id = UUID.randomUUID().toString();
            reference1.source = UUID.randomUUID().toString();

            TrackDocument.Reference reference2 = new TrackDocument.Reference();
            reference2.id = UUID.randomUUID().toString();
            reference2.source = UUID.randomUUID().toString();

            trackDocument.references = Arrays.asList(reference1, reference2);

            createTrackService.createTrack(documentToDomain(trackDocument));
        }

        log.info("Creating dump tracks complete");
        return ResponseEntity.ok("1000 dump tracks have been successfully created");
    }

    /**
     * TODO
     * Implement all CRUD Rest endpoints for the Track model
     */
    @PostMapping
    public ResponseEntity<TrackDTO> create(@RequestBody TrackDTO trackDTO) {
        // TODO log something
        Track createdTrack = createTrackService.createTrack(dtoToDomain(trackDTO));
        return domainToDto(createdTrack);
    }


    /**
     * TODO
     * Create a Rest endpoint to list all Tracks.
     * Request params should be used for every track property to (exact) match by.
     * All params should be optional, if no param is provided all tracks should be returned.
     * If title is provided then the tracks matching that title should be returned.
     * If title + artist are given then tracks matching both title and artists should be returned etc.
     * A 'limit' param should also be used with a default value of 100
     */

}
