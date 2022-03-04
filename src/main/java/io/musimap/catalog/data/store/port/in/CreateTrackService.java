package io.musimap.catalog.data.store.port.in;

import io.musimap.catalog.data.store.domain.entities.Track;

public interface CreateTrackService {

    Track createTrack(Track track);
}
