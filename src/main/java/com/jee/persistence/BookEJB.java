package com.jee.persistence;

import javax.ejb.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean()
@Remote(BookRemote.class)
@Local(BookLocal.class)
public class BookEJB implements BookLocal, BookRemote {
    List<Book> list = new ArrayList<>();

    /*@PersistenceContext(unitName = "bookPU")
    private EntityManager entityManager;*/

    @Inject
    @ISBN
    private NumberGenerator numberGenerator;


    @EJB(lookup = "java:global/classes/BookCache!com.jee.persistence.BookCache")
    private BookCache bookCache;

    @Override
    public Book findBookById(long id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> getAllBooks() {
        /*CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);
        Root<Book> b = criteriaQuery.from(Book.class);
        CriteriaQuery<Book> select = criteriaQuery.select(b);
        List<Book> list = entityManager.createQuery(select).getResultList();*/
        //cache the books
        return (List<Book>) bookCache.getBookList("list");


    }

    @Override
    public Book createBook(Book book) {
        book.setIsbn(numberGenerator.generateNumber());
        List<Book> list = new ArrayList<Book>();
        list.add(book);
        bookCache.cache("list", list);

        return book;
    }
}
