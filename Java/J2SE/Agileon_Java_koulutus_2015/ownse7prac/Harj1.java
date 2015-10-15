package ownse7prac;

public class Harj1 {
	
	private static void multipTable() {
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				if (i*j < 10) System.out.print(" ");
				System.out.print(new Integer(i * j).toString() + " ");
			}
			System.out.println("");
		}
	}
	
	private static void printChristmasTreeRow(int iStarCount) {
		for(int i=1; i <= (9 - iStarCount) / 2; i++) 
			System.out.print(" ");
		for(int i=1; i <= iStarCount; i++)
			System.out.print("*");
		System.out.println("");
	}
	
	private static void christmasTree() {
		for(int i=1; i <= 9; i = i + 2)
			printChristmasTreeRow(i);
		for(int i=1; i <= 3; i++)
			printChristmasTreeRow(3);
	}
	
	public static void main(String[] args) {
		multipTable();
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		christmasTree();
	}
}
