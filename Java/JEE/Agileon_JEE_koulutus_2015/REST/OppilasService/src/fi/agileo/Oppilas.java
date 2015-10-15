package fi.agileo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Oppilas {
	private static final long serialVersionUID = 1L;
	private String nimi;
	private int demopisteet, koepisteet;

	public int getDemopisteet() {
		return demopisteet;
	}

	public void setDemopisteet(int demopisteet) {
		this.demopisteet = demopisteet;
	}

	public int getKoepisteet() {
		return koepisteet;
	}

	public void setKoepisteet(int koepisteet) {
		this.koepisteet = koepisteet;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public int getYhteispisteet() {
		return demopisteet + koepisteet;
	}

	@Override
	public String toString() {
		return "Oppilas [nimi=" + nimi + ", demopisteet=" + demopisteet + ", koepisteet=" + koepisteet + "]";
	}

}
