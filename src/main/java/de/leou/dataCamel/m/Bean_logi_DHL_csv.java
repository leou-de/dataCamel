package de.leou.dataCamel.m;

import java.lang.reflect.InvocationTargetException;

public class Bean_logi_DHL_csv {
	// HEADER
	public static String HEADER = "Sendungsreferenz;Name_1_Absender;Ansprechpartner_Absender;Name_1_Empfaenger;Name_2_Postnummer_Empfaenger;Name_3_Empfaenger;Strasse_Empfaenger;Hausnummer_Empfaenger;Adresszusatz_1_Empfaenger;Adresszusatz_2_Empfaenger;PLZ_Empfaenger;Ort_Empfaenger;Land_Empfaenger;Telefonnummer_Empfaenger;Gewicht;Laenge;Breite;Hoehe;Produkt_und_Servicekennzeichnung;Abrechnungsnumme;Name_2_Absender;Name_3_Absender;Strasse_Absender;Hausnummer_Absender;PLZ_Absender;Ort_Absender;Telefonnummer_Absender";

	public Bean_logi_DHL_csv() {
		// TODO Auto-generated constructor stub
	}

	public Bean_logi_DHL_csv(Bean_PM_order o) {
		// TODO Auto-generated constructor stub
		this.Sendungsreferenz = o.getOrder_id();

		this.Name_1_Absender = o.getOrderItem_quantity() + "x" + o.getVariation_number();
		this.Name_2_Absender = "--------------------";
		this.Name_3_Absender = "Mustbuy GmbH";
		this.Strasse_Absender = "Frankenstr.";
		this.Hausnummer_Absender = "29";
		this.PLZ_Absender = "20097";
		this.Ort_Absender = "Hamburg";
		this.Ansprechpartner_Absender = o.getOrderItem_referrerName();
		this.Telefonnummer_Absender = "+494057199390";

		this.Name_1_Empfaenger = o.getDeliveryAddress_name2() + " " + o.getDeliveryAddress_name3();
		this.Name_2_Postnummer_Empfaenger = o.getDeliveryAddress_postident();
		this.Name_3_Empfaenger = o.getDeliveryAddress_name1();
		this.Strasse_Empfaenger = o.getDeliveryAddress_address1();
		this.Hausnummer_Empfaenger = o.getDeliveryAddress_address2();
		this.Adresszusatz_1_Empfaenger = o.getDeliveryAddress_address3();
		this.Adresszusatz_2_Empfaenger = o.getDeliveryAddress_address4();
		this.PLZ_Empfaenger = o.getDeliveryAddress_postalCode();
		this.Ort_Empfaenger = o.getDeliveryAddress_town();
		this.Land_Empfaenger = o.getDeliveryAddressCountry_isoCode2();
		this.Telefonnummer_Empfaenger = o.getDeliveryAddress_phone();

		this.Gewicht = "5";
		this.Laenge = "30";
		this.Breite = "30";
		this.Hoehe = "30";
		this.Produkt_und_Servicekennzeichnung="V01PAK";
		this.Abrechnungsnumme = "52496224820101";
	}
	
	
	public String  bulid_csv_row() {
		String s_row = "";
		String[] ss_header = this.HEADER.split(";");
	
		int cols = ss_header.length;
		for (int j = 0; j < cols; j++) {
			String header = ss_header[j];

			// build method name() with header
			String methodName = "get" + header;

			try {
				s_row += "\""
						+ this.getClass().getMethod(methodName, new Class[] {}).invoke(this, new Object[] {})
						+  "\";";
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
			System.out.print(s_row);
		}

		return s_row;
		
	}

	private String Sendungsreferenz;
	private String Sendungsref_Retoure;
	private String Sendungsdatum;
	private String Sendungserfassungsvorlage;
	private String Creation_Software;
	private String Adresse;
	private String Absenderdetails;
	private String Absenderreferenz;
	private String Name_1_Absender;
	private String Name_2_Absender;
	private String Name_3_Absender;
	private String Strasse_Absender;
	private String Hausnummer_Absender;
	private String Strasse_und_Hausnummer_Absender;
	private String Adresszusatz_1_Absender;
	private String Adresszusatz_2_Absender;
	private String Zustellinformation_Absender;
	private String PLZ_Absender;
	private String Ort_Absender;
	private String Postleitzahl_und_Ort_Absender;
	private String Provinz_Absender;
	private String Land_Absender;
	private String Ansprechpartner_Absender;
	private String E_Mail_Adresse_Absender;
	private String Telefonnummer_Absender;
	private String Empfaengerdetails;
	private String Empfaengerreferenz;
	private String Name_1_Empfaenger;
	private String Name_2_Postnummer_Empfaenger;
	private String Name_3_Empfaenger;
	private String Strasse_Empfaenger;
	private String Hausnummer_Empfaenger;
	private String Strasse_und_Hausnummer_Empfaenger;
	private String Adresszusatz_1_Empfaenger;
	private String Adresszusatz_2_Empfaenger;
	private String Zustellinformation_Empfaenger;
	private String PLZ_Empfaenger;
	private String Ort_Empfaenger;
	private String Postleitzahl_und_Ort_Empfaenger;
	private String Provinz_Empfaenger;
	private String Land_Empfaenger;
	private String Ansprechpartner_Empfaenger;
	private String E_Mail_Adresse_Empfaenger;
	private String Telefonnummer_Empfaenger;
	private String Retourendetails;
	private String Name_1_Retoure;
	private String Name_2_Retoure;
	private String Name_3_Retoure;
	private String Strasse_Retoure;
	private String Hausnummer_Retoure;
	private String Strasse_und_Hausnummer_Retoure;
	private String Adresszusatz_1_Retoure;
	private String Adresszusatz_2_Retoure;
	private String Zustellinformation_Retoure;
	private String PLZ_Retoure;
	private String Ort_Retoure;
	private String Postleitzahl_und_Ort_Retoure;
	private String Provinz_Retoure;
	private String Land_Retoure;
	private String Ansprechpartner_Retoure;
	private String E_Mail_Adresse_Retoure;
	private String Telefonnummer_Retoure;
	private String Gewicht;
	private String Laenge;
	private String Breite;
	private String Hoehe;
	private String Produkt_Serviceauswahl;
	private String Produkt_und_Servicekennzeichnung;
	private String Abrechnungsdetails;
	private String Abrechnungsnumme;
	private String Abrechnungsnummer_Retoure;
	private String Kostenstelle;
	private String Servicesdetails;
	private String Individuelle_Versendervorgabe_Kennzeichen;
	private String Zustelldatum_Wunschtag;
	private String Ident_Check_Vorname;
	private String Ident_Check_Nachname;
	private String Ident_Check_Geburtsdatum;
	private String Ident_Check_Mindestalter;
	private String Vorausverfuegungs_Typ;
	private String Details_Wunschnachbar;
	private String Details_Wunschort;
	private String Transportversicherung_Betrag;
	private String Filial_Routing_E_Mail;
	private String Versandbestaetigung_E_Mail_Adresse;
	private String Versandbestaetigung_E_Mail_Text_Vorlage;
	private String Typ_der_Alterssichtpruefung;
	private String Nachnahme_Kontoreferenz;
	private String Nachnahme_Nachnahme_Entgelt;
	private String Nachnahme_BIC;
	private String Nachnahme_Zahlungsempfaenger;
	private String Nachnahme_IBAN;
	private String Nachnahme_Bankname;
	private String Nachnahme_Verwendungszweck_1;
	private String Nachnahme_Verwendungszweck_2;
	private String Sendungshandling;
	private String Beliebiger_Hinweistext_an_den_DHL_Kurier;
	private String Zustellzeitfenster_Wunschzeit;
	private String Zustellzeitfenster_DHL_Kurier_Taggleich_und_Wunschzeit;
	private String Zustelldatum;
	private String Zustellzeitfenster;
	private String Sendungsdokumente_fuer_den_internationalen_Versand;
	private String Frankatur;
	private String Rechnungsnummer;
	private String Genehmigungsnummer;
	private String Bescheinigungsnummer;
	private String Einlieferungsstelle;
	private String Sendungsart;
	private String Beschreibung_bei_Sendungsart;
	private String Beschreibung_Warenposition_1;
	private String Menge_Warenposition_1;
	private String Warenwert_Einheit_Warenposition_1;
	private String Ursprungsland_Warenposition_1;
	private String Zolltarifnummer_Warenposition_1;
	private String Gewicht_Warenposition_1;
	private String Beschreibung_Warenposition_2;
	private String Menge_Warenposition_2;
	private String Warenwert_Einheit_Warenposition_2;
	private String Ursprungsland_Warenposition_2;
	private String Zolltarifnummer_Warenposition_2;
	private String Gewicht_Warenposition_2;
	private String Beschreibung_Warenposition_3;
	private String Menge_Warenposition_3;
	private String Warenwert_Einheit_Warenposition_3;
	private String Ursprungsland_Warenposition_3;
	private String Zolltarifnummer_Warenposition_3;
	private String Gewicht_Warenposition_3;
	private String Beschreibung_Warenposition_4;
	private String Menge_Warenposition_4;
	private String Warenwert_Einheit_Warenposition_4;
	private String Ursprungsland_Warenposition_4;
	private String Zolltarifnummer_Warenposition_4;
	private String Gewicht_Warenposition_4;
	private String Beschreibung_Warenposition_5;
	private String Menge_Warenposition_5;
	private String Warenwert_Einheit_Warenposition_5;
	private String Ursprungsland_Warenposition_5;
	private String Zolltarifnummer_Warenposition_5;
	private String Gewicht_Warenposition_5;
	private String Beschreibung_Warenposition_6;
	private String Menge_Warenposition_6;
	private String Warenwert_Einheit_Warenposition_6;
	private String Ursprungsland_Warenposition_6;
	private String Zolltarifnummer_Warenposition_6;
	private String Gewicht_Warenposition_6;
	private String Entgelte_Versandkosten;
	private String Sendung_mit_Ausfuhranmeldung;

	public String getSendungsreferenz() {
		return Sendungsreferenz;
	}

	public void setSendungsreferenz(String sendungsreferenz) {
		Sendungsreferenz = sendungsreferenz;
	}

	public String getSendungsref_Retoure() {
		return Sendungsref_Retoure;
	}

	public void setSendungsref_Retoure(String sendungsref_Retoure) {
		Sendungsref_Retoure = sendungsref_Retoure;
	}

	public String getSendungsdatum() {
		return Sendungsdatum;
	}

	public void setSendungsdatum(String sendungsdatum) {
		Sendungsdatum = sendungsdatum;
	}

	public String getSendungserfassungsvorlage() {
		return Sendungserfassungsvorlage;
	}

	public void setSendungserfassungsvorlage(String sendungserfassungsvorlage) {
		Sendungserfassungsvorlage = sendungserfassungsvorlage;
	}

	public String getCreation_Software() {
		return Creation_Software;
	}

	public void setCreation_Software(String creation_Software) {
		Creation_Software = creation_Software;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public String getAbsenderdetails() {
		return Absenderdetails;
	}

	public void setAbsenderdetails(String absenderdetails) {
		Absenderdetails = absenderdetails;
	}

	public String getAbsenderreferenz() {
		return Absenderreferenz;
	}

	public void setAbsenderreferenz(String absenderreferenz) {
		Absenderreferenz = absenderreferenz;
	}

	public String getName_1_Absender() {
		return Name_1_Absender;
	}

	public void setName_1_Absender(String name_1_Absender) {
		Name_1_Absender = name_1_Absender;
	}

	public String getName_2_Absender() {
		return Name_2_Absender;
	}

	public void setName_2_Absender(String name_2_Absender) {
		Name_2_Absender = name_2_Absender;
	}

	public String getName_3_Absender() {
		return Name_3_Absender;
	}

	public void setName_3_Absender(String name_3_Absender) {
		Name_3_Absender = name_3_Absender;
	}

	public String getStrasse_Absender() {
		return Strasse_Absender;
	}

	public void setStrasse_Absender(String strasse_Absender) {
		Strasse_Absender = strasse_Absender;
	}

	public String getHausnummer_Absender() {
		return Hausnummer_Absender;
	}

	public void setHausnummer_Absender(String hausnummer_Absender) {
		Hausnummer_Absender = hausnummer_Absender;
	}

	public String getStrasse_und_Hausnummer_Absender() {
		return Strasse_und_Hausnummer_Absender;
	}

	public void setStrasse_und_Hausnummer_Absender(String strasse_und_Hausnummer_Absender) {
		Strasse_und_Hausnummer_Absender = strasse_und_Hausnummer_Absender;
	}

	public String getAdresszusatz_1_Absender() {
		return Adresszusatz_1_Absender;
	}

	public void setAdresszusatz_1_Absender(String adresszusatz_1_Absender) {
		Adresszusatz_1_Absender = adresszusatz_1_Absender;
	}

	public String getAdresszusatz_2_Absender() {
		return Adresszusatz_2_Absender;
	}

	public void setAdresszusatz_2_Absender(String adresszusatz_2_Absender) {
		Adresszusatz_2_Absender = adresszusatz_2_Absender;
	}

	public String getZustellinformation_Absender() {
		return Zustellinformation_Absender;
	}

	public void setZustellinformation_Absender(String zustellinformation_Absender) {
		Zustellinformation_Absender = zustellinformation_Absender;
	}

	public String getPLZ_Absender() {
		return PLZ_Absender;
	}

	public void setPLZ_Absender(String pLZ_Absender) {
		PLZ_Absender = pLZ_Absender;
	}

	public String getOrt_Absender() {
		return Ort_Absender;
	}

	public void setOrt_Absender(String ort_Absender) {
		Ort_Absender = ort_Absender;
	}

	public String getPostleitzahl_und_Ort_Absender() {
		return Postleitzahl_und_Ort_Absender;
	}

	public void setPostleitzahl_und_Ort_Absender(String postleitzahl_und_Ort_Absender) {
		Postleitzahl_und_Ort_Absender = postleitzahl_und_Ort_Absender;
	}

	public String getProvinz_Absender() {
		return Provinz_Absender;
	}

	public void setProvinz_Absender(String provinz_Absender) {
		Provinz_Absender = provinz_Absender;
	}

	public String getLand_Absender() {
		return Land_Absender;
	}

	public void setLand_Absender(String land_Absender) {
		Land_Absender = land_Absender;
	}

	public String getAnsprechpartner_Absender() {
		return Ansprechpartner_Absender;
	}

	public void setAnsprechpartner_Absender(String ansprechpartner_Absender) {
		Ansprechpartner_Absender = ansprechpartner_Absender;
	}

	public String getE_Mail_Adresse_Absender() {
		return E_Mail_Adresse_Absender;
	}

	public void setE_Mail_Adresse_Absender(String e_Mail_Adresse_Absender) {
		E_Mail_Adresse_Absender = e_Mail_Adresse_Absender;
	}

	public String getTelefonnummer_Absender() {
		return Telefonnummer_Absender;
	}

	public void setTelefonnummer_Absender(String telefonnummer_Absender) {
		Telefonnummer_Absender = telefonnummer_Absender;
	}

	public String getEmpfaengerdetails() {
		return Empfaengerdetails;
	}

	public void setEmpfaengerdetails(String empfaengerdetails) {
		Empfaengerdetails = empfaengerdetails;
	}

	public String getEmpfaengerreferenz() {
		return Empfaengerreferenz;
	}

	public void setEmpfaengerreferenz(String empfaengerreferenz) {
		Empfaengerreferenz = empfaengerreferenz;
	}

	public String getName_1_Empfaenger() {
		return Name_1_Empfaenger;
	}

	public void setName_1_Empfaenger(String name_1_Empfaenger) {
		Name_1_Empfaenger = name_1_Empfaenger;
	}

	public String getName_2_Postnummer_Empfaenger() {
		return Name_2_Postnummer_Empfaenger;
	}

	public void setName_2_Postnummer_Empfaenger(String name_2_Postnummer_Empfaenger) {
		Name_2_Postnummer_Empfaenger = name_2_Postnummer_Empfaenger;
	}

	public String getName_3_Empfaenger() {
		return Name_3_Empfaenger;
	}

	public void setName_3_Empfaenger(String name_3_Empfaenger) {
		Name_3_Empfaenger = name_3_Empfaenger;
	}

	public String getStrasse_Empfaenger() {
		return Strasse_Empfaenger;
	}

	public void setStrasse_Empfaenger(String strasse_Empfaenger) {
		Strasse_Empfaenger = strasse_Empfaenger;
	}

	public String getHausnummer_Empfaenger() {
		return Hausnummer_Empfaenger;
	}

	public void setHausnummer_Empfaenger(String hausnummer_Empfaenger) {
		Hausnummer_Empfaenger = hausnummer_Empfaenger;
	}

	public String getStrasse_und_Hausnummer_Empfaenger() {
		return Strasse_und_Hausnummer_Empfaenger;
	}

	public void setStrasse_und_Hausnummer_Empfaenger(String strasse_und_Hausnummer_Empfaenger) {
		Strasse_und_Hausnummer_Empfaenger = strasse_und_Hausnummer_Empfaenger;
	}

	public String getAdresszusatz_1_Empfaenger() {
		return Adresszusatz_1_Empfaenger;
	}

	public void setAdresszusatz_1_Empfaenger(String adresszusatz_1_Empfaenger) {
		Adresszusatz_1_Empfaenger = adresszusatz_1_Empfaenger;
	}

	public String getAdresszusatz_2_Empfaenger() {
		return Adresszusatz_2_Empfaenger;
	}

	public void setAdresszusatz_2_Empfaenger(String adresszusatz_2_Empfaenger) {
		Adresszusatz_2_Empfaenger = adresszusatz_2_Empfaenger;
	}

	public String getZustellinformation_Empfaenger() {
		return Zustellinformation_Empfaenger;
	}

	public void setZustellinformation_Empfaenger(String zustellinformation_Empfaenger) {
		Zustellinformation_Empfaenger = zustellinformation_Empfaenger;
	}

	public String getPLZ_Empfaenger() {
		return PLZ_Empfaenger;
	}

	public void setPLZ_Empfaenger(String pLZ_Empfaenger) {
		PLZ_Empfaenger = pLZ_Empfaenger;
	}

	public String getOrt_Empfaenger() {
		return Ort_Empfaenger;
	}

	public void setOrt_Empfaenger(String ort_Empfaenger) {
		Ort_Empfaenger = ort_Empfaenger;
	}

	public String getPostleitzahl_und_Ort_Empfaenger() {
		return Postleitzahl_und_Ort_Empfaenger;
	}

	public void setPostleitzahl_und_Ort_Empfaenger(String postleitzahl_und_Ort_Empfaenger) {
		Postleitzahl_und_Ort_Empfaenger = postleitzahl_und_Ort_Empfaenger;
	}

	public String getProvinz_Empfaenger() {
		return Provinz_Empfaenger;
	}

	public void setProvinz_Empfaenger(String provinz_Empfaenger) {
		Provinz_Empfaenger = provinz_Empfaenger;
	}

	public String getLand_Empfaenger() {
		return Land_Empfaenger;
	}

	public void setLand_Empfaenger(String land_Empfaenger) {
		Land_Empfaenger = land_Empfaenger;
	}

	public String getAnsprechpartner_Empfaenger() {
		return Ansprechpartner_Empfaenger;
	}

	public void setAnsprechpartner_Empfaenger(String ansprechpartner_Empfaenger) {
		Ansprechpartner_Empfaenger = ansprechpartner_Empfaenger;
	}

	public String getE_Mail_Adresse_Empfaenger() {
		return E_Mail_Adresse_Empfaenger;
	}

	public void setE_Mail_Adresse_Empfaenger(String e_Mail_Adresse_Empfaenger) {
		E_Mail_Adresse_Empfaenger = e_Mail_Adresse_Empfaenger;
	}

	public String getTelefonnummer_Empfaenger() {
		return Telefonnummer_Empfaenger;
	}

	public void setTelefonnummer_Empfaenger(String telefonnummer_Empfaenger) {
		Telefonnummer_Empfaenger = telefonnummer_Empfaenger;
	}

	public String getRetourendetails() {
		return Retourendetails;
	}

	public void setRetourendetails(String retourendetails) {
		Retourendetails = retourendetails;
	}

	public String getName_1_Retoure() {
		return Name_1_Retoure;
	}

	public void setName_1_Retoure(String name_1_Retoure) {
		Name_1_Retoure = name_1_Retoure;
	}

	public String getName_2_Retoure() {
		return Name_2_Retoure;
	}

	public void setName_2_Retoure(String name_2_Retoure) {
		Name_2_Retoure = name_2_Retoure;
	}

	public String getName_3_Retoure() {
		return Name_3_Retoure;
	}

	public void setName_3_Retoure(String name_3_Retoure) {
		Name_3_Retoure = name_3_Retoure;
	}

	public String getStrasse_Retoure() {
		return Strasse_Retoure;
	}

	public void setStrasse_Retoure(String strasse_Retoure) {
		Strasse_Retoure = strasse_Retoure;
	}

	public String getHausnummer_Retoure() {
		return Hausnummer_Retoure;
	}

	public void setHausnummer_Retoure(String hausnummer_Retoure) {
		Hausnummer_Retoure = hausnummer_Retoure;
	}

	public String getStrasse_und_Hausnummer_Retoure() {
		return Strasse_und_Hausnummer_Retoure;
	}

	public void setStrasse_und_Hausnummer_Retoure(String strasse_und_Hausnummer_Retoure) {
		Strasse_und_Hausnummer_Retoure = strasse_und_Hausnummer_Retoure;
	}

	public String getAdresszusatz_1_Retoure() {
		return Adresszusatz_1_Retoure;
	}

	public void setAdresszusatz_1_Retoure(String adresszusatz_1_Retoure) {
		Adresszusatz_1_Retoure = adresszusatz_1_Retoure;
	}

	public String getAdresszusatz_2_Retoure() {
		return Adresszusatz_2_Retoure;
	}

	public void setAdresszusatz_2_Retoure(String adresszusatz_2_Retoure) {
		Adresszusatz_2_Retoure = adresszusatz_2_Retoure;
	}

	public String getZustellinformation_Retoure() {
		return Zustellinformation_Retoure;
	}

	public void setZustellinformation_Retoure(String zustellinformation_Retoure) {
		Zustellinformation_Retoure = zustellinformation_Retoure;
	}

	public String getPLZ_Retoure() {
		return PLZ_Retoure;
	}

	public void setPLZ_Retoure(String pLZ_Retoure) {
		PLZ_Retoure = pLZ_Retoure;
	}

	public String getOrt_Retoure() {
		return Ort_Retoure;
	}

	public void setOrt_Retoure(String ort_Retoure) {
		Ort_Retoure = ort_Retoure;
	}

	public String getPostleitzahl_und_Ort_Retoure() {
		return Postleitzahl_und_Ort_Retoure;
	}

	public void setPostleitzahl_und_Ort_Retoure(String postleitzahl_und_Ort_Retoure) {
		Postleitzahl_und_Ort_Retoure = postleitzahl_und_Ort_Retoure;
	}

	public String getProvinz_Retoure() {
		return Provinz_Retoure;
	}

	public void setProvinz_Retoure(String provinz_Retoure) {
		Provinz_Retoure = provinz_Retoure;
	}

	public String getLand_Retoure() {
		return Land_Retoure;
	}

	public void setLand_Retoure(String land_Retoure) {
		Land_Retoure = land_Retoure;
	}

	public String getAnsprechpartner_Retoure() {
		return Ansprechpartner_Retoure;
	}

	public void setAnsprechpartner_Retoure(String ansprechpartner_Retoure) {
		Ansprechpartner_Retoure = ansprechpartner_Retoure;
	}

	public String getE_Mail_Adresse_Retoure() {
		return E_Mail_Adresse_Retoure;
	}

	public void setE_Mail_Adresse_Retoure(String e_Mail_Adresse_Retoure) {
		E_Mail_Adresse_Retoure = e_Mail_Adresse_Retoure;
	}

	public String getTelefonnummer_Retoure() {
		return Telefonnummer_Retoure;
	}

	public void setTelefonnummer_Retoure(String telefonnummer_Retoure) {
		Telefonnummer_Retoure = telefonnummer_Retoure;
	}

	public String getGewicht() {
		return Gewicht;
	}

	public void setGewicht(String gewicht) {
		Gewicht = gewicht;
	}

	public String getLaenge() {
		return Laenge;
	}

	public void setLaenge(String laenge) {
		Laenge = laenge;
	}

	public String getBreite() {
		return Breite;
	}

	public void setBreite(String breite) {
		Breite = breite;
	}

	public String getHoehe() {
		return Hoehe;
	}

	public void setHoehe(String hoehe) {
		Hoehe = hoehe;
	}

	public String getProdukt_Serviceauswahl() {
		return Produkt_Serviceauswahl;
	}

	public void setProdukt_Serviceauswahl(String produkt_Serviceauswahl) {
		Produkt_Serviceauswahl = produkt_Serviceauswahl;
	}

	public String getProdukt_und_Servicekennzeichnung() {
		return Produkt_und_Servicekennzeichnung;
	}

	public void setProdukt_und_Servicekennzeichnung(String produkt_und_Servicekennzeichnung) {
		Produkt_und_Servicekennzeichnung = produkt_und_Servicekennzeichnung;
	}

	public String getAbrechnungsdetails() {
		return Abrechnungsdetails;
	}

	public void setAbrechnungsdetails(String abrechnungsdetails) {
		Abrechnungsdetails = abrechnungsdetails;
	}

	public String getAbrechnungsnumme() {
		return Abrechnungsnumme;
	}

	public void setAbrechnungsnumme(String abrechnungsnumme) {
		Abrechnungsnumme = abrechnungsnumme;
	}

	public String getAbrechnungsnummer_Retoure() {
		return Abrechnungsnummer_Retoure;
	}

	public void setAbrechnungsnummer_Retoure(String abrechnungsnummer_Retoure) {
		Abrechnungsnummer_Retoure = abrechnungsnummer_Retoure;
	}

	public String getKostenstelle() {
		return Kostenstelle;
	}

	public void setKostenstelle(String kostenstelle) {
		Kostenstelle = kostenstelle;
	}

	public String getServicesdetails() {
		return Servicesdetails;
	}

	public void setServicesdetails(String servicesdetails) {
		Servicesdetails = servicesdetails;
	}

	public String getIndividuelle_Versendervorgabe_Kennzeichen() {
		return Individuelle_Versendervorgabe_Kennzeichen;
	}

	public void setIndividuelle_Versendervorgabe_Kennzeichen(String individuelle_Versendervorgabe_Kennzeichen) {
		Individuelle_Versendervorgabe_Kennzeichen = individuelle_Versendervorgabe_Kennzeichen;
	}

	public String getZustelldatum_Wunschtag() {
		return Zustelldatum_Wunschtag;
	}

	public void setZustelldatum_Wunschtag(String zustelldatum_Wunschtag) {
		Zustelldatum_Wunschtag = zustelldatum_Wunschtag;
	}

	public String getIdent_Check_Vorname() {
		return Ident_Check_Vorname;
	}

	public void setIdent_Check_Vorname(String ident_Check_Vorname) {
		Ident_Check_Vorname = ident_Check_Vorname;
	}

	public String getIdent_Check_Nachname() {
		return Ident_Check_Nachname;
	}

	public void setIdent_Check_Nachname(String ident_Check_Nachname) {
		Ident_Check_Nachname = ident_Check_Nachname;
	}

	public String getIdent_Check_Geburtsdatum() {
		return Ident_Check_Geburtsdatum;
	}

	public void setIdent_Check_Geburtsdatum(String ident_Check_Geburtsdatum) {
		Ident_Check_Geburtsdatum = ident_Check_Geburtsdatum;
	}

	public String getIdent_Check_Mindestalter() {
		return Ident_Check_Mindestalter;
	}

	public void setIdent_Check_Mindestalter(String ident_Check_Mindestalter) {
		Ident_Check_Mindestalter = ident_Check_Mindestalter;
	}

	public String getVorausverfuegungs_Typ() {
		return Vorausverfuegungs_Typ;
	}

	public void setVorausverfuegungs_Typ(String vorausverfuegungs_Typ) {
		Vorausverfuegungs_Typ = vorausverfuegungs_Typ;
	}

	public String getDetails_Wunschnachbar() {
		return Details_Wunschnachbar;
	}

	public void setDetails_Wunschnachbar(String details_Wunschnachbar) {
		Details_Wunschnachbar = details_Wunschnachbar;
	}

	public String getDetails_Wunschort() {
		return Details_Wunschort;
	}

	public void setDetails_Wunschort(String details_Wunschort) {
		Details_Wunschort = details_Wunschort;
	}

	public String getTransportversicherung_Betrag() {
		return Transportversicherung_Betrag;
	}

	public void setTransportversicherung_Betrag(String transportversicherung_Betrag) {
		Transportversicherung_Betrag = transportversicherung_Betrag;
	}

	public String getFilial_Routing_E_Mail() {
		return Filial_Routing_E_Mail;
	}

	public void setFilial_Routing_E_Mail(String filial_Routing_E_Mail) {
		Filial_Routing_E_Mail = filial_Routing_E_Mail;
	}

	public String getVersandbestaetigung_E_Mail_Adresse() {
		return Versandbestaetigung_E_Mail_Adresse;
	}

	public void setVersandbestaetigung_E_Mail_Adresse(String versandbestaetigung_E_Mail_Adresse) {
		Versandbestaetigung_E_Mail_Adresse = versandbestaetigung_E_Mail_Adresse;
	}

	public String getVersandbestaetigung_E_Mail_Text_Vorlage() {
		return Versandbestaetigung_E_Mail_Text_Vorlage;
	}

	public void setVersandbestaetigung_E_Mail_Text_Vorlage(String versandbestaetigung_E_Mail_Text_Vorlage) {
		Versandbestaetigung_E_Mail_Text_Vorlage = versandbestaetigung_E_Mail_Text_Vorlage;
	}

	public String getTyp_der_Alterssichtpruefung() {
		return Typ_der_Alterssichtpruefung;
	}

	public void setTyp_der_Alterssichtpruefung(String typ_der_Alterssichtpruefung) {
		Typ_der_Alterssichtpruefung = typ_der_Alterssichtpruefung;
	}

	public String getNachnahme_Kontoreferenz() {
		return Nachnahme_Kontoreferenz;
	}

	public void setNachnahme_Kontoreferenz(String nachnahme_Kontoreferenz) {
		Nachnahme_Kontoreferenz = nachnahme_Kontoreferenz;
	}

	public String getNachnahme_Nachnahme_Entgelt() {
		return Nachnahme_Nachnahme_Entgelt;
	}

	public void setNachnahme_Nachnahme_Entgelt(String nachnahme_Nachnahme_Entgelt) {
		Nachnahme_Nachnahme_Entgelt = nachnahme_Nachnahme_Entgelt;
	}

	public String getNachnahme_BIC() {
		return Nachnahme_BIC;
	}

	public void setNachnahme_BIC(String nachnahme_BIC) {
		Nachnahme_BIC = nachnahme_BIC;
	}

	public String getNachnahme_Zahlungsempfaenger() {
		return Nachnahme_Zahlungsempfaenger;
	}

	public void setNachnahme_Zahlungsempfaenger(String nachnahme_Zahlungsempfaenger) {
		Nachnahme_Zahlungsempfaenger = nachnahme_Zahlungsempfaenger;
	}

	public String getNachnahme_IBAN() {
		return Nachnahme_IBAN;
	}

	public void setNachnahme_IBAN(String nachnahme_IBAN) {
		Nachnahme_IBAN = nachnahme_IBAN;
	}

	public String getNachnahme_Bankname() {
		return Nachnahme_Bankname;
	}

	public void setNachnahme_Bankname(String nachnahme_Bankname) {
		Nachnahme_Bankname = nachnahme_Bankname;
	}

	public String getNachnahme_Verwendungszweck_1() {
		return Nachnahme_Verwendungszweck_1;
	}

	public void setNachnahme_Verwendungszweck_1(String nachnahme_Verwendungszweck_1) {
		Nachnahme_Verwendungszweck_1 = nachnahme_Verwendungszweck_1;
	}

	public String getNachnahme_Verwendungszweck_2() {
		return Nachnahme_Verwendungszweck_2;
	}

	public void setNachnahme_Verwendungszweck_2(String nachnahme_Verwendungszweck_2) {
		Nachnahme_Verwendungszweck_2 = nachnahme_Verwendungszweck_2;
	}

	public String getSendungshandling() {
		return Sendungshandling;
	}

	public void setSendungshandling(String sendungshandling) {
		Sendungshandling = sendungshandling;
	}

	public String getBeliebiger_Hinweistext_an_den_DHL_Kurier() {
		return Beliebiger_Hinweistext_an_den_DHL_Kurier;
	}

	public void setBeliebiger_Hinweistext_an_den_DHL_Kurier(String beliebiger_Hinweistext_an_den_DHL_Kurier) {
		Beliebiger_Hinweistext_an_den_DHL_Kurier = beliebiger_Hinweistext_an_den_DHL_Kurier;
	}

	public String getZustellzeitfenster_Wunschzeit() {
		return Zustellzeitfenster_Wunschzeit;
	}

	public void setZustellzeitfenster_Wunschzeit(String zustellzeitfenster_Wunschzeit) {
		Zustellzeitfenster_Wunschzeit = zustellzeitfenster_Wunschzeit;
	}

	public String getZustellzeitfenster_DHL_Kurier_Taggleich_und_Wunschzeit() {
		return Zustellzeitfenster_DHL_Kurier_Taggleich_und_Wunschzeit;
	}

	public void setZustellzeitfenster_DHL_Kurier_Taggleich_und_Wunschzeit(
			String zustellzeitfenster_DHL_Kurier_Taggleich_und_Wunschzeit) {
		Zustellzeitfenster_DHL_Kurier_Taggleich_und_Wunschzeit = zustellzeitfenster_DHL_Kurier_Taggleich_und_Wunschzeit;
	}

	public String getZustelldatum() {
		return Zustelldatum;
	}

	public void setZustelldatum(String zustelldatum) {
		Zustelldatum = zustelldatum;
	}

	public String getZustellzeitfenster() {
		return Zustellzeitfenster;
	}

	public void setZustellzeitfenster(String zustellzeitfenster) {
		Zustellzeitfenster = zustellzeitfenster;
	}

	public String getSendungsdokumente_fuer_den_internationalen_Versand() {
		return Sendungsdokumente_fuer_den_internationalen_Versand;
	}

	public void setSendungsdokumente_fuer_den_internationalen_Versand(
			String sendungsdokumente_fuer_den_internationalen_Versand) {
		Sendungsdokumente_fuer_den_internationalen_Versand = sendungsdokumente_fuer_den_internationalen_Versand;
	}

	public String getFrankatur() {
		return Frankatur;
	}

	public void setFrankatur(String frankatur) {
		Frankatur = frankatur;
	}

	public String getRechnungsnummer() {
		return Rechnungsnummer;
	}

	public void setRechnungsnummer(String rechnungsnummer) {
		Rechnungsnummer = rechnungsnummer;
	}

	public String getGenehmigungsnummer() {
		return Genehmigungsnummer;
	}

	public void setGenehmigungsnummer(String genehmigungsnummer) {
		Genehmigungsnummer = genehmigungsnummer;
	}

	public String getBescheinigungsnummer() {
		return Bescheinigungsnummer;
	}

	public void setBescheinigungsnummer(String bescheinigungsnummer) {
		Bescheinigungsnummer = bescheinigungsnummer;
	}

	public String getEinlieferungsstelle() {
		return Einlieferungsstelle;
	}

	public void setEinlieferungsstelle(String einlieferungsstelle) {
		Einlieferungsstelle = einlieferungsstelle;
	}

	public String getSendungsart() {
		return Sendungsart;
	}

	public void setSendungsart(String sendungsart) {
		Sendungsart = sendungsart;
	}

	public String getBeschreibung_bei_Sendungsart() {
		return Beschreibung_bei_Sendungsart;
	}

	public void setBeschreibung_bei_Sendungsart(String beschreibung_bei_Sendungsart) {
		Beschreibung_bei_Sendungsart = beschreibung_bei_Sendungsart;
	}

	public String getBeschreibung_Warenposition_1() {
		return Beschreibung_Warenposition_1;
	}

	public void setBeschreibung_Warenposition_1(String beschreibung_Warenposition_1) {
		Beschreibung_Warenposition_1 = beschreibung_Warenposition_1;
	}

	public String getMenge_Warenposition_1() {
		return Menge_Warenposition_1;
	}

	public void setMenge_Warenposition_1(String menge_Warenposition_1) {
		Menge_Warenposition_1 = menge_Warenposition_1;
	}

	public String getWarenwert_Einheit_Warenposition_1() {
		return Warenwert_Einheit_Warenposition_1;
	}

	public void setWarenwert_Einheit_Warenposition_1(String warenwert_Einheit_Warenposition_1) {
		Warenwert_Einheit_Warenposition_1 = warenwert_Einheit_Warenposition_1;
	}

	public String getUrsprungsland_Warenposition_1() {
		return Ursprungsland_Warenposition_1;
	}

	public void setUrsprungsland_Warenposition_1(String ursprungsland_Warenposition_1) {
		Ursprungsland_Warenposition_1 = ursprungsland_Warenposition_1;
	}

	public String getZolltarifnummer_Warenposition_1() {
		return Zolltarifnummer_Warenposition_1;
	}

	public void setZolltarifnummer_Warenposition_1(String zolltarifnummer_Warenposition_1) {
		Zolltarifnummer_Warenposition_1 = zolltarifnummer_Warenposition_1;
	}

	public String getGewicht_Warenposition_1() {
		return Gewicht_Warenposition_1;
	}

	public void setGewicht_Warenposition_1(String gewicht_Warenposition_1) {
		Gewicht_Warenposition_1 = gewicht_Warenposition_1;
	}

	public String getBeschreibung_Warenposition_2() {
		return Beschreibung_Warenposition_2;
	}

	public void setBeschreibung_Warenposition_2(String beschreibung_Warenposition_2) {
		Beschreibung_Warenposition_2 = beschreibung_Warenposition_2;
	}

	public String getMenge_Warenposition_2() {
		return Menge_Warenposition_2;
	}

	public void setMenge_Warenposition_2(String menge_Warenposition_2) {
		Menge_Warenposition_2 = menge_Warenposition_2;
	}

	public String getWarenwert_Einheit_Warenposition_2() {
		return Warenwert_Einheit_Warenposition_2;
	}

	public void setWarenwert_Einheit_Warenposition_2(String warenwert_Einheit_Warenposition_2) {
		Warenwert_Einheit_Warenposition_2 = warenwert_Einheit_Warenposition_2;
	}

	public String getUrsprungsland_Warenposition_2() {
		return Ursprungsland_Warenposition_2;
	}

	public void setUrsprungsland_Warenposition_2(String ursprungsland_Warenposition_2) {
		Ursprungsland_Warenposition_2 = ursprungsland_Warenposition_2;
	}

	public String getZolltarifnummer_Warenposition_2() {
		return Zolltarifnummer_Warenposition_2;
	}

	public void setZolltarifnummer_Warenposition_2(String zolltarifnummer_Warenposition_2) {
		Zolltarifnummer_Warenposition_2 = zolltarifnummer_Warenposition_2;
	}

	public String getGewicht_Warenposition_2() {
		return Gewicht_Warenposition_2;
	}

	public void setGewicht_Warenposition_2(String gewicht_Warenposition_2) {
		Gewicht_Warenposition_2 = gewicht_Warenposition_2;
	}

	public String getBeschreibung_Warenposition_3() {
		return Beschreibung_Warenposition_3;
	}

	public void setBeschreibung_Warenposition_3(String beschreibung_Warenposition_3) {
		Beschreibung_Warenposition_3 = beschreibung_Warenposition_3;
	}

	public String getMenge_Warenposition_3() {
		return Menge_Warenposition_3;
	}

	public void setMenge_Warenposition_3(String menge_Warenposition_3) {
		Menge_Warenposition_3 = menge_Warenposition_3;
	}

	public String getWarenwert_Einheit_Warenposition_3() {
		return Warenwert_Einheit_Warenposition_3;
	}

	public void setWarenwert_Einheit_Warenposition_3(String warenwert_Einheit_Warenposition_3) {
		Warenwert_Einheit_Warenposition_3 = warenwert_Einheit_Warenposition_3;
	}

	public String getUrsprungsland_Warenposition_3() {
		return Ursprungsland_Warenposition_3;
	}

	public void setUrsprungsland_Warenposition_3(String ursprungsland_Warenposition_3) {
		Ursprungsland_Warenposition_3 = ursprungsland_Warenposition_3;
	}

	public String getZolltarifnummer_Warenposition_3() {
		return Zolltarifnummer_Warenposition_3;
	}

	public void setZolltarifnummer_Warenposition_3(String zolltarifnummer_Warenposition_3) {
		Zolltarifnummer_Warenposition_3 = zolltarifnummer_Warenposition_3;
	}

	public String getGewicht_Warenposition_3() {
		return Gewicht_Warenposition_3;
	}

	public void setGewicht_Warenposition_3(String gewicht_Warenposition_3) {
		Gewicht_Warenposition_3 = gewicht_Warenposition_3;
	}

	public String getBeschreibung_Warenposition_4() {
		return Beschreibung_Warenposition_4;
	}

	public void setBeschreibung_Warenposition_4(String beschreibung_Warenposition_4) {
		Beschreibung_Warenposition_4 = beschreibung_Warenposition_4;
	}

	public String getMenge_Warenposition_4() {
		return Menge_Warenposition_4;
	}

	public void setMenge_Warenposition_4(String menge_Warenposition_4) {
		Menge_Warenposition_4 = menge_Warenposition_4;
	}

	public String getWarenwert_Einheit_Warenposition_4() {
		return Warenwert_Einheit_Warenposition_4;
	}

	public void setWarenwert_Einheit_Warenposition_4(String warenwert_Einheit_Warenposition_4) {
		Warenwert_Einheit_Warenposition_4 = warenwert_Einheit_Warenposition_4;
	}

	public String getUrsprungsland_Warenposition_4() {
		return Ursprungsland_Warenposition_4;
	}

	public void setUrsprungsland_Warenposition_4(String ursprungsland_Warenposition_4) {
		Ursprungsland_Warenposition_4 = ursprungsland_Warenposition_4;
	}

	public String getZolltarifnummer_Warenposition_4() {
		return Zolltarifnummer_Warenposition_4;
	}

	public void setZolltarifnummer_Warenposition_4(String zolltarifnummer_Warenposition_4) {
		Zolltarifnummer_Warenposition_4 = zolltarifnummer_Warenposition_4;
	}

	public String getGewicht_Warenposition_4() {
		return Gewicht_Warenposition_4;
	}

	public void setGewicht_Warenposition_4(String gewicht_Warenposition_4) {
		Gewicht_Warenposition_4 = gewicht_Warenposition_4;
	}

	public String getBeschreibung_Warenposition_5() {
		return Beschreibung_Warenposition_5;
	}

	public void setBeschreibung_Warenposition_5(String beschreibung_Warenposition_5) {
		Beschreibung_Warenposition_5 = beschreibung_Warenposition_5;
	}

	public String getMenge_Warenposition_5() {
		return Menge_Warenposition_5;
	}

	public void setMenge_Warenposition_5(String menge_Warenposition_5) {
		Menge_Warenposition_5 = menge_Warenposition_5;
	}

	public String getWarenwert_Einheit_Warenposition_5() {
		return Warenwert_Einheit_Warenposition_5;
	}

	public void setWarenwert_Einheit_Warenposition_5(String warenwert_Einheit_Warenposition_5) {
		Warenwert_Einheit_Warenposition_5 = warenwert_Einheit_Warenposition_5;
	}

	public String getUrsprungsland_Warenposition_5() {
		return Ursprungsland_Warenposition_5;
	}

	public void setUrsprungsland_Warenposition_5(String ursprungsland_Warenposition_5) {
		Ursprungsland_Warenposition_5 = ursprungsland_Warenposition_5;
	}

	public String getZolltarifnummer_Warenposition_5() {
		return Zolltarifnummer_Warenposition_5;
	}

	public void setZolltarifnummer_Warenposition_5(String zolltarifnummer_Warenposition_5) {
		Zolltarifnummer_Warenposition_5 = zolltarifnummer_Warenposition_5;
	}

	public String getGewicht_Warenposition_5() {
		return Gewicht_Warenposition_5;
	}

	public void setGewicht_Warenposition_5(String gewicht_Warenposition_5) {
		Gewicht_Warenposition_5 = gewicht_Warenposition_5;
	}

	public String getBeschreibung_Warenposition_6() {
		return Beschreibung_Warenposition_6;
	}

	public void setBeschreibung_Warenposition_6(String beschreibung_Warenposition_6) {
		Beschreibung_Warenposition_6 = beschreibung_Warenposition_6;
	}

	public String getMenge_Warenposition_6() {
		return Menge_Warenposition_6;
	}

	public void setMenge_Warenposition_6(String menge_Warenposition_6) {
		Menge_Warenposition_6 = menge_Warenposition_6;
	}

	public String getWarenwert_Einheit_Warenposition_6() {
		return Warenwert_Einheit_Warenposition_6;
	}

	public void setWarenwert_Einheit_Warenposition_6(String warenwert_Einheit_Warenposition_6) {
		Warenwert_Einheit_Warenposition_6 = warenwert_Einheit_Warenposition_6;
	}

	public String getUrsprungsland_Warenposition_6() {
		return Ursprungsland_Warenposition_6;
	}

	public void setUrsprungsland_Warenposition_6(String ursprungsland_Warenposition_6) {
		Ursprungsland_Warenposition_6 = ursprungsland_Warenposition_6;
	}

	public String getZolltarifnummer_Warenposition_6() {
		return Zolltarifnummer_Warenposition_6;
	}

	public void setZolltarifnummer_Warenposition_6(String zolltarifnummer_Warenposition_6) {
		Zolltarifnummer_Warenposition_6 = zolltarifnummer_Warenposition_6;
	}

	public String getGewicht_Warenposition_6() {
		return Gewicht_Warenposition_6;
	}

	public void setGewicht_Warenposition_6(String gewicht_Warenposition_6) {
		Gewicht_Warenposition_6 = gewicht_Warenposition_6;
	}

	public String getEntgelte_Versandkosten() {
		return Entgelte_Versandkosten;
	}

	public void setEntgelte_Versandkosten(String entgelte_Versandkosten) {
		Entgelte_Versandkosten = entgelte_Versandkosten;
	}

	public String getSendung_mit_Ausfuhranmeldung() {
		return Sendung_mit_Ausfuhranmeldung;
	}

	public void setSendung_mit_Ausfuhranmeldung(String sendung_mit_Ausfuhranmeldung) {
		Sendung_mit_Ausfuhranmeldung = sendung_mit_Ausfuhranmeldung;
	}

}
