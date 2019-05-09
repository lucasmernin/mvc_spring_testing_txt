package com.sg.VendingMachine2.app;

import com.sg.VendingMachine2.controller.VendingMachineController;
import com.sg.VendingMachine2.servicelayer.VMInsufficientFundsException;
import com.sg.VendingMachine2.servicelayer.VMNoItemInventoryException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author lukem
 */
public class App {

    public static void main(String[] args) throws VMNoItemInventoryException, VMInsufficientFundsException, Exception {
      // VendingMachineUserIO io = new VendingMachineUserIOConsoleImpl();
       // VendingMachineDao dao = new VendingMachineDaoFileImpl();
       // Change change = new Change();
       // VendingMachineView view = new VendingMachineView(io);
       // VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(dao, change);
       // VendingMachineController controller = new VendingMachineController(service, view);

       // controller.run();
       
       ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
       VendingMachineController controller = ctx.getBean("controller", VendingMachineController.class);
       controller.run();
    }
}
