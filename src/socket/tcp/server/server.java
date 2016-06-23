package socket.tcp.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Administrator
 * Server 实现TCP协议的Socket
 */
public class server {

	public static void main(String[] args) {
		try {
			//1.创建serverSocket实例,绑定指定端口
			ServerSocket  serverSocket = new ServerSocket(8888);
			Socket socket = null;
			//记录客户端连接数量
			int count = 0;
			System.out.println("server started ,wait client...");
			
			//循环监听客户端请求
			while (true) {
				//调用serversocket的监听方法
				socket = serverSocket.accept();
				//创建一个线程
				ServerThread serverThread = new ServerThread(socket);
				//其他线程
				serverThread.start();
				
				//统计客户端的数量
				count++;
				System.out.println("客户端的数量为：" + count);
				InetAddress inetAddress = socket.getInetAddress();
				System.out.println("当前客户端的IP地址为：" + inetAddress.getHostAddress());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
