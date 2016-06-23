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
			//1.创建客户端
			Socket socket = new Socket("127.0.0.1", 8888);
			
			//2.获取输出流
			OutputStream os = socket.getOutputStream();//字节输出流
			PrintWriter writer = new PrintWriter(os);
			writer.write("用户名：admin");
			writer.write("密码：123456");
			writer.flush();//刷新缓存
			socket.shutdownOutput();
			
			//3.获取输入流，读取服务器端信息
			InputStream is = socket.getInputStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while ((info = bf.readLine()) != null) {
				System.out.println("I'm Client, server speak：" + info);
			}
			
			//3.关闭其他资源
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
