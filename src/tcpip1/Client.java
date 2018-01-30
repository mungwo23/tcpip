package tcpip1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		String ip="70.12.111.130";
		int port =7777;
		Socket socket = null;
		OutputStream outs=null;
		OutputStreamWriter outw=null;
		try {
			
			
			System.out.println("Start Client...");
			socket = new Socket(ip, port);
			System.out.println("Connected OK...");
			
			//Send Data ...
			outs= socket.getOutputStream();
			outw= new OutputStreamWriter(outs);
			//2byte씩 보냄(한국어,중국어,일어)
			
			outw.write("피곤해 뉴뉴");
			System.out.println("Send Completed...");
			
			
			
		} catch (UnknownHostException e) {//서버가죽거나
			e.printStackTrace();
		} catch (IOException e) {//네트워크문제
			e.printStackTrace();
		}finally {
			try {
				outw.close();
				outs.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	

}
