package etaoliot;

public class Matkustaja extends Henkilo {

	private IstumaPaikka istumaPaikka;
	
	public Matkustaja() {}
	
	public Matkustaja(
			String nimi, int ika, String osoite,
			int zipKoodi, String kunta, String maa, 
			String puhNumero, String email,
			IstumaPaikka istumaPaikka) {
		super(nimi, ika, osoite, zipKoodi, kunta, maa, puhNumero, email);
		this.istumaPaikka = istumaPaikka;
	}
	
	public void kopioiHenkilosta(Henkilo henkilo) {
		setNimi(henkilo.getNimi());
		setIka(henkilo.getIka());
		setOsoite(henkilo.getOsoite());
		setZipKoodi(henkilo.getZipKoodi());
		setKunta(henkilo.getKunta());
		setMaa(henkilo.getMaa());
		setPuhNumero(henkilo.getPuhNumero());
		setEmail(henkilo.getEmail());
	}

	public IstumaPaikka getIstumaPaikka() {
		return istumaPaikka;
	}

	public void setIstumaPaikka(IstumaPaikka istumaPaikka) {
		this.istumaPaikka = istumaPaikka;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Matkustaja\n");
		sb.append(super.toString());
		if (istumaPaikka != null)
			sb.append("Istumapaikka\n" + istumaPaikka.toString());
		return sb.toString();
	}
}
