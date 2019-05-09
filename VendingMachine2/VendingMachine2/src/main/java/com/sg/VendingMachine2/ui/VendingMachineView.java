package com.sg.VendingMachine2.ui;


import com.sg.VendingMachine2.ui.VendingMachineUserIO;
import com.sg.VendingMachine2.dto.Items;
import com.sg.VendingMachine2.servicelayer.VMInsufficientFundsException;
import com.sg.VendingMachine2.servicelayer.VMNoItemInventoryException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author lukem
 */
public class VendingMachineView {

    private VendingMachineUserIO io;

    BigDecimal moneyInserted;
    BigDecimal changeAmount;
    String itemSelected;
    BigDecimal price;

    public VendingMachineView(VendingMachineUserIO io) {
        this.io = io;

    }
    public BigDecimal setMoneyInserted() {
        return io.readBigDecimal("Please Insert Money");
    }
    public void displayAllItems(List<Items> items, BigDecimal moneyInserted) {
        io.print("Welcome to Luke's VendingMachine (trial 47)");
        io.print("Current Balance:   $ " + moneyInserted );
        items.forEach((i) -> {
            io.print(i.getItemSelected() + "    $" + i.getPrice());
        });
    }
    public String setItemSelectedByName() throws VMNoItemInventoryException, VMInsufficientFundsException {
        return io.readString("Select an option from above");
    }
    public void displayChangeBreakdown(String totChange) {
        io.print("Thank you! Please collect your change.");
       io.print(totChange);
    }
    public void displayInsufficientFundsBanner(BigDecimal moneyInserted) {
        io.print("Sorry! Your selection's value exceeds the amount entered");
        io.print("Current Balance:  $ " + moneyInserted);
    }
    public String displayItemNotAvailableBanner() {
        io.print("Sorry! Item is currently not available.");
        return io.readString("Select another option");
    }
    public void displayExitMessage() {
        io.print("Thank you for using Luke's Vending Machine! Have a great day!");
    }
    public void displaySuccessfulTransactionBanner() {
        io.print("Congratulations your selection has been dispensed");
    }
    public void displayUnknownItemSelectedBanner() {
        io.print("The item selected can not be found.");
    }

  
}
