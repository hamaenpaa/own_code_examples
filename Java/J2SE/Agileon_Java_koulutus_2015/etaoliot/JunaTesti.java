package etaoliot;

import java.util.ArrayList;
import java.util.List;

public class JunaTesti {
	public static void main(String[] args) {
		Juna juna = new Juna();
		Veturi veturi = new Veturi();
		JunaTyontekija kuljettaja =	new JunaTyontekija();
		kuljettaja.setNimi("Ville Kuljettaja");
		kuljettaja.setIka(57);
		kuljettaja.setKunta("Jyväskylä");
		veturi.setKuljettaja(kuljettaja);
		juna.setVeturi(veturi);
		juna.setVaunut(VaunuTehdas.getVaunuLista());
		List<JunaTyontekija> junatyontekijat =
				JunaTyontekijaTehdas.getJunatyontekijaLista();
		juna.setJunatyontekijat(junatyontekijat);
		System.out.println("junatyontekijat.size() " + new Integer(junatyontekijat.size()).toString());
		RavintolaVaunu ravintolaVaunu = new RavintolaVaunu();
		List<Tarjoiltava> tarjoiltavat = TarjoiltavaTehdas.getRandomTarjoiltaLista();
		ravintolaVaunu.setTarjoiltavat(tarjoiltavat);
		int tarjoilijalkm = (int)(Math.random() * junatyontekijat.size() + 1);
		System.out.println("tarjoilijalkm " + new Integer(tarjoilijalkm).toString());
		List<JunaTyontekija> tarjoilijat = new ArrayList<JunaTyontekija>();
		for(int i=0; i<tarjoilijalkm; i++)
			tarjoilijat.add(junatyontekijat.get(i));
		ravintolaVaunu.setTarjoilijat(tarjoilijat);
		juna.setRavintolaVaunu(ravintolaVaunu);
		System.out.println(juna);
		
	}
}
