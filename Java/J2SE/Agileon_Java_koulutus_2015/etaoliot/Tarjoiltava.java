package etaoliot;

public class Tarjoiltava {
	private String nimi;
	private double hinta;
	
	public Tarjoiltava() {}
	
	public Tarjoiltava(String nimi, double hinta) {
		this.nimi = nimi;
		this.hinta = hinta;
	}
	
	public String getNimi() {
		return nimi;
	}
	
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	public double getHinta() {
		return hinta;
	}
	
	public void setHinta(double hinta) {
		this.hinta = hinta;
	}
	
}
