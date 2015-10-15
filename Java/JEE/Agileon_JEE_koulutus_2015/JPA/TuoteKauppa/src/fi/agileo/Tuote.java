package fi.agileo;

import java.util.List;

import javax.persistence.*;

@NamedQuery(name="FindAllTuotteet", query="SELECT t FROM Tuote t")
@Entity
@Table(name="Tuote2")
public class Tuote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nimi;
	private String koodi;
	private double hinta;
	
	@OneToMany(mappedBy="tuote")
	private List<Kauppa> kaupat;
	
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

	public List<Kauppa> getKaupat() {
		return kaupat;
	}

	public void setKaupat(List<Kauppa> kaupat) {
		this.kaupat = kaupat;
	}
	
	@Override
	public String toString() {
		return "Tuote [id=" + id + 
				", nimi=" + nimi + 
				", koodi=" + koodi + ", hinta=" + hinta + "]";
	}
}
