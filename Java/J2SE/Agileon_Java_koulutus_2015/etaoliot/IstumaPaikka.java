package etaoliot;

public class IstumaPaikka {
	private Vaunu vaunu = new Vaunu();
	private int xPos = 1, yPos = 1;
	boolean lNettiYhteys = true;
	
	public IstumaPaikka() {}
	public IstumaPaikka(Vaunu vaunu, int xpos, int ypos,
			boolean lNettiYhteys) {
		this.vaunu = vaunu;
		this.xPos  = xpos;
		this.yPos  = ypos;
		this.lNettiYhteys = lNettiYhteys;
	}
	
	public Vaunu getVaunu() {
		return vaunu;
	}
	
	public void setVaunu(Vaunu vaunu) {
		this.vaunu = vaunu;
	}
	
	public int getxPos() {
		return xPos;
	}
	
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	
	public int getyPos() {
		return yPos;
	}
	
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	public boolean islNettiYhteys() {
		return lNettiYhteys;
	}
	
	public void setlNettiYhteys(boolean lNettiYhteys) {
		this.lNettiYhteys = lNettiYhteys;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("xPos " + new Integer(xPos).toString() + ", ypos " + new Integer(yPos).toString() + "\n");
		if (lNettiYhteys)
			sb.append("On nettiyhteys\n\n");
		else 
			sb.append("Ei ole nettiyhteyttä\n\n");
		return sb.toString();
		
	}
}
