package fi.agileo;

import javax.persistence.*;

@Entity
@NamedQuery(name="FindAllValmistajat", query="SELECT v FROM Valmistaja v")
public class Valmistaja {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	private String name;
	private String address;
	
	@OneToOne(mappedBy="valmistaja") /* cascade=CascadeType.ALL, */
	private Tuote tuote;
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public Tuote getTuote() {
		return tuote;
	}

	public void setTuote(Tuote tuote) {
		this.tuote = tuote;
	}
	
	@Override
	public String toString() {
		return "Valmistaja [Id=" + Id + ", name=" + name + ", address=" + address + "]";
	}
}
