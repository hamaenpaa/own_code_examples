package fi.agileo;

import java.util.List;
import javax.persistence.*;

@NamedQuery(name="FindAllKaupat", query="SELECT k FROM Kauppa k")
@Table(name="KAUPPA3")
@Entity
public class Kauppa {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nimi;
	private String osoite;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Tuote> tuotteet;
	
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
	
	public String getOsoite() {
		return osoite;
	}
	
	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}

	public List<Tuote> getTuotteet() {
		return tuotteet;
	}

	public void setTuotteet(List<Tuote> tuotteet) {
		this.tuotteet = tuotteet;
	}
	
	@Override
	public String toString() {
		return "Kauppa [id=" + id + ", nimi=" + nimi + ", osoite=" + osoite + "]";
	}


}
