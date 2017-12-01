package model;

public class PKW extends Fahrzeug{
	private int anzahlTueren;

	public PKW(String hersteller, int leistung, int preis, int anzahlTueren) {
		super(hersteller, leistung, preis);
		setAnzahlTueren(anzahlTueren);
	}

	public int getAnzahlTueren() {
		return anzahlTueren;
	}

	public void setAnzahlTueren(int anzahlTueren) {
		this.anzahlTueren = anzahlTueren;
	}

}
