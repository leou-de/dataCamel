package de.leou.dataCamel.m;

import java.lang.reflect.InvocationTargetException;


public class Bean_PM_order {

	private String Header = "Logistic;Order.id;DeliveryAddressCountry.isoCode2;ExtOrder.ID;OrderItem.referrerName;OrderItem.quantity;Variation.weightG;Variation.number;DeliveryAddress.name1;DeliveryAddress.name2;DeliveryAddress.name3;DeliveryAddress.name4;DeliveryAddress.postident;DeliveryAddress.address1;DeliveryAddress.address2;DeliveryAddress.houseNumber;DeliveryAddress.address3;DeliveryAddress.address4;DeliveryAddress.postalCode;DeliveryAddress.town;DeliveryAddress.isPostfiliale;DeliveryAddress.isPackstation;DeliveryAddress.email;DeliveryAddress.phone;OrderItem.position;Order.referrerId;OrderDate.date;Order.typeId;OrderItem.id;OrderItem.referrerId;OrderItem.typeId;DeliveryAddress.careOf;DeliveryAddress.fsk;OrderItem.warehouseId;DeliveryAddress.id;DeliveryAddressState.id;DeliveryAddressState.isoCode;Variation.id;DeliveryAddressState.isoCode3166;Item.flagOne;Item.flagTwo;Item.id;Order.locationId;Order.statusId;OrderItem.itemVariationId;OrderParcelService.backendName;OrderParcelServicePreset.alternativePhone;VariationBarcode.code;date";

	private String Logistic;
	private String Order_id;
	private String DeliveryAddressCountry_isoCode2;
	private String ExtOrder_ID;
	private String OrderItem_referrerName;
	private String OrderItem_quantity;
	private String Variation_weightG;
	private String Variation_number;
	private String DeliveryAddress_name1;
	private String DeliveryAddress_name2;
	private String DeliveryAddress_name3;
	private String DeliveryAddress_name4;
	private String DeliveryAddress_postident;
	private String DeliveryAddress_address1;
	private String DeliveryAddress_address2;
	private String DeliveryAddress_houseNumber;
	private String DeliveryAddress_address3;
	private String DeliveryAddress_address4;
	private String DeliveryAddress_postalCode;
	private String DeliveryAddress_town;
	private String DeliveryAddress_isPostfiliale;
	private String DeliveryAddress_isPackstation;
	private String DeliveryAddress_email;
	private String DeliveryAddress_phone;
	private String OrderItem_position;
	private String Order_referrerId;
	private String OrderDate_date;
	private String Order_typeId;
	private String OrderItem_id;
	private String OrderItem_referrerId;
	private String OrderItem_typeId;
	private String DeliveryAddress_careOf;
	private String DeliveryAddress_fsk;
	private String OrderItem_warehouseId;
	private String DeliveryAddress_id;
	private String DeliveryAddressState_id;
	private String DeliveryAddressState_isoCode;
	private String Variation_id;
	private String DeliveryAddressState_isoCode3166;
	private String Item_flagOne;
	private String Item_flagTwo;
	private String Item_id;
	private String Order_locationId;
	private String Order_statusId;
	private String OrderItem_itemVariationId;
	private String OrderParcelService_backendName;
	private String OrderParcelServicePreset_alternativePhone;
	private String VariationBarcode_code;
	private String date;

