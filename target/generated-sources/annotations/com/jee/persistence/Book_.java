package com.jee.persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2021-07-19T15:33:10")
@StaticMetamodel(Book.class)
public class Book_ extends EducationalMaterial_ {

    public static volatile SingularAttribute<Book, Integer> numberOfPages;
    public static volatile SingularAttribute<Book, String> Isbn;
    public static volatile SingularAttribute<Book, String> publisher;

}