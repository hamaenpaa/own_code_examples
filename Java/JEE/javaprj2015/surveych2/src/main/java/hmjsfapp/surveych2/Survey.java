/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmjsfapp.surveych2;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
 
@ManagedBean
public class Survey implements Serializable {
    public String save() {

        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();

        // Read the information from the flash
        String userName = (String) flash.get("userName");
        Number age = (Number) flash.get("age");
        String sex = (String) flash.get("sex");
        Number monthlyIncome = (Number) flash.get("monthlyIncome");
        Number travelsAbroad = (Number) flash.get("travelsAbroad");
        String travelBy = (String) flash.get("travelBy");

        System.out.println("Flash information are: \n{\n" +
                "Name: " + userName + ", \n" +
                "Age: " + age + ", \n" +
                "Sex: " + sex + ", \n" +
                "monthlyIncome: " + monthlyIncome + ", \n" +
                "travelsAbroad: " + travelsAbroad + ", \n" +
                "travelBy: " + travelBy + "\n" +
                "}");

        // Save the information in the survey database ...
        // ...

        return "final?faces-redirect=true";
    }
}