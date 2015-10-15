package fi.agileo;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class Tuote implements Comparable<Tuote> {

    @Size(min=1, max=40, message="Virheellinen nimi")
    private String nimi;
    @Size(min=1, max=20, message="Virheellinen koodi")
    private String koodi;
    @DecimalMin(value="0", message="Negatiivinen hinta")
    @DecimalMax(value="5000", message="Liian suuri hinta, max 5000")
    private double hinta;

    public Tuote() {}
    
    public Tuote(String nimi, String koodi, double hinta) {
    	this.nimi = nimi;
    	this.koodi = koodi;
    	this.hinta = hinta;
    }
    
	public String getNimi() {
		return nimi;
	}
	
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	public String getKoodi() {
		return koodi;
	}
	
	public void setKoodi(String koodi) {
		this.koodi = koodi;
	}
	
	public double getHinta() {
		return hinta;
	}
	
	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	@Override
	public String toString() {
		return "Tuote [nimi=" + nimi + ", koodi=" + koodi + ", hinta=" + hinta + "]";
	}

	@Override
	public int compareTo(Tuote o) {
		int iComp = 0;
		if (o.getHinta() < this.getHinta()) 
			return -1;
		if (o.getHinta() > this.getHinta())
			return 1;
		iComp = o.getKoodi().compareTo(this.getKoodi());
		if (iComp != 0)
			return iComp;
		return o.getNimi().compareTo(this.getNimi());
	}	
}
