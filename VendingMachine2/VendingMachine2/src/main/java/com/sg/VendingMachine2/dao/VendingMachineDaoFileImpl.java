package com.sg.VendingMachine2.dao;

import com.sg.VendingMachine2.dto.Items;
import com.sg.VendingMachine2.servicelayer.VMInsufficientFundsException;
import com.sg.VendingMachine2.servicelayer.VMNoItemInventoryException;
import com.sg.VendingMachine2.servicelayer.VendingMachineServiceLayer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lukem
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    VendingMachineServiceLayer service;
    VendingMachineDao dao;

    public void VendingMachineDaoFileImpl(VendingMachineServiceLayer service, VendingMachineDao dao) {
        this.service = service;
        this.dao = dao;
    }

    BigDecimal price;
    BigDecimal availableFunds;
    String itemSelected;
    int amountInStock;

    public static final String INVENTORY_FILE = "inventory.txt";
    public static final String DELIMITER = "::";

    private List<Items> itemsList = new ArrayList<>();

    @Override
    public List<Items> getAllItems() throws VMNoItemInventoryException, VMInsufficientFundsException {
        loadItems();
        return itemsList;

    }

    @Override
    public Items getItemByName(String itemSelected) throws VMNoItemInventoryException, VMInsufficientFundsException {
        loadItems();
        for (Items i : itemsList) {
            if (i.getItemSelected().equalsIgnoreCase(itemSelected)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void updateItemSelected(String itemSelected) throws VMNoItemInventoryException, VMInsufficientFundsException {
        amountInStock = getItemByName(itemSelected).getAmountInStock();
        amountInStock = amountInStock - 1;
        getItemByName(itemSelected).setAmountInStock(amountInStock);
        writeItems();
    }

    public void writeItems() throws VMNoItemInventoryException, VMInsufficientFundsException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new VMNoItemInventoryException("Item is not available", e);
        }

        List<Items> inventoryList = itemsList;
        for (Items currentItem : inventoryList) {

            out.println(currentItem.getItemSelected() + DELIMITER
                    + currentItem.getPrice() + DELIMITER
                    + currentItem.getAmountInStock());

        }

        out.close();
    }

    public void loadItems() throws VMNoItemInventoryException {
        Scanner sc;

        try {

            sc = new Scanner(new BufferedReader(new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VMNoItemInventoryException("Item not Available", e);
        }

        String currentLine;
        String[] currentTokens;

        itemsList.clear();

        while (sc.hasNextLine()) {

            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Items currentItem = new Items();

            currentItem.setItemSelected(currentTokens[0]);
            currentItem.setPrice(new BigDecimal(currentTokens[1]));
            currentItem.setAmountInStock(Integer.parseInt(currentTokens[2]));

            itemsList.add(currentItem);
        }

        sc.close();
    }

}
