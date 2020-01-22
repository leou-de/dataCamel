package de.leou.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.collections4.Get;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextRenderInfo;
import com.itextpdf.text.xml.simpleparser.IanaEncodings;

import de.leou.dataCamel.c.Ctrl_orderPK;
import de.leou.dataCamel.m.Bean_PM_orderPK_csv;

/**
 * 创建日期：2017-10-13下午2:28:35 修改日期： 作者：ttan 描述：iText读取PDF
 */
public class UtilsPDF {
	public static void main(String[] args) throws IOException {
		String outputPath = "c:\\_gd_mustbuy\\Mustbuy\\Bestellung\\daliy_stock_out\\page.txt";
		PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath));
		String fileName = "c:\\_gd_mustbuy\\Mustbuy\\Bestellung\\daliy_stock_out\\DHL-LABEL.pdf";
		readPdf(writer, fileName);// 直接读全PDF面

		// readPdf_filter(fileName);//读取PDF面的某个区域

	}

	public static void readPdf(PrintWriter writer, String fileName) {
		String pageContent = "";

		///////////////////////////////////////////////////////////////////////
		String csvFileName = "c:\\_gd_mustbuy\\Mustbuy\\Bestellung\\daliy_stock_out\\_orderPK.csv";

		HashMap<String, ArrayList<Bean_PM_orderPK_csv>> map_o = new HashMap<String, ArrayList<Bean_PM_orderPK_csv>>();
		Ctrl_orderPK.read_Csv_To_BeanMap(csvFileName, map_o);

		///////////////////////////////////////////////////////////////////////

		try {
			PdfReader reader = new PdfReader(fileName);
			int pageNum = reader.getNumberOfPages();

			// 根据一个pdfreader创建一个pdfStamper.用来生成新的pdf.
			PdfStamper stamper = new PdfStamper(reader,
					new FileOutputStream("c:\\_gd_mustbuy\\Mustbuy\\Bestellung\\daliy_stock_out\\DHL-Label2.pdf"));

			// 这个字体是itext-asian.jar中自带的 所以不用考虑操作系统环境问题.
			BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.WINANSI, false); // set font
			// baseFont不支持字体样式设定.但是font字体要求操作系统支持此字体会带来移植问题.
			Font font = new Font(bf, 10);
			font.setStyle(Font.BOLD);
			font.getBaseFont();

			// iter all pages

			for (int i = 1; i <= pageNum; i++) {
				pageContent += PdfTextExtractor.getTextFromPage(reader, i);// 读取第i页的文档内容

				// get order_id
				String order_id = "";
				for (String s : pageContent.split("\n")) {
					outerloop: if (s.contains("Referenznr.:")) {
						order_id = s.substring(s.indexOf(":") + 1).trim();
						break outerloop;
					}
				}
				System.out.println(":::::::::::::::::::::::::::::::" + order_id);

////////////////////////////////////////////////////

//获得pdfstamper在当前页的上层打印内容.也就是说 这些内容会覆盖在原先的pdf内容之上.  
				PdfContentByte over = stamper.getOverContent(i);
//用pdfreader获得当前页字典对象.包含了该页的一些数据.比如该页的坐标轴信息.  
				PdfDictionary p = reader.getPageN(i);
//拿到mediaBox 里面放着该页pdf的大小信息.  
				PdfObject po = p.get(new PdfName("MediaBox"));
				System.out.println(po.isArray());
//po是一个数组对象.里面包含了该页pdf的坐标轴范围.  
				PdfArray pa = (PdfArray) po;
				System.out.println(pa.size());
//看看y轴的最大值.  
				System.out.println(pa.getAsNumber(pa.size() - 1));
//开始写入文本  
				over.beginText();
				over.setFontAndSize(font.getBaseFont(), 24);
				over.setColorFill(BaseColor.BLACK);
				over.setTextMatrix(0, 240);
				over.showText("www.naipo.de");
				over.endText();

				over.beginText();
				over.setFontAndSize(font.getBaseFont(), 20);
				over.setColorFill(BaseColor.BLACK);
				over.setTextMatrix(0, 0);
				over.showText(i + "#     (" + order_id + ")");
				over.endText();
				
				
				int sku_baseline = 330;
				if (map_o != null && map_o.get(order_id)!=null) {

					for (Bean_PM_orderPK_csv bean_o : map_o.get(order_id)) {
						
							String qt_x_sku = "< " + bean_o.getOrderItem_quantity() + " x "
									+ bean_o.getVariation_number() + " >";
							over.beginText();
							over.setFontAndSize(font.getBaseFont(), 16);
							over.setColorFill(BaseColor.BLACK);
							over.setTextMatrix(0, sku_baseline);
							sku_baseline -= 18;
							over.showText(qt_x_sku);
							over.endText();
					}
				}

//创建一个image对象.  
//Image image = Image.getInstance("c:/1.jpg");  
////设置image对象的输出位置pa.getAsNumber(pa.size()-1).floatValue() 是该页pdf坐标轴的y轴的最大值  
//image.setAbsolutePosition(0,pa.getAsNumber(pa.size()-1).floatValue()-100);//0, 0, 841.92, 595.32  
//over.addImage(image);  

//画一个圈.  
//				over.setRGBColorStroke(0xFF, 0x00, 0x00);
//				over.setLineWidth(5f);
//				over.ellipse(250, 450, 350, 550);
//				over.stroke();

////////////////////////////////////////////////////

			}
			stamper.close();
			writer.write(pageContent);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			writer.close();
		}
	}

	public static void readPdf_filter(PrintWriter writer, String fileName) {
		String pageContent = "";
		try {
			Rectangle rect = new Rectangle(90, 0, 450, 40);
			RenderFilter filter = new RegionTextRenderFilter(rect);
			PdfReader reader = new PdfReader(fileName);
			int pageNum = reader.getNumberOfPages();
			TextExtractionStrategy strategy;
			for (int i = 1; i <= pageNum; i++) {
				strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter);
				pageContent += PdfTextExtractor.getTextFromPage(reader, i, strategy);
			}
			/*
			 * String[] split = pageContent.split(" "); for(String ss : split){
			 * System.out.println(ss.substring(ss.lastIndexOf("：")+1, ss.length())); }
			 */
			System.out.println(pageContent);
			writer.write(pageContent);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}

	/********************************
	 * 
	 * getElementPosition
	 * 
	 ********************************/

	public void getElementPosition(int pageN, PdfReader reader) {
		try {

			PdfReaderContentParser pdfReaderContentParser = new PdfReaderContentParser(reader);
			pdfReaderContentParser.processContent(pageN, new RenderListener() {

				@Override
				public void renderImage(ImageRenderInfo arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void endTextBlock() {
					// TODO Auto-generated method stub

				}

				@Override
				public void beginTextBlock() {
					// TODO Auto-generated method stub

				}

				@Override
				public void renderText(TextRenderInfo textRenderInfo) {
					// TODO Auto-generated method stub
					String text = textRenderInfo.getText(); // 整页内容

					if (null != text && text.contains("Sendungsnr.:")) {
						com.itextpdf.awt.geom.Rectangle2D.Float boundingRectange = textRenderInfo.getBaseline()
								.getBoundingRectange();
						String s = boundingRectange.x + "--" + boundingRectange.y + "---" + boundingRectange.height;
						System.out.println(s);

//		                            float[] resu = new float[3];
//		                            resu[0] = boundingRectange.x;
//		                            resu[1] = boundingRectange.y;
//		                            resu[2] = i;
//		                            arrays.add(resu);
					}
				}
			});

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}