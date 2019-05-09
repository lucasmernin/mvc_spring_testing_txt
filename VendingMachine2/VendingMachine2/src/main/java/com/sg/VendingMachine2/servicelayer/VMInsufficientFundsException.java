package com.sg.VendingMachine2.servicelayer;

/**
 *
 * @author lukem
 */
public class VMInsufficientFundsException extends Exception {

    public VMInsufficientFundsException(String message) {
        super(message);
    }

    public VMInsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
            
        
    }

}
