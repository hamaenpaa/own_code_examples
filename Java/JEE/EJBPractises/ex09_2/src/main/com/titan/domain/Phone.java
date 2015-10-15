package com.titan.domain;

import javax.persistence.*;

@Entity
@NamedNativeQuery(name="NativePhone",
                  query="SELECT p.phone_PK, p.phone_number, p.type FROM PHONE AS p",
                  resultClass=Phone.class)
public class Phone implements java.io.Serializable
{
   private int id;
   private String number;
   private byte type;

   @Id @GeneratedValue
   @Column(name="phone_PK")
   public int getId() { return id; }
   public void setId(int id) { this.id = id; }

   @Column(name="phone_number")
   public String getNumber() { return number; }
   public void setNumber(String number) { this.number = number; }

   public byte getType() { return type; }
   public void setType(byte type) { this.type = type; }
}
