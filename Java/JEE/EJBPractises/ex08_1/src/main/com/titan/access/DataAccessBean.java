package com.titan.access;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import com.titan.domain.*;

@Stateless
public class DataAccessBean implements DataAccessRemote
{
   @PersistenceContext private EntityManager manager;
    
   public void initializeDatabase()
   {
      Person p = new Person();
      p.setFirstName("Bill");
      p.setLastName("Burke");
      manager.persist(p);

      Customer cust = new Customer();
      cust.setFirstName("Sacha");
      cust.setLastName("Labourey");
      cust.setStreet("Se La Vie");
      cust.setCity("Neuchatel");
      cust.setState("Switzerland");
      cust.setZip("3332002-111");
      manager.persist(cust);

      Employee employee = new Employee();
      employee.setFirstName("Gavin");
      employee.setLastName("King");
      employee.setStreet("1st Street");
      employee.setCity("Atlanta");
      employee.setState("GA");
      employee.setZip("33320");
      employee.setEmployeeId(15);
      manager.persist(employee);

   }

   public List findAllPersons()
   {
      return manager.createQuery("FROM Person p").getResultList();
   }
}