	@Override
	public String toString() {
		// TODO Auto-generated method stub

		return this.Logistic + "\t" + this.DeliveryAddressCountry_isoCode2 + "\t" + this.OrderItem_referrerName + "\t"
				+ this.Order_id + "\t" + this.OrderItem_quantity + "\t" + this.Variation_weightG + "\t"
				+ this.Variation_number + "\t" + this.DeliveryAddress_name1 + "\t" + this.DeliveryAddress_name2 + "\t"
				+ this.DeliveryAddress_name3 + "\t" + this.DeliveryAddress_name4 + "\t" + this.DeliveryAddress_postident
				+ "\t" + this.DeliveryAddress_address1 + "\t" + this.DeliveryAddress_address2 + "\t"
				+ this.DeliveryAddress_houseNumber + "\t" + this.DeliveryAddress_address3 + "\t"
				+ this.DeliveryAddress_address4 + "\t" + this.DeliveryAddress_postalCode + "\t"
				+ this.DeliveryAddress_town + "\t" + this.DeliveryAddress_isPostfiliale + "\t"
				+ this.DeliveryAddress_isPackstation + "\t" + this.DeliveryAddress_email + "\t"
				+ this.DeliveryAddress_phone + "\t" + this.OrderItem_position + "\t" + this.Order_referrerId + "\t"
				+ this.OrderDate_date + "\t" + this.Order_typeId + "\t" + this.OrderItem_id + "\t"
				+ this.OrderItem_referrerId + "\t" + this.OrderItem_typeId + "\t" + this.DeliveryAddress_careOf + "\t"
				+ this.DeliveryAddress_fsk + "\t" + this.OrderItem_warehouseId + "\t" + this.DeliveryAddress_id + "\t"
				+ this.DeliveryAddressState_id + "\t" + this.DeliveryAddressState_isoCode + "\t" + this.Variation_id
				+ "\t" + this.DeliveryAddressState_isoCode3166 + "\t" + this.Item_flagOne + "\t" + this.Item_flagTwo
				+ "\t" + this.Item_id + "\t" + this.Order_locationId + "\t" + this.Order_statusId + "\t" + "\t"
				+ this.OrderItem_itemVariationId + "\t" + "\t" + this.OrderParcelService_backendName + "\t"
				+ this.OrderParcelServicePreset_alternativePhone + "\t" + this.VariationBarcode_code + "\t" + this.date
				+ "\t";
	}

	public Bean_PM_order() {
		// TODO Auto-generated constructor stub
	}

