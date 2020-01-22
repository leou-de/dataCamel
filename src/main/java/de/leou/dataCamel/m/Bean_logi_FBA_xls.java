package de.leou.dataCamel.m;

import java.lang.reflect.InvocationTargetException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import de.leou.util.CN;
import de.leou.util.DT;

public class Bean_logi_FBA_xls {
	public static String HEADER = "A_订单编号;B_客户名称;C_订单日期;D_销售渠道编号;E_发货仓库编号;F_派送方式名称;G_是否挂号;H_收货人;I_街道一;J_街道二;K_省份;L_城市;M_邮编;N_国家名称;O_国家代码;P_Email;Q_客户电话;R_税号;S_是否投保;T_亚马逊FBA仓库代码;U_商品1(SKU码);V_商品1数量;W_商品2(SKU码);X_商品2数量;Y_商品3(SKU码);Z_商品3数量;AA_商品4(SKU码);AB_商品4数量;AC_商品5(SKU码);AD_商品5数量;AE_商品6(SKU码);AF_商品6数量;AG_商品7(SKU码);AH_商品7数量;AI_商品8(SKU码);AJ_商品8数量;AK_商品9(SKU码);AL_商品9数量;AM_商品10(SKU码);AN_商品10数量";

	public Bean_logi_FBA_xls() {
		// TODO Auto-generated constructor stub
	}

	public Bean_logi_FBA_xls(Bean_PM_order o) {
		this.A = o.getOrder_id();
		this.B = o.getDeliveryAddress_name2() + " " + o.getDeliveryAddress_name3();
		this.C = DT.getCurrentDataString("yyyy-MM-dd");
		this.D = "1";
		this.E = "DE";
		this.F = o.getLogistic().replace("EDA-", "");
		this.G = "2";
		this.H = o.getDeliveryAddress_name2() + " " + o.getDeliveryAddress_name3() + "" + o.getDeliveryAddress_name1();
		if (o.getDeliveryAddressCountry_isoCode2().equals("FR")) {
			this.I = o.getDeliveryAddress_address2() + " " + o.getDeliveryAddress_address1();
		} else
			this.I = o.getDeliveryAddress_address1() + " " + o.getDeliveryAddress_address2();
		this.J = o.getDeliveryAddress_address3() + " " + o.getDeliveryAddress_address4();
		this.L = o.getDeliveryAddress_town();
		this.M = o.getDeliveryAddress_postalCode();
		this.N = CN.getFullname(o.getDeliveryAddressCountry_isoCode2());
		this.O = o.getDeliveryAddressCountry_isoCode2();
		this.P = o.getDeliveryAddress_email();
		this.Q = o.getDeliveryAddress_phone();
		this.S = "2";
		this.U = o.getVariation_number();
		this.V = o.getOrderItem_quantity();
	}

	// build header row
	public static void build_xls_row_header(HSSFSheet sheet_EDA, DataFormat fmt_EDA, HSSFCellStyle cellStyle_EDA) {
		HSSFRow row_EDA = sheet_EDA.createRow(0);
		String[] ss_header = Bean_logi_EDA_xls.HEADER.split(";");
		for (int k = 0; k < ss_header.length; k++) {
			HSSFCell cell = row_EDA.createCell(k);
			cell.setCellValue(ss_header[k]);
			cellStyle_EDA.setDataFormat(fmt_EDA.getFormat("@"));
			cell.setCellStyle(cellStyle_EDA);
		}
	}

