package de.leou.dataCamel.c;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import de.leou.dataCamel.m.Bean_PM_orderPK_csv;

public class Ctrl_orderPK {

	@SuppressWarnings("serial")
	private static HashMap<String, ArrayList<Bean_PM_orderPK_csv>> buildMap_Bean_PM_orderPK(String line_text,
			HashMap<String, ArrayList<Bean_PM_orderPK_csv>> hmap_o) {
		Bean_PM_orderPK_csv bean_o = new Bean_PM_orderPK_csv(line_text);

		// get order_id
		String order_id = bean_o.getOrder_id();

		// if order "Variation.number" is null
		String order_sku = bean_o.getVariation_number();
		if (order_sku == null || order_sku.equals("")) {
			return hmap_o;
		}

		// if this "order" is exist in hashMap
		if (hmap_o.get(order_id) != null) {
			hmap_o.get(order_id).add(bean_o);
		} else

		// if this "order" is a new element
		{
			hmap_o.put(order_id, new ArrayList<Bean_PM_orderPK_csv>() {
				{
					add(bean_o);
				}
			});
		}

		return hmap_o;
	}

	/**************************
	 * 
	 * read_Csv_To_BeanMap
	 * 
	 */

	public static HashMap<String, ArrayList<Bean_PM_orderPK_csv>> read_Csv_To_BeanMap(String filename,
			HashMap<String, ArrayList<Bean_PM_orderPK_csv>> map_o) {
		try {
			@SuppressWarnings("resource")
			BufferedReader b = new BufferedReader(new FileReader(new File(filename)));

			String line_text = "";
			while ((line_text = b.readLine()) != null) {
				if (!line_text.trim().equals("")) {
					map_o = buildMap_Bean_PM_orderPK(line_text, map_o);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return map_o;
	}

}
