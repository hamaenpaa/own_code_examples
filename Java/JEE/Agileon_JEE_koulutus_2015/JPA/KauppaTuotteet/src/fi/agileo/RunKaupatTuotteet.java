package fi.agileo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RunKaupatTuotteet {

	public static void main(String[] args) {
		EntityManagerFactory tehdas = Persistence.createEntityManagerFactory(
				"jpa_kaupat_tuotteet");
		EntityManager manageri = tehdas.createEntityManager();
		EntityTransaction transaktio = manageri.getTransaction();		 

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
        Kauppa k3 = new Kauppa();
        k3.setNimi("Verkkosportti");
        k3.setOsoite("Kuplahallintie 15, Toijala");
        
        List<Tuote> tuotteet2 = new ArrayList<>();
        tuotteet2.add(t1);
        tuotteet2.add(t3);
        List<Tuote> tuotteet = new ArrayList<>();
        tuotteet.add(t1);
        List<Tuote> tuotteet3 = new ArrayList<>();
        tuotteet3.add(t3);
        
        k1.setTuotteet(tuotteet);
        k2.setTuotteet(tuotteet2);
        k3.setTuotteet(tuotteet3);        
        
		transaktio.begin();
		manageri.persist(k1);
		manageri.persist(k2);
		manageri.persist(k3);
		manageri.persist(t1);
		manageri.persist(t2);
		manageri.persist(t3);
		
		transaktio.commit();
		
		System.out.println("Tuotteet ja niiden kaupat");
		List<Object[]> tuotteetKaupat = manageri.createNamedQuery("FindAllTuotteetKaupat").getResultList();
		for(Object[] ob : tuotteetKaupat) {
			Tuote  t = (Tuote)ob[1];
			Kauppa k = (Kauppa)ob[0];
			System.out.println(t);
			System.out.println(k);
		}
		
		System.out.println("Tuotteet ja niiden kaupat yritys - ei saada kauppoja !!");
		List<Tuote> haeTuotteet = manageri.createNamedQuery("FindAllTuotteet").getResultList();
		for(Tuote t: haeTuotteet) {
			System.out.println(t);
			List<Kauppa> kaup = t.getKaupat();
			for(Kauppa k : kaup)
				System.out.println(k);
		}
		
		System.out.println("Kaupat ja niiden tuotteet");
		List<Kauppa> haeKaupat = manageri.createNamedQuery("FindAllKaupat").getResultList();
		for(Kauppa k: haeKaupat) {
			System.out.println(k);
			List<Tuote> tuotteetx = k.getTuotteet();
			for(Tuote t : tuotteetx)
				System.out.println(t);
		}
		
		
		manageri.close();
		tehdas.close();


	}

}
