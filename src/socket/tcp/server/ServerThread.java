package socket.tcp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * ���������̴߳�����
 * @author Administrator
 *
 */
public class ServerThread extends Thread{

	//�߳���ص�Socket
	Socket socket = null;
	//��ʼ��Socket
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	//�߳�ִ�еĲ�������Ӧ�������˵�����
	@Override
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream oS = null;
		PrintWriter pw = null;
		try {
			//��ȡ�ͷ�����Ϣ
			 is = socket.getInputStream();//�ֽ���
			 isr = new InputStreamReader(is);//�ַ���
			//Ϊ�ַ�����ӻ���
			 br = new BufferedReader(isr);
		
			//ѭ����ȡ�ͻ�����Ϣ
			String info = null;
			while ((info = br.readLine()) != null) {
				System.out.println("I'm Server, client speak��" + info);
			}
		
			//��ȡ�����,��Ӧ�ͻ�������
			oS = socket.getOutputStream();
			pw = new PrintWriter(oS);
			pw.write("��ӭ�㣡");
			pw.flush();//ˢ�»���
			
			 
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			//�ر������Դ
			try {
				if (br != null) 
					br.close();
				if (isr != null) 
					isr.close();
				if (is != null) 
					is.close();
				if (oS != null) 
					oS.close();
				if (pw != null) 
					pw.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	
	}
	
}
