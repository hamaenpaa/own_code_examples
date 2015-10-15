package etaoliot;

public class Henkilo {
	private String nimi;
	private String osoite;
	private int zipKoodi;
	private String kunta;
	private String maa;
	private String puhNumero;
	private String email;
	private int ika;
	
	public Henkilo() {}
	
	public Henkilo(String nimi, int ika, String osoite,
			int zipKoodi, String kunta, String maa, 
			String puhNumero, String email) {
		this.nimi = nimi;
		this.ika  = ika;
		this.osoite = osoite;
		this.zipKoodi = zipKoodi;
		this.kunta = kunta;
		this.email = email;
		this.puhNumero = puhNumero;
		this.maa = maa;
	}
	
	public String getNimi() {
		return nimi;
	}
	
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	public int getIka() {
		return ika;
	}
	
	public void setIka(int ika) {
		this.ika = ika;
	}

	public String getOsoite() {
		return osoite;
	}

	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}

	public int getZipKoodi() {
		return zipKoodi;
	}

	public void setZipKoodi(int zipKoodi) {
		this.zipKoodi = zipKoodi;
	}

	public String getMaa() {
		return maa;
	}

	public void setMaa(String maa) {
		this.maa = maa;
	}

	public String getPuhNumero() {
		return puhNumero;
	}

	public void setPuhNumero(String puhNumero) {
		this.puhNumero = puhNumero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKunta() {
		return kunta;
	}

	public void setKunta(String kunta) {
		this.kunta = kunta;
	}
	
	public String toString() {
		return "Henkilo, nimi " + nimi +
				" osoite " + osoite + 
				" zip koodi " + new Integer(zipKoodi).toString() +
				" kunta " + kunta + " maa " + maa +
				" puhelinnumero " + puhNumero + "\n";
	}
	
}
