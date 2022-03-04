package io.musimap.catalog.data.store.adapter.out.persistence.mongo;

import io.musimap.catalog.data.store.adapter.out.persistence.entities.TrackDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackMongoRepository extends MongoRepository<TrackDocument, String> {


}