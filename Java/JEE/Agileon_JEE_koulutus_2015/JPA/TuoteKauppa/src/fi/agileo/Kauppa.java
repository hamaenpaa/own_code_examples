package fi.agileo;

import javax.persistence.*;

@NamedQuery(name="FindAllKaupat", query="SELECT k FROM Kauppa k")
@Entity
@Table(name="KAUPPA2")
public class Kauppa {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nimi;
	private String osoite;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "tuote_fk")
	private Tuote tuote;
	
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

	public Tuote getTuote() {
		return tuote;
	}

	public void setTuote(Tuote tuote) {
		this.tuote = tuote;
	}
	
	@Override
	public String toString() {
		return "Kauppa [id=" + id + ", nimi=" + nimi + ", osoite=" + osoite + "]";
	}

}
