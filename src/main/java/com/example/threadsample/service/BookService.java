package com.example.threadsample.service;

import com.example.threadsample.data.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> getAllBookList();
    BookDto getBook(Long idx);
    String saveBook(BookDto bookDto);
    String updateBook(BookDto bookDto);
    String deleteBook(Long idx);

}
