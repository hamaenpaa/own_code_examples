package etaoliot;

public class HenkiloTesti {
	public static void main(String[] args) {
		Henkilo henkilo1 =	new Henkilo();
		henkilo1.setIka(45);
		henkilo1.setEmail("heikki.kunnala@gmail.com");
		henkilo1.setKunta("Jyväskylä");
		henkilo1.setMaa("Suomi");
		henkilo1.setOsoite("Heikinkatu 7 a 9");
		henkilo1.setPuhNumero("0403200003");
		henkilo1.setZipKoodi(40520);
		System.out.println(henkilo1);
		
		Henkilo henkilo2 = 
				new Henkilo("Kalle Mikkola", 27, "Kuukankatu 12",
						37000, "Mikkeli", "Suomi",
						"040321477", "kalle.mikkola@gmail.com");
		
		System.out.println(henkilo2);
		
	}
}
