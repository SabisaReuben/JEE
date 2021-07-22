package com.jee.persistence;

import com.jee.persistence.Category;
import com.jee.persistence.Valuation;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2021-07-19T15:33:10")
@StaticMetamodel(Product.class)
public abstract class Product_ { 

    public static volatile SingularAttribute<Product, Date> manufacture_date;
    public static volatile SingularAttribute<Product, String> product_Id;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Long> id;
    public static volatile SingularAttribute<Product, Category> category;
    public static volatile SingularAttribute<Product, Date> creationDate;
    public static volatile SingularAttribute<Product, Valuation> value;
    public static volatile SingularAttribute<Product, String> productName;

}