package com.jee.persistence;

import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

/**
 * In stateful bean, we have a one-to- one relationship between the client and the bean
 *
 */
@Stateful(passivationCapable = true)
public class ShoppingCartEJB {
    private List<Book> bookList = new ArrayList<>();

    public void addToCart(Book book){
        bookList.add(book);
    }
    //other methods go here

    /**
     * When a method annotated with {@link Remove}, the container calls the method annotated with
     * {@link javax.annotation.PreDestroy} ends the life of the bean instance
     */
    @Remove
    public  void close(){
        bookList.clear();
    }

    /**
     * Passivate is when a container serializes the object into a permanent file
     */
    @PrePassivate
    public void prePassivate(){

    }

    /**
     * When a bean instance is needed; the container deserializes the instance from file storage
     */
    @PostActivate
    public  void postActivate(){

    }
}
