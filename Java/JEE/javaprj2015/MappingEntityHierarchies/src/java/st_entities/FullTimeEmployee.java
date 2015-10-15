/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st_entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author harri
 */
@Entity
@NamedQueries({
  @NamedQuery(name = "FullTimeEmployee.findAll", query = "select o from FullTimeEmployee o")})
@Table(name = "ST_FT_EMPLOYEE")
public class FullTimeEmployee extends Employee implements Serializable {
    @SuppressWarnings("compatibility:9058152191575937294")
    private static final long serialVersionUID = -7301681120809804802L;

    @Column(name = "ANNUAL_SALARY")
    private double annualSalary;
    
    @OneToMany(mappedBy = "manager", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Employee> managedEmployees;

    public FullTimeEmployee() {
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public List<Employee> getManagedEmployees() {
        return managedEmployees;
    }

    public void setManagedEmployees(List<Employee> managedEmployees) {
        this.managedEmployees = managedEmployees;
    }

    public Employee addEmployee(Employee employee) {
        getManagedEmployees().add(employee);
        employee.setManager(this);
        return employee;
    }

    public Employee removeEmployee(Employee employee) {
        getManagedEmployees().remove(employee);
        employee.setManager(null);
        return employee;
    }
    
    @Override
    public String toString() {
        return "entities.FullTimeEmployee[ id=" + this.getId() + " ]";
    }
}
