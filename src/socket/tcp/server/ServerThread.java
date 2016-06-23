package socket.tcp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 服务器端线程处理类
 * @author Administrator
 *
 */
public class ServerThread extends Thread{

	//线程相关的Socket
	Socket socket = null;
	//初始化Socket
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	//线程执行的操作，相应服务器端的请求
	@Override
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream oS = null;
		PrintWriter pw = null;
		try {
			//读取客服端信息
			 is = socket.getInputStream();//字节流
			 isr = new InputStreamReader(is);//字符流
			//为字符流添加缓冲
			 br = new BufferedReader(isr);
		
			//循环读取客户端信息
			String info = null;
			while ((info = br.readLine()) != null) {
				System.out.println("I'm Server, client speak：" + info);
			}
		
			//获取输出流,相应客户端请求
			oS = socket.getOutputStream();
			pw = new PrintWriter(oS);
			pw.write("欢迎你！");
			pw.flush();//刷新缓存
			
			 
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			//关闭相关资源
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
