package io.musimap.catalog.data.store.temporale;

import io.musimap.catalog.data.store.adapter.out.persistence.TrackMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class TracksService {

    @Autowired
    private TrackMongoRepository tracksRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final Logger LOGGER = Logger.getLogger(TracksService.class.getSimpleName());

}
