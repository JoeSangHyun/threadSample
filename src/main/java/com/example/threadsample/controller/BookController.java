package com.example.threadsample.controller;

import com.example.threadsample.data.dto.BookDto;
import com.example.threadsample.service.impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BookController {
    private final BookServiceImpl bookServiceImpl;

    @GetMapping("/BookAllList")
    public List<BookDto> getBookAllList(){
        return bookServiceImpl.getAllBookList();
    }

    @GetMapping("/BookSearch")
    public BookDto getBookList(@RequestParam(name="idx") Long idx) {
        return bookServiceImpl.getBook(idx);
    }

    @PostMapping("/BookSave")
    public String saveBookList(
            @RequestParam(name="name") String name,
            @RequestParam(name="desc") String desc
            ) {
        BookDto bookDto = BookDto.builder()
                .name(name)
                .description(desc).build();

        return bookServiceImpl.saveBook(bookDto);
    }

    @PostMapping("/BookUpdate")
    public String updateBookList(
            @RequestParam(name="idx") Long idx,
            @RequestParam(name="name") String name,
            @RequestParam(name="desc") String desc
    ) {
        BookDto bookDto = BookDto.builder()
                .idx(idx)
                .name(name)
                .description(desc).build();

        return bookServiceImpl.updateBook(bookDto);
    }

    @DeleteMapping("/BookDelete")
    public String deleteBookList(
            @RequestParam(name="idx") Long idx
    ){
        return bookServiceImpl.deleteBook(idx);
    }
}
