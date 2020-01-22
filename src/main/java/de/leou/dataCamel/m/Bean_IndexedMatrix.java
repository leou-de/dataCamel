package de.leou.dataCamel.m;

import java.util.ArrayList;
import java.util.HashMap;

public class Bean_IndexedMatrix {
	HashMap<String, Integer> header = new HashMap<String, Integer>();
	HashMap<String, Integer> index = new HashMap<String, Integer>();
	ArrayList<String[]> rows;

	public HashMap<String, Integer> getIndex() {
		return index;
	}

	public Bean_IndexedMatrix() {
	}

	public void setIndex(HashMap<String, Integer> index) {
		this.index = index;
	}

	public ArrayList<String[]> getRows() {
		return rows;
	}

	public void setRows(ArrayList<String[]> rows) {
		this.rows = rows;
	}

	public HashMap<String, Integer> getHeader() {
		return header;
	}

	public void setHeader(HashMap<String, Integer> header) {
		this.header = header;
	}

}
