package com.sg.VendingMachine2.dto;

import java.math.BigDecimal;

/**
 *
 * @author lukem
 */
public class Coins {
    
    private BigDecimal dollar;
    
    private BigDecimal quarter;
    
    private BigDecimal nickel;
    
    private BigDecimal penny;

    public BigDecimal getDollar() {
        return dollar;
    }

    public void setDollar(BigDecimal dollar) {
        this.dollar = dollar;
    }

    public BigDecimal getQuarter() {
        return quarter;
    }

    public void setQuarter(BigDecimal quarter) {
        this.quarter = quarter;
    }

    public BigDecimal getNickel() {
        return nickel;
    }

    public void setNickel(BigDecimal nickel) {
        this.nickel = nickel;
    }

    public BigDecimal getPenny() {
        return penny;
    }

    public void setPenny(BigDecimal penny) {
        this.penny = penny;
    }
  
}
