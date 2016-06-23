package socket.udp.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP客户端的实现
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) throws IOException {
		
		/**
		 * 向服务端发送的数据
		 */
		//1.定义服务的地址,端口号，数据
		InetAddress address = InetAddress.getByName("127.0.0.1");
		int port = 8800;
		
		byte[] data = "User:yujiansong, pwd:123".getBytes();

		//2创建数据报，包含数据的信息
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
		
		//3.创建dataGramSocket对象实例
		DatagramSocket socket = new DatagramSocket();
		
		//4.向服务器端发送数据
		socket.send(packet);
		
		/**
		 * 接受服务器端响应的数据
		 */
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		
		//接收服务器端响应的数据
		socket.receive(packet2);
		
		//读取数据
		String reply = new String(data2, 0, packet2.getLength());
		System.out.println("I'm client, Server speak:" + reply);
		
		//关闭资源
		socket.close();
	}
}
