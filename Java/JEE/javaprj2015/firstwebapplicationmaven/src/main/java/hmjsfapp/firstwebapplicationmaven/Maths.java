/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmjsfapp.firstwebapplicationmaven;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author harri
 */
@Named(value = "maths")
@RequestScoped
public class Maths {

    /**
     * Creates a new instance of Maths
     */
    public Maths() {
    }

    public Double calculateAverage (Double number1, Double number2) {
        return (number1 + number2) / 2;
    }    
    
}
