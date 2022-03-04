package io.musimap.catalog.data.store.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TrackPatch {

    private String title;
    private String artist;
    private String album;
    private Boolean instrumental;

}
