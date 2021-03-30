package com.mincu.bookstore.mapper;

import com.mincu.bookstore.domain.Book;
import com.mincu.bookstore.domain.Genre;
import com.mincu.bookstore.dto.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "Spring")
public interface BookMapper {

    @Mappings({@Mapping(target = "genre", expression = "java(mapGenreToDTO(book.getGenre()))")})
    BookDTO mapToDTO(final Book book);

    @Mappings({@Mapping(target = "genre", expression = "java(mapGenreDTOToBook(bookDTO.getGenre()))")})
    Book mapToBook(final BookDTO bookDTO);

    default Genre mapGenreToDTO(final int genre) {
        return Genre.valueOf(genre);
    }

    default int mapGenreDTOToBook(final Genre genre) {
        return genre.getGenre();
    }

}
