package de.leou.dataCamel.m;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

public class SysParams {

	private String separator;
	private String lang;
	private String syspath;

	private String order_csv;
	private String order_csv_sep;
	private String order_csv_sem;
	private String order_csv_header;

	private String order_logistic_xlsx;
	private String order_logistic_xlsx_header;

	private String product_logistics_xlsx;
	private String product_logistics_xlsx_header;

	private String bsp_logi_DHL_csv;
	private String bsp_logi_DHL_csv_sep;
	private String bsp_logi_DHL_csv_sem;

	private String bsp_logi_EDA_xls;
	private String bsp_logi_HYU_xlsx;
	private String bsp_logi_FBA_xlsx;

	private String logi_DHL_csv;
	private String logi_DHL_csv_sep;
	private String logi_DHL_csv_sem;
	private String logi_DHL_csv_header;

	private String logi_EDA_xls;
	private String logi_EDA_xls_header;

	private String logi_FBA_xls;
	private String logi_FBA_xls_header;
	
	private String logi_HYU_xlsx;
	private String logi_FBA_xlsx;
	
	
	
	private String pm_ex_orderPK_url;
	private String pm_ex_orderPK_filename;
	
	

	/* test */
	public static void main(String[] args) {
		SysParams c = new SysParams();
		System.out.println(c.getSeparator());
		System.out.println(c.getLang());
		System.out.println(c.getSyspath());

	}

	public SysParams(String fullFileName) {
		this.readSysParamsFile(this, fullFileName);
	}

	public SysParams() {
		this.readSysParamsFile(this, "c:/sysParams.ini");
	}

