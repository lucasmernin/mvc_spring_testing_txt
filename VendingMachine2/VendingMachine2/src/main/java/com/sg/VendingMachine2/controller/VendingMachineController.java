package com.sg.VendingMachine2.controller;

import com.sg.VendingMachine2.dto.Items;
import com.sg.VendingMachine2.servicelayer.VMInsufficientFundsException;
import com.sg.VendingMachine2.servicelayer.VMNoItemInventoryException;
import com.sg.VendingMachine2.servicelayer.VendingMachineServiceLayer;
import com.sg.VendingMachine2.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author lukem
 */
public class VendingMachineController {

    private VendingMachineServiceLayer service;
    private VendingMachineView view;

    BigDecimal moneyInserted;
    BigDecimal totMoneyInserted;
    BigDecimal changeAmount;
    BigDecimal price;
    String itemSelected;

    String totChange;
  

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;

            while (keepGoing) {
                try{

                moneyInserted = view.setMoneyInserted();
                List<Items> itemsList = service.getAllItems();
                view.displayAllItems(itemsList, moneyInserted);
                itemSelected = view.setItemSelectedByName();
                service.itemCalc(moneyInserted, itemSelected);
                changeAmount = service.successfulItemCalc(itemSelected, moneyInserted);
                totChange = service.useChangeMethod(changeAmount);
                view.displayChangeBreakdown(totChange);
                view.displaySuccessfulTransactionBanner();
                view.displayExitMessage();
                break;
            

        } catch (VMInsufficientFundsException e) {
            view.displayInsufficientFundsBanner(moneyInserted);

        } catch (VMNoItemInventoryException e) {
            view.displayItemNotAvailableBanner();
        }
            }
    }
}
    

