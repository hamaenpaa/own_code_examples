package etaoliot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RavintolaVaunu {
	private List<Tarjoiltava> tarjoiltavat = new ArrayList<Tarjoiltava>();
	
	private List<JunaTyontekija> tarjoilijat = new ArrayList<JunaTyontekija>();
	
	public RavintolaVaunu() {}
	
	public RavintolaVaunu(
			Collection<JunaTyontekija> tarjoilijat,
			Collection<Tarjoiltava> tarjoiltavat) {
		this.tarjoilijat.addAll(tarjoilijat);
		this.tarjoiltavat.addAll(tarjoiltavat);
	}
	
	public void addTarjoiltava(Tarjoiltava tarjoiltava) {
		tarjoiltavat.add(tarjoiltava);
	}
	
	public void removeTarjoiltava(Tarjoiltava tarjoiltava) {
		tarjoiltavat.remove(tarjoiltava);
	}

	public List<Tarjoiltava> getTarjoiltavat() {
		return tarjoiltavat;
	}

	public void setTarjoiltavat(List<Tarjoiltava> tarjoiltavat) {
		this.tarjoiltavat = tarjoiltavat;
	}

	public void addTarjoilija(JunaTyontekija tarjoilija) {
		tarjoilijat.add(tarjoilija);
	}
	
	public void removeTarjoilija(JunaTyontekija tarjoilija) {
		tarjoilijat.remove(tarjoilija);
	}
	
	public List<JunaTyontekija> getTarjoilijat() {
		return tarjoilijat;
	}

	public void setTarjoilijat(List<JunaTyontekija> tarjoilijat) {
		this.tarjoilijat = tarjoilijat;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Ravintolavaunu\n");
		sb.append("Tarjoilijat:\n");
		for(JunaTyontekija tarjoilija : tarjoilijat)
			sb.append(tarjoilija.toString());
		sb.append("Tarjoiltavat:");
		for(Tarjoiltava tarjoiltava : tarjoiltavat)
			sb.append(tarjoiltava.toString());
		sb.append("\n\n");
		return sb.toString();
	}
	
}
