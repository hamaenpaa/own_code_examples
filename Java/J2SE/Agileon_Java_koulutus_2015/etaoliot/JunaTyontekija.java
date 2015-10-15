package etaoliot;

import java.util.Date;

public class JunaTyontekija extends Henkilo {
	private double palkka;
	private Date tyosuhteenAlkupvm;
	
	public JunaTyontekija() {}
	
	public JunaTyontekija(
			String nimi, int ika, String osoite,
			int zipKoodi, String kunta, String maa, 
			String puhNumero, String email,			
			double palkka,	Date tyosuhteenAlkupvm) {
		super(nimi, ika, osoite, zipKoodi, kunta, maa, puhNumero, email);
		this.palkka = palkka;
		this.tyosuhteenAlkupvm = tyosuhteenAlkupvm;
		
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

	public double getPalkka() {
		return palkka;
	}

	public void setPalkka(double palkka) {
		this.palkka = palkka;
	}

	public Date getTyosuhteenAlkupvm() {
		return tyosuhteenAlkupvm;
	}

	public void setTyosuhteenAlkupvm(Date tyosuhteenAlkupvm) {
		this.tyosuhteenAlkupvm = tyosuhteenAlkupvm;
	}

	
	
	
}
