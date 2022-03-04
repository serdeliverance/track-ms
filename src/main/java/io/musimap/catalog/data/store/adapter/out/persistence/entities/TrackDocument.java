package io.musimap.catalog.data.store.adapter.out.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document("track")
public class TrackDocument {

    // a random key should be assigned on creation, you may use UUID.randomUUID();
    @Id
    @Field(ATTR_ID)
    @JsonProperty(ATTR_ID)
    public String id;
    public static final String ATTR_ID = "id";

    @JsonProperty(ATTR_TITLE)
    @Field(ATTR_TITLE)
    public String title;
    public static final String ATTR_TITLE = "title";

    @JsonProperty(ATTR_ARTIST)
    @Field(ATTR_ARTIST)
    public String artist;
    public static final String ATTR_ARTIST = "artist";

    @JsonProperty(ATTR_ALBUM)
    @Field(ATTR_ALBUM)
    public String album;
    public static final String ATTR_ALBUM = "album";

    @JsonProperty(ATTR_INSTRUMENTAL)
    @Field(ATTR_INSTRUMENTAL)
    public Boolean instrumental;
    public static final String ATTR_INSTRUMENTAL = "instrumental";

    // should be filled with the current date on track creation
    @JsonProperty(ATTR_CREATED_AT)
    @Field(ATTR_CREATED_AT)
    public Date createdAt;
    public static final String ATTR_CREATED_AT = "created_at";

    // should be filled with the current date on track update
    @JsonProperty(ATTR_UPDATED_AT)
    @Field(ATTR_UPDATED_AT)
    public Date updatedAt;
    public static final String ATTR_UPDATED_AT = "updated_at";

    @JsonProperty(ATTR_REFERENCES)
    @Field(ATTR_REFERENCES)
    public List<Reference> references;
    public static final String ATTR_REFERENCES = "references";

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Reference {

        @Field(ATTR_SOURCE)
        @JsonProperty(ATTR_SOURCE)
        public String source;
        public static final String ATTR_SOURCE = "source";

        @Field(ATTR_ID)
        @JsonProperty(ATTR_ID)
        public String id;
        public static final String ATTR_ID = "id";

    }

}
