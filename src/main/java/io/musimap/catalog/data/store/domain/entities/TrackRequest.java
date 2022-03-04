package io.musimap.catalog.data.store.domain.entities;

import io.musimap.catalog.data.store.adapter.out.persistence.entities.TrackDocument;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TrackRequest {

    private String title;
    private String artist;
    private String album;
    private Boolean instrumental;
    private List<TrackDocument.Reference> references;
}
