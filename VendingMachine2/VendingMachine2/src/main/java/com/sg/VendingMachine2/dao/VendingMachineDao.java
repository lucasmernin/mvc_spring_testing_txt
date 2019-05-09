/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine2.dao;

import com.sg.VendingMachine2.dto.Items;
import com.sg.VendingMachine2.servicelayer.VMInsufficientFundsException;
import com.sg.VendingMachine2.servicelayer.VMNoItemInventoryException;
import java.util.List;

/**
 *
 * @author lukem
 */
public interface VendingMachineDao {

    List<Items> getAllItems() throws VMNoItemInventoryException, VMInsufficientFundsException;
    
    Items getItemByName(String itemSelected) throws VMNoItemInventoryException, VMInsufficientFundsException;
    
    void updateItemSelected(String itemSelected) throws VMNoItemInventoryException, VMInsufficientFundsException;
    
}
