package etaoliot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VaunuTehdas {
	public static Vaunu getRandomVaunu() {
		List<Matkustaja> matkustajat = MatkustajaTehdas.getMatkustajaLista();
		Vaunu vaunu = new Vaunu();
		vaunu.setMatkustajat(matkustajat);
		List<IstumaPaikka> istumaPaikat = IstumaPaikkaTehdas.getIstumaPaikkaLista(vaunu);
		Iterator<IstumaPaikka> iterIstuma = istumaPaikat.iterator();
		for (Matkustaja m : matkustajat) {
			IstumaPaikka ip = null;
			if (iterIstuma.hasNext())
				ip = iterIstuma.next();
			m.setIstumaPaikka(ip);
		}
		vaunu.setIstumaPaikat(istumaPaikat);
		return vaunu;
	}
	
	public static List<Vaunu> getVaunuLista() {
		List<Vaunu> vaunut = new ArrayList<Vaunu>();
		for (int i = 0; i < (int) (Math.random() * 7 + 1); i++) 
			vaunut.add(VaunuTehdas.getRandomVaunu());
		return vaunut;
	}
}
