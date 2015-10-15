package fi.agileo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class Oppilas implements Comparable<Oppilas> {
	private int id;
	private String nimi;
	private int koepisteet;
	private int demopisteet;

	public Oppilas() {}
	
	public Oppilas(int id, String nimi, int koepisteet, int demopisteet) {
		this.id = id;
		this.nimi = nimi;
		this.koepisteet = koepisteet;
		this.demopisteet = demopisteet;
	}
	
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
	
	public int getKoepisteet() {
		return koepisteet;
	}
	
	public void setKoepisteet(int koepisteet) {
		this.koepisteet = koepisteet;
	}
	
	public int getDemopisteet() {
		return demopisteet;
	}
	
	public void setDemopisteet(int demopisteet) {
		this.demopisteet = demopisteet;
	}

	@Override
	public String toString() {
		return "Oppilas [id=" + id + ", nimi=" + nimi + ", koepisteet=" + koepisteet + ", demopisteet=" + demopisteet
				+ "]";
	}

	@Override
	public int compareTo(Oppilas o) {
		int mjcomp = 0;
		if (o.getKoepisteet() < this.getKoepisteet())
			return -1;
		if (o.getKoepisteet() > this.getKoepisteet())
			return 1;
		if (o.getDemopisteet() < this.getDemopisteet())
			return -1;
		if (o.getDemopisteet() > this.getDemopisteet())
			return 1;
		mjcomp = o.getNimi().compareTo(this.getNimi());
		if (mjcomp != 0) 
			return mjcomp;
		return o.getId() - this.getId();
	}
}
