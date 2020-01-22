package de.leou.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DT {

	static public String getCurrentDataString(String format) {
		String current_date = "";
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		// method 1
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		// format timestamp
		current_date = sdf.format(timestamp);
		return current_date;

	}

	static public String getCurrentTimestampString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return sdf.format(timestamp);
	}

	static public Timestamp getCurrentSqlTimestamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp;
	}
	
	static public java.sql.Date getCurrentSqlDate() {
		return new java.sql.Date(Calendar.getInstance().getTime().getTime());
	}

	static public String getCurrentDataString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return sdf.format(timestamp);
	}

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// method 1
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		// format timestamp
		System.out.println(sdf.format(timestamp));
		System.out.println(getCurrentDataString());

	}

	static public java.sql.Date parseSqlDate(String s_date, String s_format) {
		// "yyyy-MM-dd"

		SimpleDateFormat format = new SimpleDateFormat(s_format);
		java.util.Date parsed = null;
		try {
			parsed = format.parse(s_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sql_date = new java.sql.Date(parsed.getTime());
		return sql_date;

		// DateFormat format = new SimpleDateFormat(s_format, Locale.ENGLISH);
		// java.util.Date date = null;
		// try {
		// date = format.parse(s_date);
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// return date;
	}

	static public java.sql.Date parseSqlDate(String s_date) {
		return parseSqlDate(s_date, "yyyy-MM-dd");
	}

}
