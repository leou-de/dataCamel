package de.leou.util;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import de.leou.dataCamel.m.Bean_IndexedMatrix;

public class UtilsExcel {
	public static HashMap<String, Integer> bulidXlsxHeader(Row row_header) {

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		// 获取总列数
		int cols = row_header.getPhysicalNumberOfCells();
		for (int j = 0; j < cols; j++) {
			map.put(row_header.getCell(j) + "", j);
		}
		return map;
	}

	public static Bean_IndexedMatrix bulidIndexedMatrix(XSSFSheet sheet) {
		Bean_IndexedMatrix imx = new Bean_IndexedMatrix();
		imx.setHeader(bulidXlsxHeader(sheet.getRow(0)));

		HashMap<String, Integer> index = new HashMap<String, Integer>();
		ArrayList<String[]> al_rows = new ArrayList<String[]>();

		// 获取总行数
		int rows = sheet.getPhysicalNumberOfRows();
		// bu去除表头，从第 0行开始
		for (int row_count = 0; row_count < rows; row_count++) {
			Row row = sheet.getRow(row_count);
			// 获取总列数
			int cols = row.getPhysicalNumberOfCells();
			String[] ss_row = new String[cols];
			for (int col_count = 0; col_count < cols; col_count++) {
				String val = row.getCell(col_count) + "";
				// set index value
				if (col_count == 0)
					index.put(val, row_count);
				// set row value
				ss_row[col_count] = val;
			}
			//array list add element
			al_rows.add(ss_row);
		}
		
		//set rows and index
		imx.setRows(al_rows);
		imx.setIndex(index);
		
		return imx;
	}

}
