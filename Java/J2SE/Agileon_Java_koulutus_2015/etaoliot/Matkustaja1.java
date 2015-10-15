package etaoliot;

public class Matkustaja1 {
	private String nimi;
	private double paikanHinta;
	private String kohde;
		
	public Matkustaja1() {
		
	}
	
	public Matkustaja1(String nimi, String kohde, double paikanHinta) {
		this.nimi = nimi;
		this.kohde = kohde;
		this.paikanHinta = paikanHinta;
	}
	
	public String getNimi() {
		return nimi;
	}
	
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	public double getPaikanHinta() {
		return paikanHinta;
	}
	
	public void setPaikanHinta(double paikanHinta) {
		this.paikanHinta = paikanHinta;
	}
	
	public String getKohde() {
		return kohde;
	}
	
	public void setKohde(String kohde) {
		this.kohde = kohde;
	}
	
	public String toString() {
		return nimi + " matkustaa paikkaan " + kohde + " hintaan "
				+ new Double(paikanHinta).toString() + " euroa.";
	}
	
}
