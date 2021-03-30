package com.mincu.bookstore.mapper;


import com.mincu.bookstore.domain.Book;
import com.mincu.bookstore.domain.Genre;
import com.mincu.bookstore.dto.BookDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class BookMapperTest {

    private BookMapper mapper;

    @Before
    public void setUp() {
        mapper = new BookMapperImpl();
    }

    @Test
    public void mapToDTO() {
        final Book book = new Book();
        book.setGenre(Genre.MYSTERY.getGenre());
        book.setAuthor("Author");
        book.setTitle("Sample Title");

        final BookDTO bookDTO = new BookDTO();
        bookDTO.setGenre(Genre.MYSTERY);
        bookDTO.setAuthor("Author");
        bookDTO.setTitle("Sample Title");

        final BookDTO expected = mapper.mapToDTO(book);

        assertThat(expected, is(bookDTO));
    }

    @Test
    public void mapToBook() {
        final Book book = new Book();
        book.setGenre(Genre.COMEDY.getGenre());
        book.setAuthor("Author");
        book.setTitle("Sample Title");

        final BookDTO bookDTO = new BookDTO();
        bookDTO.setGenre(Genre.COMEDY);
        bookDTO.setAuthor("Author");
        bookDTO.setTitle("Sample Title");

        final Book expected = mapper.mapToBook(bookDTO);

        assertThat(expected, is(book));
    }
}