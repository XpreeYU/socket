package socket.tcp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * @author Administrator
 * Clicet
 */
public class client {

	public static void main(String[] args) {
		try {
			//1.�����ͻ���
			Socket socket = new Socket("127.0.0.1", 8888);
			
			//2.��ȡ�����
			OutputStream os = socket.getOutputStream();//�ֽ������
			PrintWriter writer = new PrintWriter(os);
			writer.write("�û�����admin");
			writer.write("���룺123456");
			writer.flush();//ˢ�»���
			socket.shutdownOutput();
			
			//3.��ȡ����������ȡ����������Ϣ
			InputStream is = socket.getInputStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while ((info = bf.readLine()) != null) {
				System.out.println("I'm Client, server speak��" + info);
			}
			
			//3.�ر�������Դ
			writer.close();
			bf.close();
			is.close();
			os.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
