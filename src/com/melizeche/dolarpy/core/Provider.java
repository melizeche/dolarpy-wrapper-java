package com.melizeche.dolarpy.core;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Marcelo Elizeche Landó <melizeche@gmail.com>
 */
public class Provider implements ProviderInterface {
    private BigDecimal compra;
    private BigDecimal venta;
    //private Date updated;
    
    @Override
    public BigDecimal getCompra() {
        return compra;
    }
    @Override
    public void setCompra(BigDecimal compra) {
        this.compra = compra;
    }

    @Override
    public BigDecimal getVenta() {
        return venta;
    }

    @Override
    public void setVenta(BigDecimal venta) {
        this.venta = venta;
    }

//    @Override
//    public Date getUpdated() {
//        return updated;
//    }
//
//    public void setUpdated(Date updated) {
//        this.updated = updated;
//    }
    
    
}
