package etaoliot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Vaunu {
	
	private Matkustaja[] matkustajat;
	private List<IstumaPaikka> istumaPaikat = new ArrayList<IstumaPaikka>();
	private List<PaikanVaraus> paikanVaraukset = new ArrayList<PaikanVaraus>();

	public Vaunu() {}
	
	public Vaunu(int paikkoja, Collection<IstumaPaikka> istumaPaikat) {
		matkustajat = new Matkustaja[paikkoja];
		this.istumaPaikat.addAll(istumaPaikat);
	}

	public Matkustaja[] getMatkustajat() {
		return matkustajat;
	}
	
	public void setMatkustajat(Collection<Matkustaja> matkustajat) {
		this.matkustajat = new Matkustaja[matkustajat.size()];
		int i=0;
		for(Matkustaja m : matkustajat) {
			this.matkustajat[i] = m;
			i++;
		}
	}

	public void setMatkustajat(Matkustaja[] matkustajat) {
		this.matkustajat = matkustajat;
	}

	public List<IstumaPaikka> getIstumaPaikat() {
		return istumaPaikat;
	}

	public void setIstumaPaikat(List<IstumaPaikka> istumaPaikat) {
		this.istumaPaikat = istumaPaikat;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Vaunu, istumapaikkoja " + 
				new Integer(istumaPaikat.size()).toString() + "\n");
		sb.append("IstumaPaikat:\n");
		for(IstumaPaikka istumaPaikka : istumaPaikat)
			sb.append(istumaPaikka.toString());
		sb.append("Matkustajat:");
		for(Matkustaja matkustaja : matkustajat)
			sb.append(matkustaja.toString());
		sb.append("\n\n");
		return sb.toString();
	}

	public List<PaikanVaraus> getPaikanVaraukset() {
		return paikanVaraukset;
	}

	public void setPaikanVaraukset(List<PaikanVaraus> paikanVaraukset) {
		this.paikanVaraukset = paikanVaraukset;
	}
}