	/* Innate function */
	public void readSysParamsFile(SysParams c, String fullFileName) {
		// TODO Auto-generated method stub
		Stream<String> stream = null;
		try {
			stream = Files.lines(Paths.get(fullFileName), StandardCharsets.UTF_8);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Iterator<String> it = stream.iterator();
		c.setSeparator(it.next());
		while (it.hasNext()) {
			String s = (String) it.next();
			String[] ss = s.split(c.getSeparator());

			// if length !=2 continue while
			if (ss.length != 2)
				continue;

			String chara = ss[0].trim();
			String value = ss[1].trim();

			chara = chara.substring(0, 1).toUpperCase() + chara.substring(1);
			try {
				c.getClass().getMethod("set" + chara, new Class[] { String.class }).invoke(c, new Object[] { value });
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	// stream.forEach(s -> contentBuilder.append(s).append("\n"));

	/* get set */

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getSyspath() {
		return syspath;
	}

	public void setSyspath(String syspath) {
		this.syspath = syspath;
	}

	public String getOrder_csv() {
		return order_csv;
	}

	public void setOrder_csv(String order_csv) {
		this.order_csv = order_csv;
	}

	public String getOrder_csv_sep() {
		return order_csv_sep;
	}

	public void setOrder_csv_sep(String order_csv_sep) {
		this.order_csv_sep = order_csv_sep;
	}

	public String getOrder_csv_sem() {
		return order_csv_sem;
	}

	public void setOrder_csv_sem(String order_csv_sem) {
		this.order_csv_sem = order_csv_sem;
	}

	public String getOrder_csv_header() {
		return order_csv_header;
	}

	public void setOrder_csv_header(String order_csv_header) {
		this.order_csv_header = order_csv_header;
	}

	public String getOrder_logistic_xlsx() {
		return order_logistic_xlsx;
	}

	public void setOrder_logistic_xlsx(String order_logistic_xlsx) {
		this.order_logistic_xlsx = order_logistic_xlsx;
	}

	public String getOrder_logistic_xlsx_header() {
		return order_logistic_xlsx_header;
	}

	public void setOrder_logistic_xlsx_header(String order_logistic_xlsx_header) {
		this.order_logistic_xlsx_header = order_logistic_xlsx_header;
	}

	public String getProduct_logistics_xlsx() {
		return product_logistics_xlsx;
	}

	public void setProduct_logistics_xlsx(String product_logistics_xlsx) {
		this.product_logistics_xlsx = product_logistics_xlsx;
	}

	public String getProduct_logistics_xlsx_header() {
		return product_logistics_xlsx_header;
	}

	public void setProduct_logistics_xlsx_header(String product_logistics_xlsx_header) {
		this.product_logistics_xlsx_header = product_logistics_xlsx_header;
	}

	public String getBsp_logi_DHL_csv() {
		return bsp_logi_DHL_csv;
	}

	public void setBsp_logi_DHL_csv(String bsp_logi_DHL_csv) {
		this.bsp_logi_DHL_csv = bsp_logi_DHL_csv;
	}

	public String getBsp_logi_EDA_xls() {
		return bsp_logi_EDA_xls;
	}

	public void setBsp_logi_EDA_xls(String bsp_logi_EDA_xls) {
		this.bsp_logi_EDA_xls = bsp_logi_EDA_xls;
	}

	public String getBsp_logi_HYU_xlsx() {
		return bsp_logi_HYU_xlsx;
	}

	public void setBsp_logi_HYU_xlsx(String bsp_logi_HYU_xlsx) {
		this.bsp_logi_HYU_xlsx = bsp_logi_HYU_xlsx;
	}

	public String getBsp_logi_FBA_xlsx() {
		return bsp_logi_FBA_xlsx;
	}

	public void setBsp_logi_FBA_xlsx(String bsp_logi_FBA_xlsx) {
		this.bsp_logi_FBA_xlsx = bsp_logi_FBA_xlsx;
	}

	public String getLogi_DHL_csv() {
		return logi_DHL_csv;
	}

	public void setLogi_DHL_csv(String logi_DHL_csv) {
		this.logi_DHL_csv = logi_DHL_csv;
	}

	public String getLogi_EDA_xls() {
		return logi_EDA_xls;
	}

	public void setLogi_EDA_xls(String logi_EDA_xls) {
		this.logi_EDA_xls = logi_EDA_xls;
	}

	public String getLogi_HYU_xlsx() {
		return logi_HYU_xlsx;
	}

	public void setLogi_HYU_xlsx(String logi_HYU_xlsx) {
		this.logi_HYU_xlsx = logi_HYU_xlsx;
	}

	public String getLogi_FBA_xlsx() {
		return logi_FBA_xlsx;
	}

	public void setLogi_FBA_xlsx(String logi_FBA_xlsx) {
		this.logi_FBA_xlsx = logi_FBA_xlsx;
	}

	public String getBsp_logi_DHL_csv_sep() {
		return bsp_logi_DHL_csv_sep;
	}

	public void setBsp_logi_DHL_csv_sep(String bsp_logi_DHL_csv_sep) {
		this.bsp_logi_DHL_csv_sep = bsp_logi_DHL_csv_sep;
	}

	public String getBsp_logi_DHL_csv_sem() {
		return bsp_logi_DHL_csv_sem;
	}

	public void setBsp_logi_DHL_csv_sem(String bsp_logi_DHL_csv_sem) {
		this.bsp_logi_DHL_csv_sem = bsp_logi_DHL_csv_sem;
	}

	public String getLogi_DHL_csv_sep() {
		return logi_DHL_csv_sep;
	}

	public void setLogi_DHL_csv_sep(String logi_DHL_csv_sep) {
		this.logi_DHL_csv_sep = logi_DHL_csv_sep;
	}

	public String getLogi_DHL_csv_sem() {
		return logi_DHL_csv_sem;
	}

	public void setLogi_DHL_csv_sem(String logi_DHL_csv_sem) {
		this.logi_DHL_csv_sem = logi_DHL_csv_sem;
	}

	public String getLogi_DHL_csv_header() {
		return logi_DHL_csv_header;
	}

	public void setLogi_DHL_csv_header(String logi_DHL_csv_header) {
		this.logi_DHL_csv_header = logi_DHL_csv_header;
	}

	public String getLogi_EDA_xls_header() {
		return logi_EDA_xls_header;
	}

	public void setLogi_EDA_xls_header(String logi_EDA_xls_header) {
		this.logi_EDA_xls_header = logi_EDA_xls_header;
	}

	public String getLogi_FBA_xls() {
		return logi_FBA_xls;
	}

	public void setLogi_FBA_xls(String logi_FBA_xls) {
		this.logi_FBA_xls = logi_FBA_xls;
	}

	public String getLogi_FBA_xls_header() {
		return logi_FBA_xls_header;
	}

	public void setLogi_FBA_xls_header(String logi_FBA_xls_header) {
		this.logi_FBA_xls_header = logi_FBA_xls_header;
	}

	public String getPm_ex_orderPK_url() {
		return pm_ex_orderPK_url;
	}

	public void setPm_ex_orderPK_url(String pm_ex_orderPK_url) {
		this.pm_ex_orderPK_url = pm_ex_orderPK_url;
	}

	public String getPm_ex_orderPK_filename() {
		return pm_ex_orderPK_filename;
	}

	public void setPm_ex_orderPK_filename(String pm_ex_orderPK_filename) {
		this.pm_ex_orderPK_filename = pm_ex_orderPK_filename;
	}

}
