/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmjsfapp.firstwebapplicationmaven;

import javax.inject.Named;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author harri
 */
@Named(value = "navigation")
@RequestScoped
public class DynamicNavigation {

    private String operselection;
    
    public String getNextPage() {
        switch (this.operselection) {
            case "1" : return "beverages"; 
        }
        return "";
    }
    
    /**
     * Creates a new instance of DynamicNavigation
     */
    public DynamicNavigation() {
    }
    
}
