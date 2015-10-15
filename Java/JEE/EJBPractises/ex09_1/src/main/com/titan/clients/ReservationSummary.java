package com.titan.clients;

public class ReservationSummary {
   public String cruise;
   public long numReservations;
   public double cashflow;

   public ReservationSummary(String c, long num, double cash) {
     this.cruise = c;
     this.numReservations = num;
     this.cashflow = cash;
   }
}
