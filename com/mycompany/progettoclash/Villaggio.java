package com.mycompany.progettoclash;

/**
 * @author Lorenzo
 */
public class Villaggio {

	private int larghezza;
	private int altezza;
	private java.util.ArrayList<Casella> caselle = new ArrayList<Casella>();

	public int getLarghezza() {
		return this.larghezza;
	}

	public void setLarghezza(int larghezza) {
		this.larghezza = larghezza;
	}

	public int getAltezza() {
		return this.altezza;
	}

	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}

	public java.util.ArrayList<Casella> getCaselle() {
		return this.caselle;
	}

	public void setCaselle(java.util.ArrayList<Casella> caselle) {
		this.caselle = caselle;
	}

	/**
	 * 
	 * @param riga
	 * @param col
	 * @param g
	 */
	public Casella getCasella(int riga, int col, Giocatore g) {
		// TODO - implement Villaggio.getCasella
		throw new UnsupportedOperationException();
	}

}