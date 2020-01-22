package de.leou.dataCamel.c;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import de.leou.dataCamel.FxMainApp;
import de.leou.dataCamel.m.Bean_PM_order;
import de.leou.dataCamel.m.Bean_logi_DHL_csv;
import de.leou.dataCamel.m.Bean_logi_EDA_xls;
import de.leou.dataCamel.m.Bean_logi_FBA_xls;
import javafx.scene.control.TextArea;

public class Ctrl_orderLogistic {
	public Ctrl_orderLogistic() {
		// TODO Auto-generated constructor stub
	}

	public void split(TextArea ta_param, TextArea ta_result, String order_logistic_xlsx, String bsp_logi_DHL_csv,
			String bsp_logi_DHL_csv_sep, String bsp_logi_DHL_csv_sem, String bsp_logi_EDA_xls, String bsp_logi_HYU_xlsx,
			String bsp_logi_FBA_xlsx, String logi_DHL_csv, String logi_DHL_csv_sep, String logi_DHL_csv_sem,
			String logi_DHL_csv_header, String logi_EDA_xls, String logi_EDA_xls_header, String logi_FBA_xls,
			String logi_FBA_xls_header, String logi_HYU_xlsx, String logi_FBA_xlsx) {

		// update logi_DHL_csv... with date
		String s_date = de.leou.util.DT.getCurrentDataString("MMdd_HHmm");
		logi_DHL_csv = logi_DHL_csv.replace("$DATE$", s_date);
		logi_EDA_xls = logi_EDA_xls.replace("$DATE$", s_date);
		logi_FBA_xls = logi_FBA_xls.replace("$DATE$", s_date);

		logi_HYU_xlsx = logi_HYU_xlsx.replace("$DATE$", s_date);
		logi_FBA_xlsx = logi_FBA_xlsx.replace("$DATE$", s_date);

		FxMainApp.sysParams.setLogi_DHL_csv(logi_DHL_csv);
		FxMainApp.sysParams.setLogi_EDA_xls(logi_EDA_xls);

		FxMainApp.sysParams.setLogi_FBA_xlsx(logi_FBA_xlsx);
		FxMainApp.sysParams.setLogi_HYU_xlsx(logi_HYU_xlsx);

//		// muster logi file copy to ...
//		try {
//			Files.copy(new File(bsp_logi_DHL_csv).toPath(), new File(logi_DHL_csv).toPath());
//			Files.copy(new File(bsp_logi_EDA_xls).toPath(), new File(logi_EDA_xls).toPath());
//			Files.copy(new File(bsp_logi_HYU_xlsx).toPath(), new File(logi_HYU_xlsx).toPath());
//			Files.copy(new File(bsp_logi_FBA_xlsx).toPath(), new File(logi_FBA_xlsx).toPath());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			ta_result.appendText(e.getLocalizedMessage());
//			e.printStackTrace();
//		}

		// logi_DHL_csv
		try {
			// open order_logistic file
			FileInputStream in;
			in = new FileInputStream(order_logistic_xlsx);
			XSSFWorkbook workbook = new XSSFWorkbook(in);
			Sheet sheet_order_logistic = workbook.getSheetAt(0);

			// BufferedWriter logi_DHL_csv
			BufferedWriter bw_logi_DHL_csv = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(logi_DHL_csv), "UTF-8"));
			bw_logi_DHL_csv.write('\ufeff');// Avoid excel garbled
			bw_logi_DHL_csv.write(Bean_logi_DHL_csv.HEADER + "\r\n");

			// new EDA sheet
			HSSFWorkbook workbook_EDA = new HSSFWorkbook();
			HSSFSheet sheet_EDA = workbook_EDA.createSheet("Order List");
			DataFormat fmt_EDA = workbook_EDA.createDataFormat();
			HSSFCellStyle cellStyle_EDA = workbook_EDA.createCellStyle();
			// build EDA_xls header
			Bean_logi_EDA_xls.build_xls_row_header(sheet_EDA, fmt_EDA, cellStyle_EDA);

			// new FBA sheet
			HSSFWorkbook workbook_FBA = new HSSFWorkbook();
			HSSFSheet sheet_FBA = workbook_FBA.createSheet("Order List");
			DataFormat fmt_FBA = workbook_FBA.createDataFormat();
			HSSFCellStyle cellStyle_FBA = workbook_FBA.createCellStyle();
			// build FBA_xls header
			Bean_logi_FBA_xls.build_xls_row_header(sheet_FBA, fmt_FBA, cellStyle_FBA);

			// read order_logistic file
			int rows = sheet_order_logistic.getPhysicalNumberOfRows();
			// 2 行开始
			int i_row_eda = 1;
			int i_row_fba = 1;

			for (int i_row = 1; i_row < rows; i_row++) {
				Row order_row = sheet_order_logistic.getRow(i_row);
				// build beanOrder with row
				Bean_PM_order beanOrder = new Bean_PM_order(order_row);
				// System.out.println(beanOrder.toString());
				System.out.println(i_row + "-------------------------------------");

				// build row for logi_DHL_csv
				if (beanOrder.getLogistic() != null && beanOrder.getLogistic().trim().equals("DHL")) {
					String dhl_row = new Bean_logi_DHL_csv(beanOrder).bulid_csv_row();
					bw_logi_DHL_csv.write(dhl_row + "\r\n");
				}

				// build row for logi_EDA_xls
				if (beanOrder.getLogistic() != null && beanOrder.getLogistic().contains("EDA")) {
					Bean_logi_EDA_xls.build_xls_row(beanOrder, i_row_eda, sheet_EDA, fmt_EDA, cellStyle_EDA);
					i_row_eda++;
				}

				// build row for logi_FBA_xls
				if (beanOrder.getLogistic() != null && beanOrder.getLogistic().contains("FBA")) {
					Bean_logi_FBA_xls.build_xls_row(beanOrder, i_row_fba, sheet_FBA, fmt_FBA, cellStyle_FBA);
					i_row_fba++;
				}

			}
			in.close();

			// flush write DHL_csv
			bw_logi_DHL_csv.flush();
			bw_logi_DHL_csv.close();

			// flush write EDA_xls
			FileOutputStream out_EDA;
			out_EDA = new FileOutputStream(logi_EDA_xls);
			workbook_EDA.write(out_EDA);
			out_EDA.close();
			workbook_EDA.close();

			// flush write EDA_xls
			FileOutputStream out_FBA;
			out_FBA = new FileOutputStream(logi_FBA_xls);
			workbook_FBA.write(out_FBA);
			out_FBA.close();
			workbook_FBA.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
