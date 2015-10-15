/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities_using_element_collection;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author harri
 */
@Entity(name="ELCOLEmployee")
@NamedQueries({
  @NamedQuery(name = "ELCOLEmployee.findAll", query = "select o from ELCOLEmployee o")})
@Table(name = "ELCOL_JOIN_EMPLOYEE")
public class Employee extends Person implements Serializable {
    @SuppressWarnings("compatibility:276774077273820023")
    private static final long serialVersionUID = -8529011412038476148L;
    
    @Column(length = 400)
    private String department;
    
    @Column(length = 400)
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "MANAGER")
    private FullTimeEmployee manager;

    public Employee() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FullTimeEmployee getManager() {
        return manager;
    }

    public void setManager(FullTimeEmployee manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "joined_entities.Employee[ id=" + getId() + " ]";
    }
    
}
