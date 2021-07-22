package com.jee.persistence;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Date;

public class BookService {

    @Inject
    @Bk
    private BookIdGenerator generator;

    private Date creationDate;

    @PostConstruct
    public void init() {
        creationDate = new Date();
    }

    public  Book createBook(String author, String productName, double price, float discount, String preview,String description,
                            int numberOfPages, String publisher, Date manDate){
        Valuation valuation = new Valuation(price, discount);
        Book book = new Book(valuation, manDate, productName, author, preview, numberOfPages, publisher);
        book.setProduct_Id(generator.generateNumber());
        book.setCreationDate(creationDate);
        return book;
    }
}
