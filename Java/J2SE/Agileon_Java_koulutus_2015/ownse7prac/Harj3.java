package ownse7prac;

import java.util.Scanner;

public class Harj3 {
	public static void main(String[] args) {
		int amount = 0;
		int[] counts = new int[11];
		Scanner lukija = new Scanner(System.in);
		System.out.print("Anna nopanheittojen lukumäärä>");
		amount = lukija.nextInt();
		lukija.close();
		for(int i = 0; i < amount; i++) {
			int value = 0;
			value = (int)( Math.random() * 6 ) + 
					(int)( Math.random() * 6 );
			counts[value]++;
		}
		for(int i = 0; i < 11; i++) {
			System.out.println("Kahden nopan heiton tulokseksi tuli " +
					new Integer(i + 2).toString() + " " +
					new Integer(counts[i]).toString() + " kertaa.");
		}
	}
}
