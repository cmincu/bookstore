package com.mincu.bookstore.controller;

import com.mincu.bookstore.dto.BookDTO;
import com.mincu.bookstore.mapper.BookMapper;
import com.mincu.bookstore.service.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    private final BookMapper mapper;

    public BookController(final BookRepository bookRepository, final BookMapper mapper) {
        this.bookRepository = bookRepository;
        this.mapper = mapper;
    }

    @GetMapping
    public List<BookDTO> getBooks() {
        return bookRepository.findAll().stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public BookDTO saveBook(@RequestBody final BookDTO bookDTO) {
        return mapper.mapToDTO(bookRepository.save(mapper.mapToBook(bookDTO)));
    }
}
