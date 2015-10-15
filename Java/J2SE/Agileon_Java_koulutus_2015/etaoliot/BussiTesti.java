package etaoliot;

public class BussiTesti {
	public static void main(String[] args) {
		
		Matkustaja1 pekka = new Matkustaja1("Pekka","Tampere", 35.50);
		Matkustaja1 aino = new Matkustaja1("Aino", "Kerava", 14.30);
		Matkustaja1 eki = new Matkustaja1("Erkki", "Kuopio",79.40);
		Matkustaja1 virpi = new Matkustaja1("Virpi", "Järvenpää", 18.70);
		Matkustaja1 aimo = new Matkustaja1("Aimo", "Jyväskylä", 52.80);
		Matkustaja1 emmi = new Matkustaja1("Emmi", "Orivesi", 38.20);
		Matkustaja1 onni = new Matkustaja1("Onni", "Tampere", 35.50);
		// Lisätään bussiin kuusi matkustajaa
		Bussi pikabussi = new Bussi(20); // 20-paikkainen bussi
		pikabussi.lisaaMatkustaja(pekka);
		pikabussi.lisaaMatkustaja(aino);
		pikabussi.lisaaMatkustaja(eki);
		pikabussi.lisaaMatkustaja(virpi);
		pikabussi.lisaaMatkustaja(aimo);
		pikabussi.lisaaMatkustaja(emmi);
		System.out.println("Pikabussi ensimmäisten matkustajien lisäysten jälkeen");
		System.out.println(pikabussi);
		
		
		// ja poistetaan viimeksi lisätty
		pikabussi.poistaViimeinen();
		
		System.out.println("Pikabussi viimeisen poiston jälkeen");
		System.out.println(pikabussi);
		
		// ja lisätään vielä yksi
		pikabussi.lisaaMatkustaja(onni);
		
		System.out.println("Pikabussi uuden lisäyksen jälkeen");
		System.out.println(pikabussi);
	}
}
