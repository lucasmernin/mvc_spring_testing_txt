package com.sg.VendingMachine2.servicelayer;

/**
 *
 * @author lukem
 */
public class VMNoItemInventoryException extends Exception {

    public VMNoItemInventoryException(String message) {
        super(message);
    }

    public VMNoItemInventoryException(String message, Throwable cause) {
        super(message, cause);
            
        
    }

}
