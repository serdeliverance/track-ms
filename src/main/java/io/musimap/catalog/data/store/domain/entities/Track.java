package io.musimap.catalog.data.store.domain.entities;

import io.musimap.catalog.data.store.adapter.out.persistence.entities.TrackDocument;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
public class Track {

    private Optional<String> id;
    private String title;
    private String artist;
    private String album;
    private Boolean instrumental;
    private Date createdAt;
    private Date updatedAt;
    private List<TrackDocument.Reference> references;

    @Data
    @AllArgsConstructor
    public static class Reference {

        private String source;
        private String id;

    }
}
