package com.melizeche.dolarpy.core;

import java.math.BigDecimal;


/**
 *
 * @author Marcelo Elizeche Landó <melizeche@gmail.com>
 */
public class ProviderRef extends Provider {
    private BigDecimal referencial;

    @Override
    public String toString() {
        return "ProviderRef{" + "referencial=" + referencial + '}';
    }

    public BigDecimal getReferencial() {
        return referencial;
    }

    public void setReferencial(BigDecimal referencial) {
        this.referencial = referencial;
    }
    
}
