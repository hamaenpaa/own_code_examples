package fi.agileo;

import javax.persistence.*;

@NamedQuery(name="FindAllTuotteet", query="SELECT t FROM Tuote t")
@Entity
@Table(name="Tuote")
public class Tuote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nimi;
	private String koodi;
	private double hinta;
	
	@OneToOne /* (cascade=CascadeType.ALL) */
	@JoinColumn(name="valmistaja_fk", nullable=false)
	private Valmistaja valmistaja;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	public Valmistaja getValmistaja() {
		return valmistaja;
	}

	public void setValmistaja(Valmistaja valmistaja) {
		this.valmistaja = valmistaja;
	}
	
	@Override
	public String toString() {
		return "Tuote [id=" + id + 
				", nimi=" + nimi + 
				", koodi=" + koodi + ", hinta=" + hinta + "]";
	}
}
