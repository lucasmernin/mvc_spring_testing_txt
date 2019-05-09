package com.sg.VendingMachine2.dao;

import com.sg.VendingMachine2.dto.Items;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author lukem
 */
public class VendingMachineDaoTest {

    VendingMachineDao dao;

    public VendingMachineDaoTest() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        dao = ctx.getBean("vendingMachineDao", VendingMachineDao.class);

    }

    @Test
    public void testGetAllItems() throws Exception {

        List<Items> supplies = dao.getAllItems();
        assertNotNull(supplies);

    }

    @Test
    public void testGetItemByNameFails() throws Exception {

        Items item = dao.getItemByName("notThere");
        assertNull(item);

    }

    @Test
    public void testGetItemByName() throws Exception {

        Items item = dao.getItemByName("water");
        assertNotNull(item);
    }

    @Test
    public void updateItemSelected() throws Exception {

        Items firstItem = dao.getItemByName("water");

        int stock1 = firstItem.getAmountInStock();
        dao.updateItemSelected("water");

        Items secondItem = dao.getItemByName("water");

        int stock2 = secondItem.getAmountInStock();

        assertTrue(stock1 - 1 == stock2);

    }

}
