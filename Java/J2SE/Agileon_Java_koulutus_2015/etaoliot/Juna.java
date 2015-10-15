package etaoliot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Juna {
	private List<Vaunu> vaunut = new ArrayList<Vaunu>();
	private Veturi veturi = new Veturi();
	private RavintolaVaunu ravintolaVaunu = new RavintolaVaunu();
	private List<JunaTyontekija> junatyontekijat =
			new ArrayList<JunaTyontekija>();
	
	public Juna() {}
	
	public Juna(Veturi veturi, RavintolaVaunu ravintolaVaunu, 
			Collection<Vaunu> vaunut, 
			Collection<JunaTyontekija> junatyontekijat) {
		this.vaunut.addAll(vaunut);
		this.ravintolaVaunu = ravintolaVaunu;
		this.junatyontekijat.addAll(junatyontekijat);
		this.veturi = veturi;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Juna, jossa on veturi " + veturi.toString() + 
				(ravintolaVaunu != null ? "," + ravintolaVaunu.toString() : 
				" ja ") + 
				new Integer(vaunut.size()).toString() + 
				" tavallista vaunua.");
		for(Vaunu vaunu : vaunut)
			sb.append(vaunu.toString());
		return sb.toString();
	}

	public List<Vaunu> getVaunut() {
		return vaunut;
	}

	public void setVaunut(List<Vaunu> vaunut) {
		this.vaunut = vaunut;
	}

	public Veturi getVeturi() {
		return veturi;
	}

	public void setVeturi(Veturi veturi) {
		this.veturi = veturi;
	}

	public RavintolaVaunu getRavintolaVaunu() {
		return ravintolaVaunu;
	}

	public void setRavintolaVaunu(RavintolaVaunu ravintolaVaunu) {
		this.ravintolaVaunu = ravintolaVaunu;
	}

	public List<JunaTyontekija> getJunatyontekijat() {
		return junatyontekijat;
	}

	public void setJunatyontekijat(List<JunaTyontekija> junatyontekijat) {
		this.junatyontekijat = junatyontekijat;
	}
	
}
