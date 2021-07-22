package com.jee.persistence;

import java.util.List;

public interface BookRemote {

    Book findBookById(long id);

    List<Book> getAllBooks();



}
