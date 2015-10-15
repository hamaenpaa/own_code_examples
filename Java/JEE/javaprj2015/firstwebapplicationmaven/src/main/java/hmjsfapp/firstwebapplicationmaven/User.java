/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmjsfapp.firstwebapplicationmaven;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.*;

/**
 *
 * @author harri
 */
 
@ManagedBean
@SessionScoped
public class User implements Serializable {
    
    @ManagedProperty(value="anonymous")
    private String name;
    private String password;
 
    private List<String> favoriteSports;
    private Map<String, String> spokenLanguages;    
    
    private Profession profession;
    
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
        
    public Profession getProfession() {
        return profession;
    }
 
    public void setProfession(Profession profession) {
        this.profession = profession;
    }        
}
