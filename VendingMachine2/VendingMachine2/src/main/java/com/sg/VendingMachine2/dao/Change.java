/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.VendingMachine2.dao;

import java.math.BigDecimal;

/**
 *
 * @author lukem
 */
public class Change {

    private int totDollars;
    private int totQuarters;
    private int totDimes;
    private int totNickels;
    private int totPennies;

    private BigDecimal changeAmount;

  
    public String totOfEach(BigDecimal changeAmount) {
        
          
        BigDecimal dollar = new BigDecimal("1");
        BigDecimal quarter = new BigDecimal(".25");
        BigDecimal dime = new BigDecimal(".10");
        BigDecimal nickel = new BigDecimal(".5");
        BigDecimal penny = new BigDecimal(".01");

        totDollars = changeAmount.divide(dollar).intValue();
        changeAmount = changeAmount.remainder(dollar);
        totQuarters = changeAmount.divide(quarter).intValue();
        changeAmount = changeAmount.remainder(quarter);
        totDimes = changeAmount.divide(dime).intValue();
        changeAmount = changeAmount.remainder(dime);
        //totNickels = changeAmount.divide(nickel).intValueExact();
        totNickels = changeAmount.divide(nickel).intValue();
        changeAmount = changeAmount.remainder(nickel);
        
        totPennies = changeAmount.divide(penny).intValue();

         String totChange = "Dollars: " + totDollars + "  Quarters: " + totQuarters + "  Dimes: " + totDimes + "  Nickels: " + totNickels + "  Pennies: " + totPennies;
        return totChange;
    }
}
        
    
    
    
    
    
    
    
    
      

       


