package etaoliot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class JunaTyontekijaTehdas {

	public static List<JunaTyontekija> getJunatyontekijaLista() {
		List<JunaTyontekija> 
			junatyontekijalista = new ArrayList<JunaTyontekija>();
		
		for(int i=0; i < (int)(Math.random() * 15); i++) {
			Henkilo h = HenkiloTehdas.getRandomHenkilo();
			JunaTyontekija jt = new JunaTyontekija();
			jt.kopioiHenkilosta(h);
			jt.setPalkka(Math.random() * 1500 + 1500);
			
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(new Date());
			gc.add(Calendar.MONTH, -(int)(Math.random() * 100));
			gc.add(Calendar.DAY_OF_MONTH, -(int)(Math.random() * 30));
			jt.setTyosuhteenAlkupvm(gc.getTime());
			junatyontekijalista.add(jt);
		}
		
		return junatyontekijalista;
	}
	
}
