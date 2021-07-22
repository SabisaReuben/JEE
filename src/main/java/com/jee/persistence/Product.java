package com.jee.persistence;

import javax.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity(name = Constants.PRODUCT_TABLE_NAME)
@Table(name = Constants.PRODUCT_TABLE_NAME)
@Access(AccessType.FIELD)
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries(value = {
        @NamedQuery(name = Product.FIND_ALL, query = "SELECT p from Product p"),
        @NamedQuery(name = Product.FIND_WITH_ID, query = "SELECT p from Product p WHERE p.id= :newId")
        ,@NamedQuery(name= Product.FIND_WITH_CASE_CLAUSE,query = "SELECT CASE p.value.initialPrice " +
        " WHEN :price " +
        "THEN p.value.initialPrice*6 " +
        " ELSE p.value.initialPrice*38 "+
        "END "+
        "from Product p"
)
})
@EntityListeners(value = {DebugListener.class})
public abstract class Product {
    public static final String FIND_ALL = "Customer.findAll";
    public static final String FIND_WITH_CASE_CLAUSE = "Customer.findWhen";
    public static final String FIND_WITH_ID = "Customer.findProductWithId";


    @GeneratedValue
    @Id
    private long id;

    @Min(20)
    @Max(2000)
    private String description;

    @Enumerated(EnumType.STRING)
    private Category category;


    private String product_Id;

    private Valuation value;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @Past
    private Date manufacture_date;

    private String productName;

    public abstract Category getCategory();

    /**
     * Default constructor
     */
    public Product() {
    }

    public Product(Valuation value, Date manufacture_date, String productName) {
        this.value = value;
        this.manufacture_date = manufacture_date;
        this.productName = productName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProduct_Id() {
        return product_Id;
    }

    public void setProduct_Id(String product_Id) {
        this.product_Id = product_Id;
    }

    public Valuation getValue() {
        return value;
    }

    public void setValue(Valuation value) {
        this.value = value;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getManufacture_date() {
        return manufacture_date;
    }

    public void setManufacture_date(Date manufacture_date) {
        this.manufacture_date = manufacture_date;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", product_Id='" + product_Id + '\'' +
                ", value=" + value +
                ", creationDate=" + creationDate +
                ", manufacture_date=" + manufacture_date +
                ", productName='" + productName + '\'' +
                '}';
    }
}
