package etaoliot;

import java.util.ArrayList;
import java.util.List;

public class IstumaPaikkaTehdas {

	public static List<IstumaPaikka> getIstumaPaikkaLista(Vaunu vaunu) {
		List<IstumaPaikka> istumapaikat = new ArrayList<IstumaPaikka>();
		ulkoluuppi:
		for(int x=1; x<5; x++) {
			for(int y=1; y<12; y++) {
				if ((x - 1) * 11 + y > vaunu.getMatkustajat().length)
					break ulkoluuppi;
				IstumaPaikka istumaPaikka = new IstumaPaikka();
				istumaPaikka.setVaunu(vaunu);
				istumaPaikka.setxPos(x);
				istumaPaikka.setyPos(y);
				istumapaikat.add(istumaPaikka);
			}
		}
		return istumapaikat;
	}
}
