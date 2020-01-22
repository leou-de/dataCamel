package de.leou.dataCamel;

import javafx.fxml.FXML;

import de.leou.dataCamel.c.Ctrl_order;
import de.leou.dataCamel.c.Ctrl_orderLogistic;
import de.leou.util.UtilsFile;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

public class FxMainWindowController {

	@FXML
	private TextArea ta_param;
	@FXML
	private TextArea ta_result;

	///////////////////////////////////////////
	// initial split parameter
	String order_logistic_xlsx = FxMainApp.sysParams.getOrder_logistic_xlsx();

	String bsp_logi_DHL_csv = FxMainApp.sysParams.getBsp_logi_DHL_csv();
	String bsp_logi_DHL_csv_sem = FxMainApp.sysParams.getBsp_logi_DHL_csv();
	String bsp_logi_DHL_csv_sep = FxMainApp.sysParams.getBsp_logi_DHL_csv();
	String bsp_logi_EDA_xls = FxMainApp.sysParams.getBsp_logi_EDA_xls();
	String bsp_logi_HYU_xlsx = FxMainApp.sysParams.getBsp_logi_HYU_xlsx();
	String bsp_logi_FBA_xlsx = FxMainApp.sysParams.getBsp_logi_FBA_xlsx();

	String logi_DHL_csv = FxMainApp.sysParams.getLogi_DHL_csv();
	String logi_DHL_csv_sem = FxMainApp.sysParams.getLogi_DHL_csv_sem();
	String logi_DHL_csv_sep = FxMainApp.sysParams.getLogi_DHL_csv_sep();
	String logi_DHL_csv_header = FxMainApp.sysParams.getLogi_DHL_csv_header();

	String logi_EDA_xls = FxMainApp.sysParams.getLogi_EDA_xls();
	String logi_EDA_xls_header = FxMainApp.sysParams.getLogi_EDA_xls_header();

	String logi_FBA_xls = FxMainApp.sysParams.getLogi_FBA_xls();
	String logi_FBA_xls_header = FxMainApp.sysParams.getLogi_FBA_xls_header();

	String logi_HYU_xlsx = FxMainApp.sysParams.getLogi_HYU_xlsx();
	String logi_FBA_xlsx = FxMainApp.sysParams.getLogi_FBA_xlsx();
	
	String pm_ex_orderPK_url = FxMainApp.sysParams.getPm_ex_orderPK_url();
	String pm_ex_orderPK_filename = FxMainApp.sysParams.getPm_ex_orderPK_filename();
	
	
	

	/*******************************************
	 * input: PM_orders.csv, logistics.xlsx
	 * 
	 * output: orders.xlsx with correct logistics
	 */
	@FXML
	public void act_bt01() {

		Ctrl_order orderC = new Ctrl_order();
		orderC.updateWithLogistic(ta_param, ta_result, FxMainApp.sysParams.getOrder_csv(),
				FxMainApp.sysParams.getProduct_logistics_xlsx(), FxMainApp.sysParams.getOrder_logistic_xlsx());

	}

	/*
	 * split order_logistic file to DHL,EDA,HYU.....
	 */
	@FXML
	public void act_bt02() {

		// split order_logistic file to DHL,EDA,HYU.....
		Ctrl_orderLogistic orderLogisticC = new Ctrl_orderLogistic();
		orderLogisticC.split(ta_param, ta_result, order_logistic_xlsx, bsp_logi_DHL_csv, bsp_logi_DHL_csv_sep,
				bsp_logi_DHL_csv_sem, bsp_logi_EDA_xls, bsp_logi_HYU_xlsx, bsp_logi_FBA_xlsx, logi_DHL_csv,
				logi_DHL_csv_sep, logi_DHL_csv_sem, logi_DHL_csv_header, logi_EDA_xls, logi_EDA_xls_header,
				logi_FBA_xls, logi_FBA_xls_header, logi_HYU_xlsx, logi_FBA_xlsx);

	}

	@FXML
	public void act_bt03() {
	}

	@FXML
	public void act_bt_download_OrderPK_csv(ActionEvent event) {

		UtilsFile.urlToFile(pm_ex_orderPK_url, pm_ex_orderPK_filename);

	}
}
