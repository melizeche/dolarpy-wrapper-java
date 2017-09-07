package com.melizeche.dolarpy.core;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Marcelo Elizeche Landó <melizeche@gmail.com>
 */
public class Provider implements ProviderInterface {

    private String name;
    private BigDecimal compra;
    private BigDecimal venta;
    private LocalDateTime updated;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

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

    @Override
    public LocalDateTime getUpdated() {
        return updated;
    }

    @Override
    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
    
    @Override
    public String toString(){
        return "Provider: " + name;
    }
    

}
