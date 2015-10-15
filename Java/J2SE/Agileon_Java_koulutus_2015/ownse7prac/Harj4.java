package ownse7prac;

public class Harj4 {

    public static double summa(double... luvut) {
    	double summa = 0;
    	for(int i=0; i < luvut.length; i++)
    		summa += luvut[i];
    	return summa;
    }

    public static double keskiarvo(double... luvut) {
    	if (luvut.length == 0) return 0;
    	return summa(luvut) / luvut.length; 
    }
    
    public static double keskihajonta(double... luvut) {
    	double ka = 0;
    	double erotustennelioidensumma = 0;
    	if (luvut.length <= 1) return 0;
    	ka = keskiarvo(luvut);
    	for(int i=0; i < luvut.length; i++)
    		erotustennelioidensumma += 
    		   (luvut[i] - ka) * (luvut[i] - ka);
    	return Math.sqrt(erotustennelioidensumma / luvut.length);
    }
    
	public static void main(String[] args) {
		double sum, ka, haj;
		sum = Harj4.summa(10,20,30,40.5);
		ka = Harj4.keskiarvo(10,20,30,40.5);
		haj = Harj4.keskihajonta(10,20,30,40.5);

		System.out.println("Lukujen 10, 20, 30 ja 40.5 summa on " +
				new Double(sum).toString() + 
				" keskiarvo on " +
				new Double(ka).toString() +
				" ja hajonta on " +
				new Double(haj).toString());
		
		double[] luvut = new double[args.length];
		for(int i=0; i < args.length; i++) {
			luvut[i] = Double.parseDouble(args[i]);
		}
		
		System.out.println("Komentoriviltä annettujen lukujen ");
		for(int i=0; i < args.length; i++) {
			if (i == args.length - 1 && args.length > 1) {
				System.out.print("ja ");
			}
			System.out.print(args[i] + " ");
		}
		
		sum = Harj4.summa(luvut);
		ka = Harj4.keskiarvo(luvut);
		haj = Harj4.keskihajonta(luvut);
		
		System.out.println("summa on " +
		new Double(sum).toString() + 
		" keskiarvo on " +
		new Double(ka).toString() +
		" ja hajonta on " +
		new Double(haj).toString());		
	}

}
