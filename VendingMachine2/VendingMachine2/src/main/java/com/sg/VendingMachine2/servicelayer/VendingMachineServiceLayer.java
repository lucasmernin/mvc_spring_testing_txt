/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine2.servicelayer;

import com.sg.VendingMachine2.dto.Items;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author lukem
 */
public interface VendingMachineServiceLayer {

    boolean itemCalc(BigDecimal moneyInserted, String itemSelected) throws VMNoItemInventoryException, VMInsufficientFundsException;

    BigDecimal successfulItemCalc(String itemSelected, BigDecimal moneyInserted) throws VMNoItemInventoryException, VMInsufficientFundsException;

    List<Items> getAllItems() throws VMNoItemInventoryException, VMInsufficientFundsException;
    
    String useChangeMethod(BigDecimal changeAmount);
    
    BigDecimal getChangeAmount(String itemSelected, BigDecimal moneyInserted) throws VMNoItemInventoryException, VMInsufficientFundsException;
}
