import com.jee.persistence.Book;
import com.jee.persistence.BookService;
import com.jee.persistence.Product;
import com.jee.persistence.Product_;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.*;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

public class ProductEntityTest{
    private static Weld weld;

    private static WeldContainer container;

    private static EntityManager entityManager;

    private static EntityTransaction entityTransaction;

    private static EntityManagerFactory factory;

    @BeforeClass
    public static  void init(){
        weld = new Weld();
        container = weld.initialize();
        factory = Persistence.createEntityManagerFactory("bookPU");
        entityManager = factory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    @After
    public    void stop(){
        System.out.println("Transaction committed");
        entityTransaction.commit();
        entityManager.close();
    }

    @Before
    public  void start(){
        System.out.println("Transaction started");
        entityTransaction.begin();

        BookService bookService = container.instance().select(BookService.class).get();

        Book book = bookService.createBook(
                "Reuben Ombaso", "Beginner to JEE", 3000.00, 5.5f,
                "This is the book preview", "This boooojbjjbjbsjbjsbjbj jvvjvsjsvcjcjcjv"
                , 300, "J fg th publishers", new Date());

        entityManager.persist(book);
        entityManager.flush();

    }


    @Test()
    public void shouldRetrieveAllBooks() {

        System.out.println("Querying the  the Product ");
        List<Product> list = entityManager.createQuery("SELECT p from Product p",Product.class).getResultList();
        System.out.println(list.get(0).getCreationDate());
        Assert.assertEquals(1, list.size());
    }

    @Test
    public void shouldRetrieveProductPriceEqual3000(){
        Query query = entityManager.createQuery("SELECT p from Product p Where p.value.initialPrice= ?1", Product.class);
        query.setParameter(1, 3000.00);
        Product product = (Product) query.getSingleResult();
        Assert.assertNotNull(product);

    }

    @Test
    public void shouldFindBookWithId(){
        TypedQuery<Product> query = entityManager.createNamedQuery(Product.FIND_WITH_ID, Product.class);
        query.setParameter("newId", 1L);
        List<Product> productList = query.getResultList();
        Assert.assertNotEquals(0, productList.size());
    }

    @Test
    public  void shouldFindWithCaseClause() {
        TypedQuery<Product> query = entityManager.createNamedQuery(Product.FIND_WITH_CASE_CLAUSE, Product.class);
        query.setParameter("price", 3000.00);
        List<Product> list = query.getResultList();
        System.out.println(list.get(0).getValue());
        Assert.assertEquals(1, list.size());

    }


  @Test
  public void shouldRetrieveWithCriteriaApi() {
      CriteriaBuilder builder = entityManager.getCriteriaBuilder();
      CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
      Root<Product> c = criteriaQuery.from(Product.class);
      criteriaQuery.select(c).where(builder.equal(c.get(Product_.id), 1L));

      List<Product> productList = entityManager.createQuery(criteriaQuery).getResultList();
      System.out.println(productList.get(0).getValue().getInitialPrice());
      Assert.assertEquals(1, productList.size());

  }
    @AfterClass
    public static void close(){
        factory.close();
        weld.shutdown();
    }
}
