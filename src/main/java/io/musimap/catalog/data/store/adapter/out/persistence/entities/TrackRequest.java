package io.musimap.catalog.data.store.adapter.out.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackRequest {

    @JsonProperty(ATTR_TITLE)
    public String title;
    public static final String ATTR_TITLE = "title";

    @JsonProperty(ATTR_ARTIST)
    public String artist;
    public static final String ATTR_ARTIST = "artist";

    @JsonProperty(ATTR_ALBUM)
    public String album;
    public static final String ATTR_ALBUM = "album";

    @JsonProperty(ATTR_INSTRUMENTAL)
    public Boolean instrumental;
    public static final String ATTR_INSTRUMENTAL = "instrumental";

    @JsonProperty(ATTR_REFERENCES)
    public List<TrackDocument.Reference> references;
    public static final String ATTR_REFERENCES = "references";


}
