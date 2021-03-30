package com.mincu.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Genre {
    UNKNOWN(0),
    @JsonProperty("Comedy") COMEDY(1),
    @JsonProperty("Science-Fiction") SCIENCE_FICTION(2),
    @JsonProperty("Crime") CRIME(3),
    @JsonProperty("Mystery") MYSTERY(4),
    @JsonProperty("Horror") HORROR(5),
    @JsonProperty("Drama") DRAMA(6),
    @JsonProperty("Romance") Romance(7);

    private final int genre;

    Genre(final int genre) {
        this.genre = genre;
    }

    public int getGenre() {
        return genre;
    }

    public static Genre valueOf(final int genre) {
        return Genre.values()[genre];
    }
}
