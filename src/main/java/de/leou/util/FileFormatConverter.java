package de.leou.util;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileFormatConverter {

	public static void csv2xlsx(String csv_sp, String csv_sm, String csvFilePath, String xlsxFilePath) {
		// 创建一个工作簿 即excel文件,再在该文件中创建一个sheet
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("sheet");

		String csv_row;
		String[] data = null;
		try {

			BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath));
			int row_i = 0;

			DataFormat fmt = wb.createDataFormat();
			XSSFCellStyle cellStyle = wb.createCellStyle();

			while ((csv_row = csvReader.readLine()) != null) {
				data = csv_row.split(csv_sp);
				// do something with the data
				// 在sheet中创建一行
				XSSFRow row = sheet.createRow(row_i);
				row_i++;
				//
				for (int i = 0; i < data.length; i++) {
					XSSFCell cell = row.createCell(i);
					cell.setCellValue(data[i].replaceAll(csv_sm, ""));
					cellStyle.setDataFormat(fmt.getFormat("@"));
					cell.setCellStyle(cellStyle);
				}

			}
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 最后写回磁盘
		FileOutputStream out;
		try {
			out = new FileOutputStream(xlsxFilePath);
			wb.write(out);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("写完了!");

	}

}
