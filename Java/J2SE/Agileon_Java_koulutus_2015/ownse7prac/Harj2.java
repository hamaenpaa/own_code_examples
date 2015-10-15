package ownse7prac;

import java.util.Arrays;
import java.util.Scanner;

public class Harj2 {

	public static void main(String[] args) {
		
		String[] studentNames = 
			{"Kalle","Mikko","Heini","Matti","Saara"};
		double[] ivalues   = new double[studentNames.length];
		int[] ivaluecounts = new int[studentNames.length];
		int iseparatevaluecount = 0;
		double arvosana = 0f;
		boolean arvosananewcount = false;
		
		Arrays.sort(studentNames);
		
		Scanner lukija = new Scanner(System.in);
		  
		for(int i=0;i < studentNames.length; i++) {
			System.out.print("Anna oppilaan " + studentNames[i] + 
					" arvosana >");
			arvosana = lukija.nextDouble();			
			arvosananewcount = false;
			for(int j=0; j < iseparatevaluecount; j++) {
				if (ivalues[j] == arvosana) {
					ivaluecounts[j]++;
					arvosananewcount = true;
					break;
				}
			}
			if (arvosananewcount == false) {
				ivalues[iseparatevaluecount] = arvosana;
				ivaluecounts[iseparatevaluecount] = 1;
				iseparatevaluecount++;
			}
		}
		lukija.close();
		
		/* sort values and value counts simultaneously */
		for(int i=0; i < iseparatevaluecount; i++) {
			double value = ivalues[i];
			int amount = ivaluecounts[i];
			double minvalue = value;
			int minvaluecount = amount;
			int minvalueindex = i;
			for(int j= i+1; j < iseparatevaluecount; j++) {
				if (ivalues[j] < minvalue) {
					minvalue = ivalues[j];
					minvaluecount = ivaluecounts[j];
					minvalueindex = j;
				}
			}
			if (minvalueindex != i) {
				ivalues[i] = minvalue;
				ivaluecounts[i] = minvaluecount;
				ivalues[minvalueindex] = value;
				ivaluecounts[minvalueindex] = amount;
			}
		}
		
		for(int i=0; i < iseparatevaluecount; i++) {
			System.out.print(ivalues[i] + " ");
			for(int j=1; j <= ivaluecounts[i]; j++)
				System.out.print("*");
			System.out.println("");
		}
	      
	        
	}

}
