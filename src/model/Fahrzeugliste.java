package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class Fahrzeugliste<T extends Fahrzeug> implements TableModel {
	private T[] array;
	private int nextFreeSlot;
	private List<TableModelListener> tableListener = new ArrayList<>();

	public Fahrzeugliste(int kapazitaet) {
		array = (T[]) new Fahrzeug[kapazitaet];
	}

	public void add(T o) {
		if (nextFreeSlot == array.length) {
			throw new IllegalStateException("Liste ist voll");
		}
		array[nextFreeSlot] = o;
		nextFreeSlot++;
		
		for(TableModelListener l: tableListener) {
			l.tableChanged(new TableModelEvent(this));
		}
	}

	public T get(int index) {
		return array[index];
	}

	public int getKapazitaet() {
		return array.length;
	}

	public int getElementCount() {
		return nextFreeSlot;
	}

	public int berechneEinnahmen() {
		int summe = 0;
		for (T t : array) {
			summe += t.getPreis();
		}
		return summe;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		tableListener.add(l);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return Integer.class;
		case 2:
			return Integer.class;
		case 3:
			return String.class;
		default:
			return null;
		}
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Hersteller";
		case 1:
			return "Leistung";
		case 2:
			return "Preis";
		case 3:
			return "Typ";
		default:
			return null;
		}
	}

	@Override
	public int getRowCount() {
		return getElementCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Fahrzeug f = get(rowIndex);
		switch (columnIndex) {
		case 0:
			return f.getHersteller();
		case 1:
			return f.getLeistung();
		case 2:
			return f.getPreis();
		case 3:
			return f.getClass().getSimpleName();
		default:
			return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		tableListener.remove(l);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

	}
}