	public static void build_xls_row(Bean_PM_order beanOrder, int i_row, HSSFSheet sheet_EDA, DataFormat fmt_EDA,
			HSSFCellStyle cellStyle_EDA) {
		// TODO Auto-generated method stub
		HSSFRow row_EDA = sheet_EDA.createRow(i_row);
		String[] ss_header = Bean_logi_EDA_xls.HEADER.split(";");
		Bean_logi_EDA_xls b = new Bean_logi_EDA_xls(beanOrder);

		int cols = ss_header.length;
		for (int j = 0; j < cols; j++) {
			String header = ss_header[j];

			// build method name() with header
			String methodName = "get" + header.substring(0, header.indexOf("_"));

			try {

				String value = (String) b.getClass().getMethod(methodName, new Class[] {}).invoke(b, new Object[] {});
				if (methodName.equals("getS")) {// date
					// 在写入 日期格式的 数据需要进行特殊处理(这是一种 简单的处理方式)
					CreationHelper createHelper = sheet_EDA.getWorkbook().getCreationHelper();
//					HSSFCellStyle style=wb.createCellStyle();
					HSSFCell cell = row_EDA.createCell(j);

					cellStyle_EDA.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));
					cell.setCellValue(value);
					cell.setCellStyle(cellStyle_EDA);

				} else {
					HSSFCell cell = row_EDA.createCell(j);
					cell.setCellValue(value);
					cellStyle_EDA.setDataFormat(fmt_EDA.getFormat("@"));
					cell.setCellStyle(cellStyle_EDA);
				}
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

	private String A;
	private String B;
	private String C;
	private String D;
	private String E;
	private String F;
	private String G;
	private String H;
	private String I;
	private String J;
	private String K;
	private String L;
	private String M;
	private String N;
	private String O;
	private String P;
	private String Q;
	private String R;
	private String S;
	private String T;
	private String U;
	private String V;
	private String W;
	private String X;
	private String Y;
	private String Z;
	private String AA;
	private String AB;
	private String AC;
	private String AD;
	private String AE;
	private String AF;
	private String AG;
	private String AH;
	private String AI;
	private String AJ;
	private String AK;
	private String AL;
	private String AM;
	private String AN;

	public String getA() {
		return A;
	}

	public void setA(String a) {
		A = a;
	}

	public String getB() {
		return B;
	}

	public void setB(String b) {
		B = b;
	}

	public String getC() {
		return C;
	}

	public void setC(String c) {
		C = c;
	}

	public String getD() {
		return D;
	}

	public void setD(String d) {
		D = d;
	}

	public String getE() {
		return E;
	}

	public void setE(String e) {
		E = e;
	}

	public String getF() {
		return F;
	}

	public void setF(String f) {
		F = f;
	}

	public String getG() {
		return G;
	}

	public void setG(String g) {
		G = g;
	}

	public String getH() {
		return H;
	}

	public void setH(String h) {
		H = h;
	}

	public String getI() {
		return I;
	}

	public void setI(String i) {
		I = i;
	}

	public String getJ() {
		return J;
	}

	public void setJ(String j) {
		J = j;
	}

	public String getK() {
		return K;
	}

	public void setK(String k) {
		K = k;
	}

	public String getL() {
		return L;
	}

	public void setL(String l) {
		L = l;
	}

	public String getM() {
		return M;
	}

	public void setM(String m) {
		M = m;
	}

	public String getN() {
		return N;
	}

	public void setN(String n) {
		N = n;
	}

	public String getO() {
		return O;
	}

	public void setO(String o) {
		O = o;
	}

	public String getP() {
		return P;
	}

	public void setP(String p) {
		P = p;
	}

	public String getQ() {
		return Q;
	}

	public void setQ(String q) {
		Q = q;
	}

	public String getR() {
		return R;
	}

	public void setR(String r) {
		R = r;
	}

	public String getS() {
		return S;
	}

	public void setS(String s) {
		S = s;
	}

	public String getT() {
		return T;
	}

	public void setT(String t) {
		T = t;
	}

	public String getU() {
		return U;
	}

	public void setU(String u) {
		U = u;
	}

	public String getV() {
		return V;
	}

	public void setV(String v) {
		V = v;
	}

	public String getW() {
		return W;
	}

	public void setW(String w) {
		W = w;
	}

	public String getX() {
		return X;
	}

	public void setX(String x) {
		X = x;
	}

	public String getY() {
		return Y;
	}

	public void setY(String y) {
		Y = y;
	}

	public String getZ() {
		return Z;
	}

	public void setZ(String z) {
		Z = z;
	}

	public String getAA() {
		return AA;
	}

	public void setAA(String aA) {
		AA = aA;
	}

	public String getAB() {
		return AB;
	}

	public void setAB(String aB) {
		AB = aB;
	}

	public String getAC() {
		return AC;
	}

	public void setAC(String aC) {
		AC = aC;
	}

	public String getAD() {
		return AD;
	}

	public void setAD(String aD) {
		AD = aD;
	}

	public String getAE() {
		return AE;
	}

	public void setAE(String aE) {
		AE = aE;
	}

	public String getAF() {
		return AF;
	}

	public void setAF(String aF) {
		AF = aF;
	}

	public String getAG() {
		return AG;
	}

	public void setAG(String aG) {
		AG = aG;
	}

	public String getAH() {
		return AH;
	}

	public void setAH(String aH) {
		AH = aH;
	}

	public String getAI() {
		return AI;
	}

	public void setAI(String aI) {
		AI = aI;
	}

	public String getAJ() {
		return AJ;
	}

	public void setAJ(String aJ) {
		AJ = aJ;
	}

	public String getAK() {
		return AK;
	}

	public void setAK(String aK) {
		AK = aK;
	}

	public String getAL() {
		return AL;
	}

	public void setAL(String aL) {
		AL = aL;
	}

	public String getAM() {
		return AM;
	}

	public void setAM(String aM) {
		AM = aM;
	}

	public String getAN() {
		return AN;
	}

	public void setAN(String aN) {
		AN = aN;
	}

}
