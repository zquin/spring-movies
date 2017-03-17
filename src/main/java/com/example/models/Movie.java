package com.example.models;

import com.fasterxml.jackson.annotation.*;

/**
 * Created by localadmin on 3/17/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Movie {

    @JsonProperty("title")
    private String Title;
    @JsonProperty("imdbId")
    private String imdbId;
    @JsonProperty("poster")
    private String poster;
    @JsonProperty("year")
    private int year;

    @JsonGetter("title")
    public String getTitle() {
        return Title;
    }

    @JsonSetter("Title")
    public void setTitle(String Title) {
        this.Title = Title;
    }

    @JsonGetter("imdbId")
    public String getImdbId() {
        return imdbId;
    }

    @JsonSetter("imdbID")
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @JsonGetter("poster")
    public String getPoster() {
        return poster;
    }

    @JsonSetter("Poster")
    public void setPoster(String poster) {
        this.poster = poster;
    }

    @JsonGetter("year")
    public int getYear() {
        return year;
    }

    @JsonSetter("Year")
    public void setYear(int year) {
        this.year = year;
    }
}
