


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class ToiletManTest {

    private static ToiletMan toiletMan;

    private static Customer customer;

    @BeforeClass
    public static void createCustomer() {
        toiletMan = new ToiletMan("Name", 25);
        customer = new Customer("Name", 30, 100.00, false);
    }

    @Test
    public void TestToiletPapier() {
            toiletMan.setToiletPaperStock(25);
            Assert.assertEquals(25, toiletMan.getToiletPaperStock());



    }
    @Test
    public void testException(){
        Assert.assertThrows(outOfToiletPaperException.class, ()-> toiletMan.fillToiletStallsWithToiletPaper(26));
    }
    @Test
    public void TestSafeFun() {
        customer.setHasCondom(false);
      toiletMan.promoteSafeFun(customer);
      Assert.assertTrue(customer.isHasCondom());
      customer.setHasCondom(false);
      customer.setBeersThatTheyDrunk(5);
      toiletMan.promoteSafeFun(customer);
      Assert.assertFalse(customer.isHasCondom());

    }

}
