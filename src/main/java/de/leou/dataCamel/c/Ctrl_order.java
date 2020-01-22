package de.leou.dataCamel.c;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import de.leou.dataCamel.FxMainApp;
import de.leou.dataCamel.m.Bean_IndexedMatrix;
import de.leou.util.DT;
import de.leou.util.UtilsExcel;
import javafx.scene.control.TextArea;

public class Ctrl_order {
	public Ctrl_order() {
		// TODO Auto-generated constructor stub
	}

	public void updateWithLogistic(TextArea ta_param, TextArea ta_result, String fileOldOrders_csv,
			String fileLogistics_xlsx, String fileNewOrder_xlsx) {

		String s_date = de.leou.util.DT.getCurrentDataString("MMdd_HHmm");
		fileNewOrder_xlsx = fileNewOrder_xlsx.replace("$DATE$", s_date);
		FxMainApp.sysParams.setOrder_logistic_xlsx(fileNewOrder_xlsx);

		/* get logistics indexed matrix */
		Bean_IndexedMatrix imx_logis = null;
		try {
			FileInputStream in;
			in = new FileInputStream(fileLogistics_xlsx);
			XSSFWorkbook wb0 = new XSSFWorkbook(in);
			XSSFSheet sheet0 = wb0.getSheetAt(0);
			imx_logis = UtilsExcel.bulidIndexedMatrix(sheet0);
//			HashMap<String, Integer> mm= imx_logis.getHeader();
//			for (String key : mm.keySet()) {
//				System.out.println(key+"\t"+mm.get(key));
//			}
			HashMap<String, Integer> mm = imx_logis.getIndex();
			for (String key : mm.keySet()) {
				System.out.println(key + "\t" + mm.get(key));
			}
			wb0.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			ta_result.appendText(e1.getLocalizedMessage() + "\r\n");
			e1.printStackTrace();
		}

		// 创建一个工作簿 即excel文件,再在该文件中创建一个sheet
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("sheet");

		String csv_row;
		String[] data = null;
		try {

			BufferedReader csvReader = new BufferedReader(new FileReader(fileOldOrders_csv));
			int row_i = 0;

			DataFormat fmt = wb.createDataFormat();
			XSSFCellStyle cellStyle = wb.createCellStyle();

			while ((csv_row = csvReader.readLine()) != null) {
				data = csv_row.split(";");
				// do something with the data
				// sheet中创建一行
				XSSFRow row = sheet.createRow(row_i);
				row_i++;
				// source-file: paketInfo_csv
				// 0.col OrderItem.warehouseId -> s_logistics_index
				// 2.col Variation.number -> s_sku
				// 16.col Variation.number -> s_country
				// 25.col Order.referrerId -> s_shopID

				String s_logistics_index = null;
				String s_sku = null;
				String s_shopID = null;
				String s_country = null;
				String s_shop_country = null;

				for (int i = 0; i < data.length; i++) {
					// convert to string, delete all "
					String valus = data[i].replaceAll("\"", "");
					switch (i) {
					case 0:
						s_logistics_index = valus;
						break;
					case 7:
						s_sku = valus;
						break;
					case 2:
						s_country = valus;
						break;
					case 25:
						s_shopID = valus;
						break;
					default:
						break;
					}
					XSSFCell cell = row.createCell(i);
					cell.setCellValue(valus);
					cellStyle.setDataFormat(fmt.getFormat("@"));
					cell.setCellStyle(cellStyle);
				}

				/* through logistics_xlsx get logistic for order(SKU country shopID) */
				// for ebay.de
				if (s_shopID.equals("2.08")) {
					s_shop_country = "EBAY.DE";
				} else {
					s_shop_country = s_country;
				}
				System.out.println("--------------");
				System.out.println(s_logistics_index);
				System.out.println(s_sku);
				System.out.println(s_country);
				System.out.println(s_shopID);
				
				System.out.println(imx_logis.getHeader().get(s_shop_country));
				System.out.println(s_shopID);
				System.out.println(s_country);
				System.out.println(s_sku);
				System.out.println(imx_logis.getIndex().get(s_sku));
				System.out.println("--------------");

				if ((imx_logis.getHeader().get(s_shop_country) != null) && (s_shopID != null) && (s_country != null)
						&& (imx_logis.getIndex().get(s_sku) != null)) {
					// get row
					int i_row_logistics = imx_logis.getIndex().get(s_sku);
					// get col
					int i_col_logistics = imx_logis.getHeader().get(s_shop_country);

					// get row value
					String[] ss_row = imx_logis.getRows().get(i_row_logistics);

					// get cell value
					s_logistics_index = ss_row[i_col_logistics];
					System.out.println(s_logistics_index);
					System.out.println(Arrays.toString(ss_row));
				}
				row.getCell(0).setCellValue(s_logistics_index);

			}
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ta_result.appendText(e.getLocalizedMessage() + "\r\n");
			e.printStackTrace();
		}

		// 最后写回磁盘
		FileOutputStream out;
		try {
			out = new FileOutputStream(fileNewOrder_xlsx);
			wb.write(out);
			out.close();
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ta_result.appendText(e.getLocalizedMessage());
			e.printStackTrace();
		}

		ta_param.setText("order_logistic.xlsx: " + fileNewOrder_xlsx + "\r\n");
		ta_result.appendText(DT.getCurrentTimestampString() + "\r\n Create file successful! " + fileNewOrder_xlsx
				+ "\r\n" + " 请检查此文件中的 地址信息 物流信息 是否正确，可修改！\r\n"
				+ " Please check the address and logistics information! \r\n \r\n");

	}

}
