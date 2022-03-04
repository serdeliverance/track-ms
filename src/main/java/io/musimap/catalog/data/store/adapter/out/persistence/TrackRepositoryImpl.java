package io.musimap.catalog.data.store.adapter.out.persistence;

import io.musimap.catalog.data.store.adapter.out.persistence.entities.TrackDocument;
import io.musimap.catalog.data.store.adapter.out.persistence.mappers.TrackMapper;
import io.musimap.catalog.data.store.adapter.out.persistence.mongo.TrackMongoRepository;
import io.musimap.catalog.data.store.domain.entities.Track;
import io.musimap.catalog.data.store.port.out.TrackRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import static io.musimap.catalog.data.store.adapter.out.persistence.mappers.TrackMapper.documentToDomain;
import static io.musimap.catalog.data.store.adapter.out.persistence.mappers.TrackMapper.domainToDocument;

@Slf4j
public class TrackRepositoryImpl implements TrackRepository {

    private TrackMongoRepository repository;
    private TrackMapper mapper;

    public TrackRepositoryImpl(TrackMongoRepository repository, TrackMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Track save(Track track) {
        TrackDocument persistedDocument = domainToDocument(track);
        return documentToDomain(persistedDocument);
    }
}
