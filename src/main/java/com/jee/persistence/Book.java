package com.jee.persistence;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Book  extends EducationalMaterial{
    private  int numberOfPages;

    private String publisher;

    private String Isbn;

    public Book() {
        super();

    }

    public Book(Valuation value, Date manufacture_date, String productName, String author,
                String preview, int numberOfPages, String publisher) {
        super(value, manufacture_date, productName, author, preview);
        this.numberOfPages = numberOfPages;
        this.publisher = publisher;

    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "numberOfPages=" + numberOfPages +
                ", publisher='" + publisher + '\'' +
                ", Isbn='" + Isbn + '\'' +
                '}';
    }
}
