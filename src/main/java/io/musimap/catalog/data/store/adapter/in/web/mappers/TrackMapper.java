package io.musimap.catalog.data.store.adapter.in.web.mappers;

import io.musimap.catalog.data.store.adapter.in.web.dto.TrackDTO;
import io.musimap.catalog.data.store.domain.entities.Track;
import org.springframework.http.ResponseEntity;

public class TrackMapper {

    public static Track dtoToDomain(TrackDTO dto) {
        // TODO implement
        return null;
    }

    public static ResponseEntity<TrackDTO> domainToDto(Track track) {
        return null;
    }
}
