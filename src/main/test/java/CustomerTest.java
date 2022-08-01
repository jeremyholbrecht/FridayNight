import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerTest {
    private static Customer customer ;
    private static Customer customer2;

    private static Staff sebastian;
    
    @BeforeClass
    public static void makeCustomer(){
        customer = new Customer("name", 15, 2, true);
        customer2 = new Customer("name2", 18, 45, false);
        customer.setBeersThatTheyDrunk(6);
        customer2.setBeersThatTheyDrunk(4);

        sebastian = new Staff("sebastian");
        sebastian.setAmountsOfTips(0);
    }
    @Test
    public void testFeelingConfident(){
        Assert.assertTrue(customer.feelingConfident());
        Assert.assertFalse(customer2.feelingConfident());
    }

    @Test
    public void testTipTheCuteStaff(){
        // enough money to tip
        Assert.assertEquals(39, customer2.tipTheCuteStaff(new Staff("staff")));
        // not enough money to tip
        Assert.assertEquals(0,customer.tipTheCuteStaff(new Staff("staff")));
        customer.setEuros(50);
        // staff money up
        customer.tipTheCuteStaff(sebastian);
        Assert.assertEquals(9,sebastian.getAmountsOfTips(),0.01);
        customer.setEuros(2);
        sebastian.setAmountsOfTips(0);
        customer.tipTheCuteStaff(sebastian);
        Assert.assertEquals(2, sebastian.getAmountsOfTips(),0.01);

    }
}
