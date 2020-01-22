/**
 * 
 */
package de.leou.dataCamel.m;

/**
 * @author zhoule6
 *
 */
public class Bean_PM_orderPK_csv {
	public static String HEADER = "Order_id;OrderItem_quantity;Variation_number;OrderItem_referrerName;OrderItem_warehouseId";

	public Bean_PM_orderPK_csv(String line_text) {
		// TODO Auto-generated constructor stub
		line_text += "#";
		String[] ss_line_text = line_text.split(";");
		Order_id = ss_line_text[0];
		OrderItem_quantity = ss_line_text[1];
		Variation_number = ss_line_text[2];
		OrderItem_referrerName = ss_line_text[3];
		OrderItem_warehouseId = ss_line_text[4];

	}

	private String Order_id;
	private String OrderItem_quantity;
	private String Variation_number;
	private String OrderItem_referrerName;
	private String OrderItem_warehouseId;

	public String getOrder_id() {
		return Order_id;
	}

	public void setOrder_id(String order_id) {
		Order_id = order_id;
	}

	public String getOrderItem_quantity() {
		return OrderItem_quantity;
	}

	public void setOrderItem_quantity(String orderItem_quantity) {
		OrderItem_quantity = orderItem_quantity;
	}

	public String getVariation_number() {
		return Variation_number;
	}

	public void setVariation_number(String variation_number) {
		Variation_number = variation_number;
	}

	public String getOrderItem_referrerName() {
		return OrderItem_referrerName;
	}

	public void setOrderItem_referrerName(String orderItem_referrerName) {
		OrderItem_referrerName = orderItem_referrerName;
	}

	public String getOrderItem_warehouseId() {
		return OrderItem_warehouseId;
	}

	public void setOrderItem_warehouseId(String orderItem_warehouseId) {
		OrderItem_warehouseId = orderItem_warehouseId;
	}

}
