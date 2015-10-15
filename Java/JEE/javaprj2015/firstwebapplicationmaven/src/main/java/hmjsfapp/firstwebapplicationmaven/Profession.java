/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmjsfapp.firstwebapplicationmaven;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author harri
 */
@Named(value = "profession")
@Dependent
public class Profession {

    private String title;
    private String industry;
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getIndustry() {
        return industry;
    }
 
    public void setIndustry(String industry) {
        this.industry = industry;
    }    
    
    /**
     * Creates a new instance of Profession
     */
    public Profession() {
    }
    
}
