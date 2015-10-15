/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpc_entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Version;

/**
 *
 * @author harri
 * 
 * Based on Chapter 4, Beginning EJB
 */
@Entity(name="TPCPerson")
@NamedQueries({
  @NamedQuery(name = "TPCPerson.findAll", query = "select o from TPCPerson o")})
@Table(name = "TPC_PERSON")
@TableGenerator(name = "Person_ID_Generator", table = "TPC_PERSON_ID_GEN",
                pkColumnName = "PRIMARY_KEY_NAME", pkColumnValue = "Person.id",
                valueColumnName = "NEXT_ID_VALUE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person implements Serializable {
    @SuppressWarnings("compatibility:-7074714881275658754")
    private static final long serialVersionUID = 5291172566067954515L;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Person_ID_Generator")
    private Integer id;

    @Column(name = "FIRST_NAME", length = 400)
    private String firstName;
    
    @Column(name = "LAST_NAME", length = 400)
    private String lastName;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "HOME_ADDRESS")
    private Address homeAddress;
    
    @Version
    private Integer version;
    
    public Person()
    {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    public Address getHomeAddress()
    {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress)
    {
        this.homeAddress = homeAddress;
    }
    
    @Override
    public String toString() {
        return "tpc_entities.Person[ id=" + id + " ]";
    }
    
}
