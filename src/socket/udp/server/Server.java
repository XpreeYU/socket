package socket.udp.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * ʵ��UDP socket���
 * @author Administrator
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		/**
		 * ���ܿͻ��˷��͵�����
		 */
		//1.����Server DatagramSocket ָ���˿ں�
		DatagramSocket socket = new DatagramSocket(8800);
		
		//2.�������ݰ������ܿͻ��˵�����
		byte[] data = new byte[1024];//�����ֽ�����
		
		//3.����datagramPacket
		DatagramPacket packet = new DatagramPacket(data, data.length);
		
		System.out.println("�����������������ȴ��ͻ��˽���...");
		//4.���տͻ��˷��͵�����
		socket.receive(packet);//��������״̬���ȴ��ͻ��˵�����
		
		//5.��ȡ����
		String info = new String(data, 0, packet.getLength());
		System.out.println("I'm Serverm, Client speak��" + info);
		
		/**
		 * ��Ӧ�ͻ���
		 */
		//1.����ͻ��˵ĵ�ַ�Ͷ˿ںţ�����
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "��ӭ��ͻ���".getBytes();
		
		//2.�������ݱ�
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
		
		//3.��Ӧ�ͻ�
		socket.send(packet2);
		
		//4.�ر���Դ
		socket.close();
	}
}
