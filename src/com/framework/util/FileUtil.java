package com.framework.util;

import java.io.*;

import org.apache.log4j.*;
import java.util.*;

import org.springframework.util.*;

public class FileUtil {
	public static final Logger logger = Logger.getLogger(FileUtil.class);
	private static final int BLOCK_SIZE = 20 * 1024;

	public FileUtil() {
	}

	/**
	 * 判断文件fileName是否存在
	 * @param fileName
	 * @return
	 */
	public static boolean isFileExits(String fileName) {
		boolean result = false;

		if (fileName != null) {
			try {
				File file = new File(fileName);
				if (file.exists()) {
					result = true;
				}
			} catch (Exception e) {

			}
		}
		return result;
	}

	/**
	 * 对文件进行断点续传添加
	 * @param in
	 * @param randomAccessFile
	 * @throws IOException
	 */
	public static void SaveFile(final InputStream in,
			final RandomAccessFile randomAccessFile) throws IOException {

		copyRandom(in, randomAccessFile);
	}

	/**
	 * puyuda add @ 20070430 sf-crm1.2.0
	 * 对文件进行断点续传添加
	 * @param in
	 * @param randomAccessFile
	 * @throws IOException
	 */

	public static void copyRandom(final InputStream in,
			final RandomAccessFile randomAccessFile) throws IOException {
		try {
			byte[] buffer = new byte[BLOCK_SIZE];
			int nrOfBytes = -1;
			randomAccessFile.seek(randomAccessFile.getFilePointer());
			while ((nrOfBytes = in.read(buffer)) != -1) {
				randomAccessFile.write(buffer, 0, nrOfBytes);
			}

		} finally {
			try {
				in.close();

			} catch (IOException ex) {
				logger.warn("Could not close Stream", ex);
			}

		}
	}

	/**
	 * 将附件存入系统中
	 * @param fileName String 文件名
	 * @param in InputStream 文件的输入流
	 * @param fileType String 该文件是系统的那种附件，对应FileUtil 的常量文件类型
	 * @throws IOException
	 */
	public static void SaveFile(String fileName, InputStream in, String filePath)
			throws IOException {
		List paths = paresFilePath(filePath);
		Iterator it = paths.iterator();
		ArrayList outList = new ArrayList();
		while (it.hasNext()) {
			String path = it.next().toString();
			OutputStream out = null;
			out = new FileOutputStream(path + fileName);
			outList.add(out);
		}
		copy(in, outList);
	}

	public static String makCsvFile(List outputList) {
		String outputStr = "";
		//回车符
		char returnChar = 13;
		//换行符
		char lineChar = 10;
		Iterator it = outputList.iterator();
		while (it.hasNext()) {
			String unitStr = "";
			List unitList = (List) it.next();
			if (unitList != null && unitList.size() != 0) {
				Iterator uit = unitList.iterator();
				while (uit.hasNext()) {
					Object unitOb = uit.next();
					String unit = "";
					if (unitOb != null) {
						unit = unitOb.toString().replaceAll(",", "");
					}
					unitStr = unitStr + unit + ",";
				}
				//
				unitStr = unitStr.substring(0, unitStr.length() - 1)
						+ returnChar + lineChar;
			}
			outputStr = outputStr + unitStr;
		}
		//return encodeGBK(outputStr);
		return outputStr;
	}

	/**
	 * puyuda add @ 2006.08.22
	 * csv文件格式化
	 * @param outputList
	 * @return
	 */
	public static String makCsvFileFormate(List outputList) {
		StringBuffer outputStr = new StringBuffer();
		//回车符���
		char returnChar = 13;
		//换行符
		char lineChar = 10;
		Iterator it = outputList.iterator();

		while (it.hasNext()) {
			StringBuffer unitStr = new StringBuffer();
			List unitList = (List) it.next();
			if (unitList != null && unitList.size() != 0) {
				Iterator uit = unitList.iterator();
				while (uit.hasNext()) {
					Object unitOb = uit.next();
					String unit = "";
					if (unitOb != null) {
						//Altered by Larry.Wang on 20080805
						//unit = unitOb.toString().replaceAll(",","");
						unit = unitOb.toString().trim().replaceAll("\"", "��")
								.replaceAll(",", "��");
						if (unit.indexOf('\n') > 0) {
							unit = "\"" + unit + "\"";
						}
					}
					unitStr.append(unit);
					unitStr.append(",");

				}
				unitStr.deleteCharAt(unitStr.length() - 1);
				unitStr.append(returnChar);
				unitStr.append(lineChar);

			}
			outputStr.append(unitStr);
		}

		return outputStr.toString();
	}

