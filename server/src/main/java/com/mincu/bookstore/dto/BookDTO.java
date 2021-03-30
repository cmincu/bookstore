package com.mincu.bookstore.dto;

import com.mincu.bookstore.domain.Genre;

import java.util.Objects;

public class BookDTO {
    private String title;
    private String author;
    private Genre genre;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BookDTO bookDTO = (BookDTO) o;
        return Objects.equals(title, bookDTO.title)
                && Objects.equals(author, bookDTO.author)
                && genre == bookDTO.genre;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, genre);
    }
}