	public Bean_PM_order(org.apache.poi.ss.usermodel.Row row) {
		// TODO Auto-generated constructor stub
		int cols = row.getPhysicalNumberOfCells();
		String[] ss_header = this.getHeader().split(";");
		for (int j = 0; j < cols; j++) {
			String header = ss_header[j];
			String value = row.getCell(j).getStringCellValue();

			// build method name() with header
			String methodName = header.substring(0, 1).toUpperCase() + header.substring(1);
			methodName = "set" + methodName.replace(".", "_");
			System.out.println(methodName);

			try {

				// value encoding UTF-8
			//	value = URLEncoder.encode(value, "UTF-8");

				this.getClass().getMethod(methodName, new Class[] { String.class }).invoke(this,
						new Object[] { value });
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
			System.out.print(row.getCell(j) + "\t");
		}
	}

	public String getLogistic() {
		return Logistic;
	}

	public void setLogistic(String logistic) {
		this.Logistic = logistic;
	}

	public String getDeliveryAddressCountry_isoCode2() {
		return DeliveryAddressCountry_isoCode2;
	}

	public void setDeliveryAddressCountry_isoCode2(String deliveryAddressCountry_isoCode2) {
		DeliveryAddressCountry_isoCode2 = deliveryAddressCountry_isoCode2;
	}

	public String getOrderItem_referrerName() {
		return OrderItem_referrerName;
	}

	public void setOrderItem_referrerName(String orderItem_referrerName) {
		OrderItem_referrerName = orderItem_referrerName;
	}

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

	public String getVariation_weightG() {
		return Variation_weightG;
	}

	public void setVariation_weightG(String variation_weightG) {
		Variation_weightG = variation_weightG;
	}

	public String getVariation_number() {
		return Variation_number;
	}

	public void setVariation_number(String variation_number) {
		Variation_number = variation_number;
	}

	public String getDeliveryAddress_name1() {
		return DeliveryAddress_name1;
	}

	public void setDeliveryAddress_name1(String deliveryAddress_name1) {
		DeliveryAddress_name1 = deliveryAddress_name1;
	}

	public String getDeliveryAddress_name2() {
		return DeliveryAddress_name2;
	}

	public void setDeliveryAddress_name2(String deliveryAddress_name2) {
		DeliveryAddress_name2 = deliveryAddress_name2;
	}

	public String getDeliveryAddress_name3() {
		return DeliveryAddress_name3;
	}

	public void setDeliveryAddress_name3(String deliveryAddress_name3) {
		DeliveryAddress_name3 = deliveryAddress_name3;
	}

	public String getDeliveryAddress_name4() {
		return DeliveryAddress_name4;
	}

	public void setDeliveryAddress_name4(String deliveryAddress_name4) {
		DeliveryAddress_name4 = deliveryAddress_name4;
	}

	public String getDeliveryAddress_postident() {
		return DeliveryAddress_postident;
	}

	public void setDeliveryAddress_postident(String deliveryAddress_postident) {
		DeliveryAddress_postident = deliveryAddress_postident;
	}

	public String getDeliveryAddress_address1() {
		return DeliveryAddress_address1;
	}

	public void setDeliveryAddress_address1(String deliveryAddress_address1) {
		DeliveryAddress_address1 = deliveryAddress_address1;
	}

	public String getDeliveryAddress_address2() {
		return DeliveryAddress_address2;
	}

	public void setDeliveryAddress_address2(String deliveryAddress_address2) {
		DeliveryAddress_address2 = deliveryAddress_address2;
	}

	public String getDeliveryAddress_houseNumber() {
		return DeliveryAddress_houseNumber;
	}

	public void setDeliveryAddress_houseNumber(String deliveryAddress_houseNumber) {
		DeliveryAddress_houseNumber = deliveryAddress_houseNumber;
	}

	public String getDeliveryAddress_address3() {
		return DeliveryAddress_address3;
	}

	public void setDeliveryAddress_address3(String deliveryAddress_address3) {
		DeliveryAddress_address3 = deliveryAddress_address3;
	}

	public String getDeliveryAddress_address4() {
		return DeliveryAddress_address4;
	}

	public void setDeliveryAddress_address4(String deliveryAddress_address4) {
		DeliveryAddress_address4 = deliveryAddress_address4;
	}

	public String getDeliveryAddress_postalCode() {
		return DeliveryAddress_postalCode;
	}

	public void setDeliveryAddress_postalCode(String deliveryAddress_postalCode) {
		DeliveryAddress_postalCode = deliveryAddress_postalCode;
	}

	public String getDeliveryAddress_town() {
		return DeliveryAddress_town;
	}

	public void setDeliveryAddress_town(String deliveryAddress_town) {
		DeliveryAddress_town = deliveryAddress_town;
	}

	public String getDeliveryAddress_isPostfiliale() {
		return DeliveryAddress_isPostfiliale;
	}

	public void setDeliveryAddress_isPostfiliale(String deliveryAddress_isPostfiliale) {
		DeliveryAddress_isPostfiliale = deliveryAddress_isPostfiliale;
	}

	public String getDeliveryAddress_isPackstation() {
		return DeliveryAddress_isPackstation;
	}

	public void setDeliveryAddress_isPackstation(String deliveryAddress_isPackstation) {
		DeliveryAddress_isPackstation = deliveryAddress_isPackstation;
	}

	public String getDeliveryAddress_email() {
		return DeliveryAddress_email;
	}

	public void setDeliveryAddress_email(String deliveryAddress_email) {
		DeliveryAddress_email = deliveryAddress_email;
	}

	public String getDeliveryAddress_phone() {
		return DeliveryAddress_phone;
	}

	public void setDeliveryAddress_phone(String deliveryAddress_phone) {
		DeliveryAddress_phone = deliveryAddress_phone;
	}

	public String getOrderItem_position() {
		return OrderItem_position;
	}

	public void setOrderItem_position(String orderItem_position) {
		OrderItem_position = orderItem_position;
	}

	public String getOrder_referrerId() {
		return Order_referrerId;
	}

	public void setOrder_referrerId(String order_referrerId) {
		Order_referrerId = order_referrerId;
	}

	public String getOrderDate_date() {
		return OrderDate_date;
	}

	public void setOrderDate_date(String orderDate_date) {
		OrderDate_date = orderDate_date;
	}

	public String getOrder_typeId() {
		return Order_typeId;
	}

	public void setOrder_typeId(String order_typeId) {
		Order_typeId = order_typeId;
	}

	public String getOrderItem_id() {
		return OrderItem_id;
	}

	public void setOrderItem_id(String orderItem_id) {
		OrderItem_id = orderItem_id;
	}

	public String getOrderItem_referrerId() {
		return OrderItem_referrerId;
	}

	public void setOrderItem_referrerId(String orderItem_referrerId) {
		OrderItem_referrerId = orderItem_referrerId;
	}

	public String getOrderItem_typeId() {
		return OrderItem_typeId;
	}

	public void setOrderItem_typeId(String orderItem_typeId) {
		OrderItem_typeId = orderItem_typeId;
	}

	public String getDeliveryAddress_careOf() {
		return DeliveryAddress_careOf;
	}

	public void setDeliveryAddress_careOf(String deliveryAddress_careOf) {
		DeliveryAddress_careOf = deliveryAddress_careOf;
	}

	public String getDeliveryAddress_fsk() {
		return DeliveryAddress_fsk;
	}

	public void setDeliveryAddress_fsk(String deliveryAddress_fsk) {
		DeliveryAddress_fsk = deliveryAddress_fsk;
	}

	public String getOrderItem_warehouseId() {
		return OrderItem_warehouseId;
	}

	public void setOrderItem_warehouseId(String orderItem_warehouseId) {
		OrderItem_warehouseId = orderItem_warehouseId;
	}

	public String getDeliveryAddress_id() {
		return DeliveryAddress_id;
	}

	public void setDeliveryAddress_id(String deliveryAddress_id) {
		DeliveryAddress_id = deliveryAddress_id;
	}

	public String getDeliveryAddressState_id() {
		return DeliveryAddressState_id;
	}

	public void setDeliveryAddressState_id(String deliveryAddressState_id) {
		DeliveryAddressState_id = deliveryAddressState_id;
	}

	public String getDeliveryAddressState_isoCode() {
		return DeliveryAddressState_isoCode;
	}

	public void setDeliveryAddressState_isoCode(String deliveryAddressState_isoCode) {
		DeliveryAddressState_isoCode = deliveryAddressState_isoCode;
	}

	public String getVariation_id() {
		return Variation_id;
	}

	public void setVariation_id(String variation_id) {
		Variation_id = variation_id;
	}

	public String getDeliveryAddressState_isoCode3166() {
		return DeliveryAddressState_isoCode3166;
	}

	public void setDeliveryAddressState_isoCode3166(String deliveryAddressState_isoCode3166) {
		DeliveryAddressState_isoCode3166 = deliveryAddressState_isoCode3166;
	}

	public String getItem_flagOne() {
		return Item_flagOne;
	}

	public void setItem_flagOne(String item_flagOne) {
		Item_flagOne = item_flagOne;
	}

	public String getItem_flagTwo() {
		return Item_flagTwo;
	}

	public void setItem_flagTwo(String item_flagTwo) {
		Item_flagTwo = item_flagTwo;
	}

	public String getItem_id() {
		return Item_id;
	}

	public void setItem_id(String item_id) {
		Item_id = item_id;
	}

	public String getOrder_locationId() {
		return Order_locationId;
	}

	public void setOrder_locationId(String order_locationId) {
		Order_locationId = order_locationId;
	}

	public String getOrder_statusId() {
		return Order_statusId;
	}

	public void setOrder_statusId(String order_statusId) {
		Order_statusId = order_statusId;
	}

	public String getOrderItem_itemVariationId() {
		return OrderItem_itemVariationId;
	}

	public void setOrderItem_itemVariationId(String orderItem_itemVariationId) {
		OrderItem_itemVariationId = orderItem_itemVariationId;
	}

	public String getOrderParcelService_backendName() {
		return OrderParcelService_backendName;
	}

	public void setOrderParcelService_backendName(String orderParcelService_backendName) {
		OrderParcelService_backendName = orderParcelService_backendName;
	}

	public String getOrderParcelServicePreset_alternativePhone() {
		return OrderParcelServicePreset_alternativePhone;
	}

	public void setOrderParcelServicePreset_alternativePhone(String orderParcelServicePreset_alternativePhone) {
		OrderParcelServicePreset_alternativePhone = orderParcelServicePreset_alternativePhone;
	}

	public String getVariationBarcode_code() {
		return VariationBarcode_code;
	}

	public void setVariationBarcode_code(String variationBarcode_code) {
		VariationBarcode_code = variationBarcode_code;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeader() {
		return Header;
	}

	public void setHeader(String header) {
		Header = header;
	}

	public String getExtOrder_ID() {
		return ExtOrder_ID;
	}

	public void setExtOrder_ID(String extOrder_ID) {
		ExtOrder_ID = extOrder_ID;
	}

}
