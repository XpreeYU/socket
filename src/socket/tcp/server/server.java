package socket.tcp.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Administrator
 * Server ʵ��TCPЭ���Socket
 */
public class server {

	public static void main(String[] args) {
		try {
			//1.����serverSocketʵ��,��ָ���˿�
			ServerSocket  serverSocket = new ServerSocket(8888);
			Socket socket = null;
			//��¼�ͻ�����������
			int count = 0;
			System.out.println("server started ,wait client...");
			
			//ѭ�������ͻ�������
			while (true) {
				//����serversocket�ļ�������
				socket = serverSocket.accept();
				//����һ���߳�
				ServerThread serverThread = new ServerThread(socket);
				//�����߳�
				serverThread.start();
				
				//ͳ�ƿͻ��˵�����
				count++;
				System.out.println("�ͻ��˵�����Ϊ��" + count);
				InetAddress inetAddress = socket.getInetAddress();
				System.out.println("��ǰ�ͻ��˵�IP��ַΪ��" + inetAddress.getHostAddress());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
