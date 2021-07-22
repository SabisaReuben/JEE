package com.jee.persistence;

import java.util.List;


public interface BookLocal {
    Book findBookById(long id);

    List<Book> getAllBooks();

    Book createBook(Book book);
}
