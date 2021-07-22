import com.jee.persistence.Address;
import com.jee.persistence.Customer;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CustomerEntityTest {
    private static Weld weld;

    private static WeldContainer container;

    private static EntityManager em;

    private static EntityManagerFactory factory;

    private static EntityTransaction entityTransaction;

    @BeforeClass
    public  static void init() {
        weld = new Weld();
        container = weld.initialize();
        factory = Persistence.createEntityManagerFactory("bookPU");
        em = factory.createEntityManager();
        entityTransaction = em.getTransaction();


        initialize();

    }

    private static   void initialize() {
        Address address = new
                Address("Keroka", "KISII", "MASIMBA", "KENYA", "2752");
        Customer customer = new Customer("Reuben", "Ombaso", "15-12-1997");
        customer.setAddress(address);
        em.persist(customer);

    }

    @Test
    public void shouldCalculateStringDate(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);
        Root<Customer> c = criteriaQuery.from(Customer.class);
        criteriaQuery.select(c);
        Customer customer = em.createQuery(criteriaQuery).setMaxResults(1).getSingleResult();
        Assert.assertEquals(20,customer.getAge());
    }



    @After
    public void stop(){
        entityTransaction.commit();
    }



    @Before
    public  void start(){
        entityTransaction.begin();
    }
    @AfterClass
    public  static void close(){
        em.close();
        factory.close();
        weld.shutdown();
     }

}
