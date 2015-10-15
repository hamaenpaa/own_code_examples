package fi.agileo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RunTuoteValmistaja {
	public static void main(String[] args) {
		Valmistaja v1 = new Valmistaja();
		v1.setName("Urheiluvälinetuotanto Oy");
		v1.setAddress("Heikkiläntie 25");
		
		Tuote t1 = new Tuote();
		t1.setNimi("Pesäpallo");
		t1.setHinta(15.56);
		t1.setKoodi("A321");
		
		t1.setValmistaja(v1);
		v1.setTuote(t1);

		Valmistaja v2 = new Valmistaja();
		v2.setName("Kirittäjä Oy");
		v2.setAddress("Kiritie 12");
		 
		Tuote t2 = new Tuote();
		t2.setNimi("Jalkapallo");
	    t2.setHinta(19.99);
		t2.setKoodi("A654");
		
		v2.setTuote(t2);
		t2.setValmistaja(v2);
		
		Valmistaja v3 = new Valmistaja();
		v3.setName("Urheiluvälinevalmistaja Oy");
		v3.setAddress("Moukaritie 12");
		
 	    Tuote t3 = new Tuote();
		t3.setNimi("Koripallo");
		t3.setHinta(24.99);
		t3.setKoodi("B342");
		
		t3.setValmistaja(v3);
		v3.setTuote(t3);
		 
		EntityManagerFactory tehdas = Persistence.createEntityManagerFactory("TuoteEntity");
		EntityManager manageri = tehdas.createEntityManager();
		EntityTransaction transaktio = manageri.getTransaction();		 
		
		transaktio.begin();
		
		manageri.persist(t1);
		manageri.persist(v1);
		manageri.persist(t2);
		manageri.persist(v2);
		manageri.persist(t3);
		manageri.persist(v3);
		
		transaktio.commit();
		
		List<Tuote> tuotteet = manageri.createNamedQuery("FindAllTuotteet").getResultList();
		
		System.out.println("Tuotteet ja niiden valmistajat");
		for(Tuote t: tuotteet) {
			System.out.println(t);
			System.out.println(t.getValmistaja());
		}
		System.out.println("");
		System.out.println("");
		
		System.out.println("Valmistajat ja niiden tuotteet");
		List<Valmistaja> valmistajat = manageri.createNamedQuery("FindAllValmistajat").getResultList();
		for(Valmistaja v: valmistajat) {
			System.out.println(v);
			System.out.println(v.getTuote());
		}
		
		manageri.close();
		tehdas.close();
		
	}
}
