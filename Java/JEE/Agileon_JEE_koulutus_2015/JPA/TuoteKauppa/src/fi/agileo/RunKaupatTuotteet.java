package fi.agileo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RunKaupatTuotteet {
	public static void main(String[] args) {
		Tuote t1 = new Tuote();
		t1.setNimi("Pesäpallo");
		t1.setHinta(15.56);
		t1.setKoodi("A321");
		Tuote t2 = new Tuote();
		t2.setNimi("Jalkapallo");
		t2.setHinta(19.99);
		t2.setKoodi("A654");
		Tuote t3 = new Tuote();
		t3.setNimi("Koripallo");
		t3.setHinta(24.99);
		t3.setKoodi("B342");		
		
		Kauppa k1 = new Kauppa();
		k1.setNimi("Palloliike");
		k1.setOsoite("Pallokuja 2, Helsinki");
		
		
		Kauppa k2 = new Kauppa();
		k2.setNimi("Välineaitta");
		k2.setOsoite("Kauppatie 45, Jyväskylä");

		Kauppa k2v2 = new Kauppa();
		k2v2.setNimi("Välineaitta2");
		k2v2.setOsoite("Kauppatie 45, Jyväskylä");
		
		
		Kauppa k3 = new Kauppa();
		k3.setNimi("Verkkosportti");
		k3.setOsoite("Kuplahallintie 15, Toijala");
		
		// Lisätään	kaupat tuotteille
		// t1 – kaupat [k1, k2]
		// t3 – kaupat [k2v2, k3]
		List<Kauppa> kaupat = new ArrayList<Kauppa>();
		kaupat.add(k1);
		kaupat.add(k2);
		t1.setKaupat(kaupat);
		k1.setTuote(t1);
		k2.setTuote(t1);
		
		kaupat = new ArrayList<Kauppa>();
		kaupat.add(k2v2);
		kaupat.add(k3);
		t3.setKaupat(kaupat);
		k2v2.setTuote(t3);
		k3.setTuote(t3);
		
		EntityManagerFactory tehdas = Persistence.createEntityManagerFactory("jpa_TuoteKauppa");
		EntityManager manageri = tehdas.createEntityManager();
		EntityTransaction transaktio = manageri.getTransaction();		 
		
		transaktio.begin();

		manageri.persist(k1);
		manageri.persist(k2);
		manageri.persist(k2v2);
		manageri.persist(k3);
		manageri.persist(t1);
		manageri.persist(t2);
		manageri.persist(t3);
		
		transaktio.commit();
		
		System.out.println("Kaupat ja niiden tuotteet");
		kaupat = manageri.createNamedQuery("FindAllKaupat").getResultList();
		for(Kauppa k: kaupat) {
			System.out.println(k);
			System.out.println("Kaupan tuote " + k.getTuote());
		}
		
		System.out.println("Tuotteet ja niiden kaupat");
		List<Tuote> tuotteet = manageri.createNamedQuery("FindAllTuotteet").getResultList();
		for(Tuote t: tuotteet) {
			System.out.println(t);
			List<Kauppa> tuotteenKaupat = t.getKaupat();
			for(Kauppa k: tuotteenKaupat)
				System.out.println(k);
		}
	}
}
