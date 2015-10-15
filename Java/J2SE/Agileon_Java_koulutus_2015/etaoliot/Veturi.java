package etaoliot;

public class Veturi {

	private JunaTyontekija kuljettaja = new JunaTyontekija();
	private int            tyyppi     = 1;
	
	public Veturi() {}
	
	public Veturi(JunaTyontekija kuljettaja) {
		this.kuljettaja = kuljettaja;
	}

	public JunaTyontekija getKuljettaja() {
		return kuljettaja;
	}

	public void setKuljettaja(JunaTyontekija kuljettaja) {
		this.kuljettaja = kuljettaja;
	}

	public int getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(int tyyppi) {
		this.tyyppi = tyyppi;
	}
	
	public String toString() {
		return "Veturi, tyyppi " + new Integer(tyyppi).toString() + 
				"\nkuljettaja\n " + kuljettaja.toString() + "\n";
	}
}
