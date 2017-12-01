package main;

import javax.swing.UIManager;

import gui.FMFrame;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			FMFrame frame = new FMFrame();
			frame.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
