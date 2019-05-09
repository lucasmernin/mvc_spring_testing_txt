package com.sg.VendingMachine2.servicelayer;


import com.sg.VendingMachine2.dao.Change;
import com.sg.VendingMachine2.dao.VendingMachineDao;
import com.sg.VendingMachine2.dto.Items;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lukem
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    private VendingMachineDao dao;
    private Change change;
    

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, Change change) {
        this.dao = dao;
        this.change = change;
       
    }
    
    private List<Change> changeList = new ArrayList<>();

    BigDecimal moneyInserted;
    String itemSelected;
    BigDecimal changeAmount;
    BigDecimal price;
    int amountInStock;
    String changeString;

    @Override
    public List<Items> getAllItems() throws VMNoItemInventoryException, VMInsufficientFundsException {
        return dao.getAllItems();
    }

    @Override
    public boolean itemCalc(BigDecimal moneyInserted, String itemSelected) throws VMNoItemInventoryException, VMInsufficientFundsException {
      
        amountInStock = dao.getItemByName(itemSelected).getAmountInStock();
        price = dao.getItemByName(itemSelected).getPrice();

        if (moneyInserted.compareTo(price) < 0){
          throw new VMInsufficientFundsException("Insufficient Funds."); 
        }
        if(amountInStock < 1) {
         throw new VMNoItemInventoryException("Item is not available.");   
        }
        return true;
        }
   
    @Override
    public BigDecimal successfulItemCalc(String itemSelected, BigDecimal moneyInserted) throws VMNoItemInventoryException, VMInsufficientFundsException {
            BigDecimal changeA = getChangeAmount(itemSelected, moneyInserted);
            dao.updateItemSelected(itemSelected);
        
        return changeA;
    }
    
    @Override
    public BigDecimal getChangeAmount(String itemSelected, BigDecimal moneyInserted) throws VMNoItemInventoryException, VMInsufficientFundsException {
        price = dao.getItemByName(itemSelected).getPrice();
        return changeAmount = moneyInserted.subtract(price);
    }
    
    @Override
    public String useChangeMethod(BigDecimal changeAmount) {
        changeString = change.totOfEach(changeAmount);
        return changeString;
    }
    
    
   
   
 

   

    
  

}
