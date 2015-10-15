package com.titan.domain;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="EMP_PK")
public class Employee extends Customer {
   private int employeeId;

   public int getEmployeeId() { return employeeId; }
   public void setEmployeeId(int id) { employeeId = id; }
}

