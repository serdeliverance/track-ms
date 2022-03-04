package io.musimap.catalog.data.store.adapter.out.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackPatch {

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

}
