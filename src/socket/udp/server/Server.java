package socket.udp.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 实现UDP socket编程
 * @author Administrator
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		/**
		 * 接受客户端发送的数据
		 */
		//1.创建Server DatagramSocket 指定端口号
		DatagramSocket socket = new DatagramSocket(8800);
		
		//2.创建数据包，接受客户端的数据
		byte[] data = new byte[1024];//创建字节数组
		
		//3.创建datagramPacket
		DatagramPacket packet = new DatagramPacket(data, data.length);
		
		System.out.println("服务器端已启动，等待客户端接入...");
		//4.接收客户端发送的数据
		socket.receive(packet);//处于阻塞状态，等待客户端的请求
		
		//5.读取数据
		String info = new String(data, 0, packet.getLength());
		System.out.println("I'm Serverm, Client speak：" + info);
		
		/**
		 * 响应客户端
		 */
		//1.定义客户端的地址和端口号，数据
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "欢迎你客户端".getBytes();
		
		//2.创建数据报
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
		
		//3.响应客户
		socket.send(packet2);
		
		//4.关闭资源
		socket.close();
	}
}
