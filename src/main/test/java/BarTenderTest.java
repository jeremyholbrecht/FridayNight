

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BarTenderTest {
    private static BarTender bartender;
    private static Customer richCustomer;
    private static Customer brokeCustomer;


    //check if customer has enough money
    //and make sure that the customer drinkAmount goes up
    // and money goes down if good

    @BeforeClass
    public static void makeBartender(){
        bartender = new BarTender("Joe",1.75, 3.50);
        richCustomer = new Customer("Bob", 35, 100, true);
        brokeCustomer = new Customer("Fred", 25, 1,false);
        richCustomer.setBeersThatTheyDrunk(2);
        brokeCustomer.setBeersThatTheyDrunk(3);


    }
    @Test
    public void testBuyBeer(){
        Assert.assertTrue(richCustomer.getEuros() <= 100);
        Assert.assertEquals(2, richCustomer.getBeersThatTheyDrunk());
        Assert.assertTrue(brokeCustomer.getEuros() == 1);
        Assert.assertEquals(3, brokeCustomer.getBeersThatTheyDrunk());

        bartender.buyBeer(richCustomer,4);

        Assert.assertEquals(93, richCustomer.getEuros(),0.01);
        Assert.assertEquals(6, richCustomer.getBeersThatTheyDrunk());

        bartender.buyBeer(brokeCustomer, 2);

        Assert.assertEquals(1, brokeCustomer.getEuros(), 0.01);
        Assert.assertEquals(3, brokeCustomer.getBeersThatTheyDrunk());




    }

    @Test
    public void testBuyCocktail(){

        bartender.buyCocktail(richCustomer, 2);
        Assert.assertEquals(93, richCustomer.getEuros(), .01);
        //Assert.assertEquals(4, richCustomer.getBeersThatTheyDrunk());
        bartender.buyCocktail(brokeCustomer, 3);
        Assert.assertEquals(1, brokeCustomer.getEuros(), .01);
    }
}
