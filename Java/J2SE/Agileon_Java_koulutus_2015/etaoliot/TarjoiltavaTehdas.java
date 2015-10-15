package etaoliot;

import java.util.ArrayList;
import java.util.List;

public class TarjoiltavaTehdas {
	public static List<Tarjoiltava> getRandomTarjoiltaLista() {
		List<Tarjoiltava> tl = new ArrayList<Tarjoiltava>();
		String[] artikkelit = {"Kahvi", "Tee", "Mehu", "Kaakao", 
				"Keksi", "Pulla", "Viineri" };
		double[] artikkelihinnat = { 2.5, 1, 0.5, 4, 0.2, 1, 2};
		
		for(int i=0; i < (int)(Math.random() * 7); i++) {
			Tarjoiltava t = new Tarjoiltava(
					artikkelit[i], artikkelihinnat[i]
					);
			tl.add(t);
		}
		return tl;
	}
}
