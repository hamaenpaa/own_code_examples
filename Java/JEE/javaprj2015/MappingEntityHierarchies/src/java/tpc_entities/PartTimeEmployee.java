/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpc_entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author harri
 */
@Entity(name="TPCPartTimeEntity")
@NamedQueries({
  @NamedQuery(name = "TPCPartTimeEmployee.findAll", query = "select o from TPCPartTimeEmployee o")})
@Table(name = "TPC_PT_EMPLOYEE")
public class PartTimeEmployee extends Employee {
    @SuppressWarnings("compatibility:-4882346458268010846")
    private static final long serialVersionUID = 4017999239159878209L;

    @Column(name = "HOURLY_WAGE")
    private double hourlyWage;

    public PartTimeEmployee() {
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }    
    
    @Override
    public String toString() {
        return "tpc_entities.FullTimeEmployee[ id=" + getId() + " ]";
    }    
}
