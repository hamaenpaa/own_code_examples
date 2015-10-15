package etaoliot;

import java.util.List;
import java.util.ArrayList;

public class MatkustajaTehdas {
	
	private static Matkustaja getRandomMatkustaja() {
		Matkustaja m = new Matkustaja();
		Henkilo h = HenkiloTehdas.getRandomHenkilo();
		m.kopioiHenkilosta(h);
		return m;
	}
	
	public static List<Matkustaja> getMatkustajaLista() {
		List<Matkustaja> matkustajaLista = new ArrayList<Matkustaja>();
		
		int iMaara;
		Matkustaja m;
		iMaara = (int)( Math.random() * 100 ); 
		for(int i=0; i<iMaara; i++) {
			m = MatkustajaTehdas.getRandomMatkustaja();
			matkustajaLista.add(m);
		}
		return matkustajaLista;
	}
}
