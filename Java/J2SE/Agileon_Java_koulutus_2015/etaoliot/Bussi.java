package etaoliot;

public class Bussi {
	private Matkustaja1[] matkustajat;
	private int varattujaPaikkoja = 0;
	
	public Bussi() {
		matkustajat = new Matkustaja1[10];
	}
	
	public Bussi(int matkustajienMaara) {
		matkustajat = new Matkustaja1[matkustajienMaara];
	}
	
	public void lisaaMatkustaja(Matkustaja1 matkustaja) {
		matkustajat[varattujaPaikkoja] = matkustaja;
		varattujaPaikkoja++;
	}
	
	public void poistaViimeinen() {
		if (varattujaPaikkoja > 0) {
			varattujaPaikkoja--;
			matkustajat[varattujaPaikkoja] = null;
		}
	}
	
	public Matkustaja1 getMatkustaja(int index) {
		if (index >= 0 && index < varattujaPaikkoja)
			return matkustajat[index];
		return null;
	}
	
	public int getMatkustajienMaara() {
		return varattujaPaikkoja;
	}
	
	public int getVapaidenPaikkojenMaara() {
		return (matkustajat.length - varattujaPaikkoja);
	}
	
	public double getYhteisHinta() {
		double summa = 0;
		for(int i=0; i < varattujaPaikkoja; i++)
			summa += matkustajat[i].getPaikanHinta();
		return summa;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Bussi, matkustajia " + new Integer(varattujaPaikkoja).toString());
		sb.append(", vapaita paikkoja " + new Integer(getVapaidenPaikkojenMaara()).toString() + "\n");
		for(int i=0; i < varattujaPaikkoja; i++)
			sb.append(matkustajat[i] + "\n");
		sb.append("Yhteishinta " + new Double(this.getYhteisHinta()).toString() + " euroa");
		sb.append("\n\n");
		return sb.toString();
	}
}
