/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.jobcreation.ejb.impl.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author khumbu
 */
public class RoundingUpValue {

    // Method to round up decimal value
    public BigDecimal roundValue(BigDecimal d, int scale, boolean roundUp) {
        
        RoundingMode mode = (roundUp) ? RoundingMode.UP : RoundingMode.DOWN;
        d.setScale(2, mode);
        return d;
    }
}
