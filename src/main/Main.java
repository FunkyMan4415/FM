package main;

import javax.swing.UIManager;

import gui.FMFrame;
import model.Fahrzeug;
import model.Fahrzeugliste;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Fahrzeugliste<Fahrzeug> fahrzeugListe = new Fahrzeugliste<>(500);
		FMFrame frame = new FMFrame(fahrzeugListe);
		frame.setVisible(true);
		
	}
}
