package io.musimap.catalog.data.store.port.out;

import io.musimap.catalog.data.store.domain.entities.Track;

public interface TrackRepository {
    Track save(Track track);
}
