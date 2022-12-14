import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BouncerTest {

    private static Customer underAgeCustomer;
    private static Customer ofAgeCustomer;
    private static Bouncer bouncer;


    @BeforeClass
    public static void makeCustomer(){
        underAgeCustomer = new Customer("name", 15, 30, true);
        ofAgeCustomer = new Customer("name", 19, 30, true);
        bouncer = new Bouncer("Sally", 20);
    }

    @Test
    public void testAgeRestriction(){
        Assert.assertTrue(bouncer.isCustomerOldEnoughToEnter(underAgeCustomer));
        Assert.assertTrue(bouncer.isCustomerOldEnoughToEnter(ofAgeCustomer));
    }
}
