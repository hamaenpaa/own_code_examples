package ownse7prac;

public class Henkilo {
	  private String nimi; 
	  private int ika, pituus, paino;
	  // Konstruktorit, jossa luokan muuttujien arvojen alustaminen.
	  public Henkilo( ) {}
	 
	  public Henkilo (String n, int i, int pit, int pain) {
		  this.nimi = n;
		  this.ika = i;
		  this.pituus = pit;
		  this.paino = pain;
	  }
	  // Jäsenmuuttujat asetetaan aseta-alkuisilla metodeilla!
	  public void aseta_ika(int arvo) {
		  this.ika = arvo;
	  }
	  
	  public void aseta_paino(int paino) {
		  this.paino = paino;
	  }
	  
	  public void aseta_pituus(int pituus) {
		  this.pituus = pituus;
	  }
	  
	  public void aseta_nimi(String nimi) {
		  this.nimi = nimi;
	  }
	  
	  // Tulostaa henkilön tiedot
	  public void tulosta( ) {
		  System.out.println(this);
	  }
	  
	  public String toString( ) {
		  return "nimi " + nimi + " ika " + 
				  new Integer(this.ika).toString() + 
				  " pituus " + 
				  new Integer(this.pituus).toString() +
				  " paino " + 
				  new Integer(this.paino).toString();
	  }
	  
	  public static void main(String[] args) {
		  Henkilo henk1 = new Henkilo();
		  Henkilo henk2 = new Henkilo("Kalle", 44, 177, 90);
		  henk1.aseta_ika(33);
		  henk1.aseta_pituus(190);
		  henk1.aseta_nimi("Mikko");
		  henk1.aseta_paino(72);
		  System.out.println("henk1");
		  System.out.println("toString -> ");
		  System.out.println(henk1);
		  System.out.println("tulosta -> ");
		  henk1.tulosta();
		  
		  System.out.println("henk2");
		  System.out.println("toString -> ");
		  System.out.println(henk2);
		  System.out.println("tulosta -> ");
		  henk2.tulosta();
		  
	  }
	  
}
