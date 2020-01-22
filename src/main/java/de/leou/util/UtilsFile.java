package de.leou.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class UtilsFile {
	public static String codeString(String fileName) throws Exception {

		File file = new File(fileName);
		if (file == null || !file.exists()) {
			System.out.println("文件不存在..." + file.getAbsolutePath());
			return null;
		}

		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
		int p = (bin.read() << 8) + bin.read();
		String code = null;
		// 其中的 0xefbb、0xfffe、0xfeff、0x5c75这些都是这个文件的前面两个字节的16进制数
		switch (p) {
		case 0xefbb:
			code = "UTF-8";
			break;
		case 0xfffe:
			code = "Unicode";
			break;
		case 0xfeff:
			code = "UTF-16BE";
			break;
		case 0x5c75:
			code = "ANSI|ASCII";
			break;
		default:
			code = "GBK";
		}

		return code;
	}

	/******************************
	 * 
	 * 
	 * 
	 *****************************/

	public static boolean urlToFile(String fileUrl, String filePathname) {

		try (BufferedInputStream in = new BufferedInputStream(new URL(fileUrl).openStream());
				FileOutputStream fileOutputStream = new FileOutputStream(filePathname)) {
			byte dataBuffer[] = new byte[1024];
			int bytesRead;
			while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
				fileOutputStream.write(dataBuffer, 0, bytesRead);
			}
			return false;
		} catch (IOException e) {
			// handle exception
		}

		return true;
	}

}
