package etaoliot;

public class HenkiloTehdas {
	private static final String[] etunimiVaihtoehdot =
		{"Kalle", "Mikko", "Reetta", "Tarja", "Sanna", "Minna",
		 "Tero", "Mika", "Harri", "Heikki", "Juha", "Pasi", "Sauli"};
	private static final String[] sukunimiVaihtoehdot = 
		{"Muittari", "Nieminen", "Heikkilä", "Vuoristo",
		"Niittynen", "Mäenpää", "Niinistö", "Huovinen",
		"Kahilakoski"};
	private static final String[] kadunnimiVaihtoehdot =
		{"Vaasankatu", "Mannerheimintie", "Turuntie", "Mutkatie",
		 "Rantakatu", "Satamatie", "Vuorikatu", "Taavintie"};
	private static final String[] kuntaVaihtoehdot = 
		{"Tampere", "Turku", "Jyväskylä", "Helsinki", "Oulu",
		 "Mikkeli"};
	
	private static String getRandomPorras() {
		String rappukirjaimet = "ABCDEFGHIJKLMNOPQRSTUVX"; 
		int iRandomKirjainIndex;
		iRandomKirjainIndex = (int)(Math.random() * rappukirjaimet.length());
		return rappukirjaimet.substring(iRandomKirjainIndex, iRandomKirjainIndex + 1);
	}
	
	private static String getRandomPuhelinnumero() {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i < 9; i++)
			sb.append(new Integer((int)(Math.random() * 10)).toString());
		return sb.toString();
	}
	
	private static int getRandomZipkoodi() {
		return (int)(Math.random() * 80000) + 10000;
	}
	
	private static String getRandomEmail(String nimi) {
		StringBuffer sb = new StringBuffer();
		String[] emailDomains = {"gmail.com", "luukku.fi", "hotmail.com", "yahoo.com"};
		sb.append(nimi);
		sb.append(new Integer((int)(Math.random() * 500)).toString());
		sb.append("@");
		sb.append(emailDomains[(int)(Math.random() * emailDomains.length)]);
		return sb.toString();
	}
	
	public static Henkilo getRandomHenkilo() {
		Henkilo h = new Henkilo();
		h.setNimi(HenkiloTehdas.etunimiVaihtoehdot[(int)(Math.random() * etunimiVaihtoehdot.length)]
				+ " " + HenkiloTehdas.sukunimiVaihtoehdot[(int)(Math.random() * sukunimiVaihtoehdot.length)]);
		h.setKunta(HenkiloTehdas.kuntaVaihtoehdot[(int)(Math.random() * kuntaVaihtoehdot.length)]);
		h.setOsoite(HenkiloTehdas.kadunnimiVaihtoehdot[(int)(Math.random() * kadunnimiVaihtoehdot.length)] +
				" " + new Integer((int)(Math.random() * 40 + 1)).toString() + 
				" " + HenkiloTehdas.getRandomPorras() + " " +
				new Integer((int)(Math.random() * 70 + 1)).toString() 
				);
		h.setIka((int)(Math.random() * 60) + 10);
		h.setPuhNumero(HenkiloTehdas.getRandomPuhelinnumero());
		h.setZipKoodi(getRandomZipkoodi());
		h.setEmail(getRandomEmail(h.getNimi()));
		h.setMaa("Suomi");
		return h;
	}
}
