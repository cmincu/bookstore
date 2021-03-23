package com.mincu.bookstore.mapper;

import com.mincu.bookstore.domain.Book;
import com.mincu.bookstore.dto.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "Spring")
public interface BookMapper {

    BookDTO mapToDTO(final Book book);

    Book mapToBook(final BookDTO bookDTO);
}
