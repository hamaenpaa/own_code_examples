package com.titan.domain;

public class Name {
   private String first;
   private String last;

   public Name(String first, String last) {
      this.first = first;
      this.last = last;
   }
  
   public String getFirst() { return this.first; }
   public String getLast() { return this.last; }
}
