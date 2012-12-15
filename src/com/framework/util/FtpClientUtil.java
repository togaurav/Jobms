/**
 * 
 */
package com.framework.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ProtocolCommandEvent;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.io.CopyStreamAdapter;
import org.apache.commons.net.io.CopyStreamEvent;
import org.apache.commons.net.io.Util;
import org.apache.log4j.Logger;

/**
 * @author 陆庆润
 * @createTime 2009-6-5 下午09:43:18
 */
public class FtpClientUtil {
	private static final Logger logger = Logger.getLogger(FtpClientUtil.class);
	private String hostname = "";
	private String username = "";
	private String password = "";
	private int port;

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	private final FTPClient ftpClient;
	private int reply;

	public FtpClientUtil(String hostname, String username, String password,
			int port) {
		this.hostname = hostname;
		this.username = username;
		this.password = password;
		this.port = port;
		ftpClient = new FTPClient();
		// 缓存大小-1M
		ftpClient.setBufferSize(1024 * 1024);
		ftpClient.setControlEncoding("UTF-8");
		FTPClientConfig config = new FTPClientConfig(FTPClientConfig.SYST_UNIX);
		config.setRecentDateFormatStr("yyyy-MM-dd HH:mm:SS");
		ftpClient.configure(config);
	}

	public void storeFile(String localPath, String remotePath)
			throws IOException {
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new BufferedInputStream(ftpClient
					.retrieveFileStream(remotePath), ftpClient.getBufferSize());
			reply = ftpClient.getReplyCode();
			if (FTPReply.FILE_STATUS_OK != reply) {
				logger.error("FTPClient storeFile fail : reply[" + reply + "]");
				throw new IOException("FTP服务器,不存在此文件");
			}
			File file = new File(localPath);
			File parentFile = file.getParentFile();
			if (!parentFile.exists()) {
				parentFile.mkdirs();
			}
			output = new FileOutputStream(file);
			Util.copyStream(input, output, ftpClient.getBufferSize(),
					CopyStreamEvent.UNKNOWN_STREAM_SIZE,
					new CopyStreamAdapter() {
						@Override
						public void bytesTransferred(
								long totalBytesTransferred,
								int bytesTransferred, long streamSize) {
							// Your progress Control code here
						}
					});
			ftpClient.completePendingCommand();
			output.flush();
			logger.info("FTPClient storeFile sucess : localPath[" + localPath
					+ "]");
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (input != null) {
					input.close();
				}
				if (output != null) {
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 登录FTP服务器
	 * 
	 * @throws IOException
	 * @throws SocketException
	 */
	public void login() throws SocketException, IOException {
		if (port == 0) {
			ftpClient.connect(hostname);
		} else {
			ftpClient.connect(hostname, port);
		}
		ftpClient.login(username, password);
		// 设置传送文件类型-二进制文件
		ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
		// 设置日志输出方式-Logger
		ftpClient.addProtocolCommandListener(new LoggerCommandListener(logger));
		reply = ftpClient.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			logger.error("FTPClient login fail hostname[" + hostname
					+ "],port[" + port + "],username[" + username
					+ "],password[" + password + "]");
			throw new SocketException("FTPClient login fail hostname["
					+ hostname + "],port[" + port + "],username[" + username
					+ "],password[" + password
					+ "] FTP server refused connection.");
		}
		logger.info("FTPClient login sucess hostname[" + hostname + "],port["
				+ port + "],username[" + username + "],password[" + password
				+ "]");
	}

	/**
	 * 登出FTP服务器
	 * 
	 * @throws IOException
	 */
	public void logout() throws IOException {
		ftpClient.logout();
		if (ftpClient.isConnected()) {
			ftpClient.disconnect();
		}
		logger.info("FTPClient logout sucess hostname[" + hostname + "],port["
				+ port + "],username[" + username + "],password[" + password
				+ "]");
	}

	private class LoggerCommandListener implements ProtocolCommandListener {
		private final Logger __logger;

		public LoggerCommandListener(Logger logger) {
			__logger = logger;
		}

		public void protocolCommandSent(ProtocolCommandEvent event) {

			__logger.info("console-" + event.getMessage());

		}

		public void protocolReplyReceived(ProtocolCommandEvent event) {
			__logger.info("console-" + event.getMessage());
		}
	}

	public static void copyFile(String localPath, String remotePath)
			throws Exception {
		String ftpAddress = "ftp://root:root@10.65.200.38/share/1/0/20090605/1003/1523333.V3";
		String hostname = "10.65.200.38";
		String username = "root";
		String password = "root";
		int port = 0;
		FtpClientUtil ftp = new FtpClientUtil(hostname, username, password,
				port);

		try {
			ftp.login();
			ftp.storeFile(localPath, remotePath);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			ftp.logout();
		}
	}

	public static void main(String[] args) throws Exception {
		copyFile("E:\\aa\\apwp\\ssssssssss\\aadfa.mp3\\aafd.saf",
				"/share/1/0/20090605/1003/1523333.V3");

	}
}
