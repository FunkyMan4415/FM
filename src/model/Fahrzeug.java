package model;

public class Fahrzeug {
	private String hersteller;
	private int leistung;
	private int preis;
	
	public Fahrzeug(String hersteller, int leistung, int preis) {
		this.hersteller = hersteller;
		this.leistung = leistung;
		this.preis = preis;
	}
	public String getHersteller() {
		return hersteller;
	}
	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}
	public int getLeistung() {
		return leistung;
	}
	public void setLeistung(int leistung) {
		this.leistung = leistung;
	}
	public int getPreis() {
		return preis;
	}
	public void setPreis(int preis) {
		this.preis = preis;
	}	

}
