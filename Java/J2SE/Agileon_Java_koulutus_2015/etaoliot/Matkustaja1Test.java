package etaoliot;

public class Matkustaja1Test {
	public static void main(String[] args) {
		Matkustaja1[] matkustajat = new Matkustaja1[5];
		
		matkustajat[0] = new Matkustaja1();
		matkustajat[0].setNimi("Pekka");
		matkustajat[0].setKohde("Tampere");
		matkustajat[0].setPaikanHinta(35.50);
		
		matkustajat[1] = new Matkustaja1();
		matkustajat[1].setNimi("Kalle");
		matkustajat[1].setKohde("Helsinki");
		matkustajat[1].setPaikanHinta(49.50);
		
		matkustajat[2] = new Matkustaja1();
		matkustajat[2].setNimi("Mikko");
		matkustajat[2].setKohde("Hämeenlinna");
		matkustajat[2].setPaikanHinta(39.30);
		
		matkustajat[3] = new Matkustaja1();
		matkustajat[3].setNimi("Riitta");
		matkustajat[3].setKohde("Jämsä");
		matkustajat[3].setPaikanHinta(15.00);
		
		matkustajat[4] = new Matkustaja1();
		matkustajat[4].setNimi("Merja");
		matkustajat[4].setKohde("Orivesi");
		matkustajat[4].setPaikanHinta(23.50);
		
		for(Matkustaja1 m : matkustajat) 
			System.out.println(m);
	}
}
