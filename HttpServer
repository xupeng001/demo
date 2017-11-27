package org.io.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class HttpServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(80);
			while (true) {
				Socket socket = serverSocket.accept();
				InputStream inputStream = socket.getInputStream();
				BufferedInputStream stream = new BufferedInputStream(
						inputStream);
				int n = 512;
				byte buffer[] = new byte[n];
				// 读取输入流
				stream.read(buffer, 0, n);
				// while (((stream.read(buffer, 0, n)) != -1) && (n > 0)) {
				System.out.print(new String(buffer));
				// }

				OutputStream outputStream = socket.getOutputStream();
				BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
						outputStream);
				System.out.println();
				StringBuffer sb = new StringBuffer();
				sb.append("HTTP/1.0 200 OK").append("\r\n")
						.append("Content-Type:text/html; charset=utf-8")
						// .append("\r\n").append("Date:")
						// .append(new Date())
						// // .append("\r\n")
						// // .append("Vary:Accept-Encoding")
						// .append("\r\n").append("Connection:close")
						// // .append("\r\n").append("Content-Encoding:gzip")
						.append("\r\n").append("\r\n")
						// .append("<font color='red' >OK</font>");
						.append("{}");
				// System.out.println(sb);
				bufferedOutputStream.write(sb.toString().getBytes());
				PrintWriter out = new PrintWriter(bufferedOutputStream, true);
				out.println(sb);
				out.close();
				bufferedOutputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

	}
}
