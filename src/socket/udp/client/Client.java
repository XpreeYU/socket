package socket.udp.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP�ͻ��˵�ʵ��
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) throws IOException {
		
		/**
		 * �����˷��͵�����
		 */
		//1.�������ĵ�ַ,�˿ںţ�����
		InetAddress address = InetAddress.getByName("127.0.0.1");
		int port = 8800;
		
		byte[] data = "User:yujiansong, pwd:123".getBytes();

		//2�������ݱ����������ݵ���Ϣ
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
		
		//3.����dataGramSocket����ʵ��
		DatagramSocket socket = new DatagramSocket();
		
		//4.��������˷�������
		socket.send(packet);
		
		/**
		 * ���ܷ���������Ӧ������
		 */
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		
		//���շ���������Ӧ������
		socket.receive(packet2);
		
		//��ȡ����
		String reply = new String(data2, 0, packet2.getLength());
		System.out.println("I'm client, Server speak:" + reply);
		
		//�ر���Դ
		socket.close();
	}
}
