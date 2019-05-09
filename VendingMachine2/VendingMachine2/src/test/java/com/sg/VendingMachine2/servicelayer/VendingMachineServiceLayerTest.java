package com.sg.VendingMachine2.servicelayer;

import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author lukem
 */
public class VendingMachineServiceLayerTest {

    VendingMachineServiceLayer service;

    public VendingMachineServiceLayerTest() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        service = ctx.getBean("vMService", VendingMachineServiceLayer.class);

    }

    @Test
    public void testGetChangeAmount() throws Exception {

        BigDecimal change = service.getChangeAmount("water", new BigDecimal(5));
        assertEquals(new BigDecimal(4), change);

    }

    @Test
    public void testUseChangeMethod() throws Exception {
        
        String change = service.useChangeMethod(new BigDecimal(1.25));
        assertEquals("Dollars: 1  Quarters: 1  Dimes: 0  Nickels: 0  Pennies: 0", change); 
                
        //"Dollars: " + totDollars + "  Quarters: " + totQuarters + "  Dimes: " + totDimes + "  Nickels: " + totNickels + "  Pennies: " + totPennies;
    }

    @Test
    public void testItemCalc() throws Exception {

        assertTrue(service.itemCalc(new BigDecimal(5), "water"));
    }

    @Test(expected = VMInsufficientFundsException.class)
    public void testItemCalcFail() throws Exception {
        service.itemCalc(new BigDecimal(2), "plums");

    }

    @Test(expected = VMNoItemInventoryException.class)
    public void testItemCalcFailAgain() throws Exception {

        service.itemCalc(new BigDecimal(8), "plums");

    }
//    @Test(expected = NullPointerException.class)
//    public void whenExceptionThrown_thenExpectationSatisfied() {
//        String test = null;
//        test.length();
//    }
//        
//    VendingMachineServiceLayer service;
//    
//    VendingMachineServiceLayerTest() {
//        
//        VendingMachineDao dao = new VendingMachineDaoFileImpl();
//        
//        Change change = new Change();
//                
//        service = new VendingMachineServiceLayerImpl(dao, change);
//    }
}
