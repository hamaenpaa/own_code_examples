package fi.agileo;

import java.util.List;

import javax.persistence.*;

public class RunSimpleEntity {

	public static void main(String[] args) {
		EntityManagerFactory tehdas = Persistence.createEntityManagerFactory("jpa_SimpleEntity_harjoitus");
		EntityManager manageri = tehdas.createEntityManager();
		EntityTransaction transaktio = manageri.getTransaction();
		transaktio.begin();
		SimpleEntity p1 = new SimpleEntity();
		p1.setName("Pallo");
		p1.setDescription("3d pallo");

		// aseta Kello, Kenkä, Kala ja Kukka SimpleEntity:ihin ja tallenna ne
		SimpleEntity p2 = new SimpleEntity();
		p2.setName("Kello");
		p2.setDescription("Qvartz");
		SimpleEntity p3 = new SimpleEntity();
		p3.setName("Kala");
		p3.setDescription("Kuha");
		SimpleEntity p4 = new SimpleEntity();
		p4.setName("Kukka");
		p4.setDescription("Ruusu");
		SimpleEntity p5 = new SimpleEntity();
		p5.setName("Kenkä");
		p5.setDescription("Coretex kenkä");
		SimpleEntity p6 = new SimpleEntity();
		p6.setName("Ilmapallo");
		p6.setDescription("Kuumailmapallo");
		
		manageri.persist(p1);
		manageri.persist(p2);
		manageri.persist(p3);
		manageri.persist(p4);
		manageri.persist(p5);
		manageri.persist(p6);
		
		transaktio.commit();
		
		System.out.println("All");
		@SuppressWarnings("unchecked")
		List<SimpleEntity> entiteetit = manageri.createNamedQuery("selectAll").getResultList();
		for (SimpleEntity l : entiteetit) {
			System.out.println("SimpleEntity: " + l);
		}

		entiteetit.clear();
		
		/* Harj. 2-3. */
		System.out.println("Beginning with K");
		TypedQuery<SimpleEntity> kysely = manageri.createQuery(
				"SELECT a FROM SimpleEntity AS a WHERE a.name LIKE 'K%'",
				SimpleEntity.class);
		List<SimpleEntity> kAlkuiset = kysely.getResultList(); 
		for (SimpleEntity l : kAlkuiset) {
			System.out.println("SimpleEntity with begin K: " + l);
		}
		
		System.out.println("Beginning with P");
		entiteetit = manageri.createNamedQuery("selectWithLike").setParameter("lp", "P%").getResultList();
		for (SimpleEntity l : entiteetit) {
			System.out.println("SimpleEntity with begin P: " + l);
		}

		/* Harj. 2-4, 2-5 */
		System.out.println("Containing a");
		entiteetit = manageri.createNamedQuery("selectWithLike").setParameter("lp", "%a%").getResultList();
		for (SimpleEntity l : entiteetit) {
			System.out.println("SimpleEntity containing a: " + l);
		}
		
		/* Harj. 2-6 */
		transaktio.begin();
		
		/* With select queries */
/*		
		entiteetit = manageri.createNamedQuery("selectWithLike").setParameter("lp", "%ä%").getResultList();
		for (SimpleEntity l : entiteetit) 
			manageri.remove(l);

		entiteetit = manageri.createNamedQuery("selectWithLike").setParameter("lp", "%I%").getResultList();
		for (SimpleEntity l : entiteetit) 
			manageri.remove(l);
		*/

		
		/* by delete */
		int poistetutRivit = manageri.createNamedQuery("DeleteWithLike").setParameter("lp", "%ä%").executeUpdate();
		System.out.println("Deleted " + poistetutRivit + " simple entity containing ä");
		poistetutRivit = manageri.createNamedQuery("DeleteWithLike").setParameter("lp", "%I%").executeUpdate();
		System.out.println("Deleted " + poistetutRivit + " simple entity containing I");

		transaktio.commit();
		
		entiteetit.clear();
		System.out.println("After removing those which contain ä or I");
		entiteetit = manageri.createNamedQuery("selectAll").getResultList();
		for (SimpleEntity l : entiteetit) {
			System.out.println("SimpleEntity: " + l);
		}
		
		manageri.close();
		tehdas.close();

	}

}
