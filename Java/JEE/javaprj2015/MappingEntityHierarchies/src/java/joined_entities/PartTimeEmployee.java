/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joined_entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author harri
 */
@Entity(name="JPartTimeEmployee")
@NamedQueries({
  @NamedQuery(name = "JPartTimeEmployee.findAll", query = "select o from JPartTimeEmployee o")})
@Table(name = "JOIN_PT_EMPLOYEE")
public class PartTimeEmployee extends Employee implements Serializable {
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
        return "joined_entities.PartTimeEmployee[ id=" + getId() + " ]";
    }
    
}
