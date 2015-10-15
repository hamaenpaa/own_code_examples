package etaoliot;

import java.util.Date;

public class PaikanVaraus {
	private IstumaPaikka istumaPaikka = new IstumaPaikka();
	private Matkustaja   matkustaja   = new Matkustaja();
	private Date         dtVarausPvm  = new Date();
	private int          iPrioriteetti;
	private boolean      lAktiivinen;
	private double       hinta;
	private String       alkuPaikkakunta;
	private String       loppuPaikkakunta;
	private Date         dtMatkustusLahtoPvm;
	private int          iAlkuaika; /* minuutteja vuorokauden alusta */
	private int          iLoppuaika; /* minuutteja vuorokauden alusta */
	
	public PaikanVaraus() {}
	
	public PaikanVaraus(IstumaPaikka istumaPaikka, 
			Matkustaja matkustaja,
			Date varausPvm,	
			int iPrioriteetti, boolean lAktiivinen,	
			double hinta,
			String alkuPaikkakunta,	String loppuPaikkakunta,
			Date dtMatkustusLahtoPvm,
			int iAlkuaika, int iLoppuaika) {
		this.istumaPaikka = istumaPaikka;
		this.dtVarausPvm = varausPvm;
		this.iPrioriteetti = iPrioriteetti;
		this.lAktiivinen = lAktiivinen;
		this.hinta = hinta;
		this.alkuPaikkakunta = alkuPaikkakunta;
		this.loppuPaikkakunta = loppuPaikkakunta;
		this.dtMatkustusLahtoPvm = dtMatkustusLahtoPvm;
		this.iAlkuaika = iAlkuaika;
		this.iLoppuaika = iLoppuaika;
	}
	
	public IstumaPaikka getIstumaPaikka() {
		return istumaPaikka;
	}
	
	public void setIstumaPaikka(IstumaPaikka istumaPaikka) {
		this.istumaPaikka = istumaPaikka;
	}
	
	public Matkustaja getMatkustaja() {
		return matkustaja;
	}
	
	public void setMatkustaja(Matkustaja matkustaja) {
		this.matkustaja = matkustaja;
	}
	
	public Date getDtVarausPvm() {
		return dtVarausPvm;
	}
	
	public void setDtVarausPvm(Date dtVarausPvm) {
		this.dtVarausPvm = dtVarausPvm;
	}
	
	public int getiPrioriteetti() {
		return iPrioriteetti;
	}
	
	public void setiPrioriteetti(int iPrioriteetti) {
		this.iPrioriteetti = iPrioriteetti;
	}
	
	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	public String getAlkuPaikkakunta() {
		return alkuPaikkakunta;
	}

	public void setAlkuPaikkakunta(String alkuPaikkakunta) {
		this.alkuPaikkakunta = alkuPaikkakunta;
	}
	public String getLoppuPaikkakunta() {
		return loppuPaikkakunta;
	}

	public void setLoppuPaikkakunta(String loppuPaikkakunta) {
		this.loppuPaikkakunta = loppuPaikkakunta;
	}

	public Date getDtMatkustusLahtoPvm() {
		return dtMatkustusLahtoPvm;
	}

	public void setDtMatkustusLahtoPvm(Date dtMatkustusLahtoPvm) {
		this.dtMatkustusLahtoPvm = dtMatkustusLahtoPvm;
	}

	public int getiAlkuaika() {
		return iAlkuaika;
	}

	public void setiAlkuaika(int iAlkuaika) {
		this.iAlkuaika = iAlkuaika;
	}

	public int getiLoppuaika() {
		return iLoppuaika;
	}

	public void setiLoppuaika(int iLoppuaika) {
		this.iLoppuaika = iLoppuaika;
	}

	public boolean islAktiivinen() {
		return lAktiivinen;
	}

	public void setlAktiivinen(boolean lAktiivinen) {
		this.lAktiivinen = lAktiivinen;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Matkustaja:\n");
		sb.append(matkustaja);
		sb.append("Istumapaikka:\n");
		sb.append(istumaPaikka);
		sb.append("Varauspäivä: " + dtVarausPvm.toString() + "\n");
		sb.append("Prioriteetti: " + new Integer(iPrioriteetti).toString() + "\n");
		if (lAktiivinen)
			sb.append("Aktiivinen\n");
		else
			sb.append("Ei aktiivinen\n");
		sb.append("Hinta " + new Double(hinta).toString() + "\n");
		sb.append("Alkupaikkakunta " + alkuPaikkakunta + "\n");
		sb.append("Loppupaikkakunta " + loppuPaikkakunta + "\n");
		sb.append("Matkustuslähtöpäivä " + dtMatkustusLahtoPvm.toString() + "\n");
		sb.append("Alkuaika " + new Integer((int)(iAlkuaika / 60)).toString() + ":" +
				new Integer((int)(iAlkuaika % 60)).toString() + "\n");
		sb.append("Loppuaika " + new Integer((int)(iLoppuaika / 60)).toString() + ":" +
				new Integer((int)(iLoppuaika % 60)).toString() + "\n");
		return sb.toString();
	}
	
}