	public static String enterStr() {
		//回车符
		char returnChar = 13;
		//换行符
		char lineChar = 10;
		return "" + returnChar + lineChar;
	}

	/**
	 * 将用户指定的文件写入传入的输出流中
	 * @param fileType String 
	 * @param fileName String
	 * @param out OutputStream
	 */
	public static void getFileContent(String fileType, String fileName,
			OutputStream out) throws IOException {
		List paths = paresFilePath(fileType);
		/**@todo 只取第一个 path*/
		String path = paths.get(0).toString();
		File pic = new File(path + "/" + fileName);
		FileCopyUtils.copy(new FileInputStream(pic), out);
	}

	/**
	 * 删除一个文件
	 * @param fileType String
	 * @param fileName String
	 */
	public static void deleteFile(String fileType, String fileName) {
		List paths = paresFilePath(fileType);
		Iterator it = paths.iterator();
		while (it.hasNext()) {
			String path = it.next().toString();
			File f = new File(path + "/" + fileName);
			if (f != null && f.exists()) {
				f.delete();
			}

		}
	}

	/**
	 * 拷贝文件
	 * @param fromFileType String从那个路径下拷贝（只取路径串的第一个目录）
	 * @param toFileType String拷贝到哪个目录
	 * @param fileName String 源文件名
	 * @param targetFileName String 目标文件名
	 * @param isCut boolean 表示是否剪切 
	 */
	public static void copyFile(String fromFileType, String toFileType,
			String fileName, String targetFileName, boolean isCut)
			throws FileNotFoundException, IOException {

		//读源文件
		List fromPaths = paresFilePath(fromFileType);
		/**@todo 只取第一个 path*/
		String fromPath = fromPaths.get(0).toString();
		File in = new File(fromPath + "/" + fileName);

		//写到目标文件
		List paths = paresFilePath(toFileType);
		Iterator it = paths.iterator();
		ArrayList outFiles = new ArrayList();
		while (it.hasNext()) {
			String path = it.next().toString();
			FileOutputStream out = new FileOutputStream(path + "/"
					+ targetFileName);
			outFiles.add(out);
		}
		copy(new FileInputStream(in), outFiles);
		if (isCut)
			in.delete();
	}
	
	private static List paresFilePath(String path) {
		StringTokenizer token = new StringTokenizer(path, ";");
		ArrayList result = new ArrayList();
		while (token.hasMoreTokens()) {
			String temp = token.nextToken();
			if (!temp.endsWith("\\") && !temp.endsWith("/"))
				temp = temp + "/";
			result.add(temp);
		}
		return result;
	}

	private static void copy(InputStream in, List outputStreamList)
			throws IOException {

		try {
			byte[] buffer = new byte[BLOCK_SIZE];
			int nrOfBytes = -1;
			while ((nrOfBytes = in.read(buffer)) != -1) {
				for (int i = 0; i < outputStreamList.size(); i++) {
					OutputStream out = (OutputStream) outputStreamList.get(i);
					out.write(buffer, 0, nrOfBytes);
				}

			}
			for (int i = 0; i < outputStreamList.size(); i++) {
				((OutputStream) outputStreamList.get(i)).flush();
			}
		} finally {
			try {
				in.close();
			} catch (IOException ex) {
				logger.warn("Could not close InputStream", ex);
			}
			try {
				for (int i = 0; i < outputStreamList.size(); i++) {
					((OutputStream) outputStreamList.get(i)).close();
				}

			} catch (IOException ex) {
				logger.warn("Could not close OutputStream", ex);
			}
		}
	}	

}
