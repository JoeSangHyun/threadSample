package com.example.threadsample.service.impl;

import com.example.threadsample.data.dto.BookDto;
import com.example.threadsample.data.entity.Book;
import com.example.threadsample.data.repository.BookRepository;
import com.example.threadsample.service.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<BookDto> getAllBookList() {
        List<Book> bookList = bookRepository.findAll();
        List<BookDto> bookDtoList = new ArrayList<>();

        for(int i=0;i<bookList.size();i++) {
            BookDto bookDto = BookDto.builder()
                    .idx(bookList.get(i).getIdx())
                    .name(bookList.get(i).getName())
                    .description(bookList.get(i).getDescription())
                    .build();

            bookDtoList.add(bookDto);
        }

        return bookDtoList;
    }

    @Override
    public BookDto getBook(Long idx) {
        Optional<Book> book = bookRepository.findByIdx(idx);

        return book.map(value -> BookDto.builder()
                .idx(value.getIdx())
                .name(value.getName())
                .description(value.getDescription())
                .build()).orElse(null);
    }

    @Override
    public String saveBook(BookDto bookDto) {
        Book book = Book.builder()
                .name(bookDto.getName())
                .description(bookDto.getDescription())
                .build();
        bookRepository.save(book);

        return "save ok";
    }

    @Override
    public String updateBook(BookDto bookDto) {
        Book book = Book.builder()
                .idx(bookDto.getIdx())
                .name(bookDto.getName())
                .description(bookDto.getDescription())
                .build();

        if(bookRepository.findByIdx(bookDto.getIdx()).isEmpty()){
            bookRepository.save(book);
            return "save ok";
        } else {
            bookRepository.save(book);
            return "update ok";
        }

    }

    // Delete는 Transaction을 건드려야 하기 때문에 @Transactional 을 기입해야 한다.
    @Override
    @Transactional
    public String deleteBook(Long idx) {
        if(bookRepository.findByIdx(idx).isEmpty()){
            return "입력한 idx = " + idx.toString() + " 가 없습니다.";
        } else {
            // delete를 수행전 findByIdx를 먼저 수행한다.
            bookRepository.deleteByIdx(idx);
            return "Delete Complete idx : " + idx.toString();
        }
    }
}
