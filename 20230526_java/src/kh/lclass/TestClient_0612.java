package kh.lclass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TestClient_0612 {
	public void test(String ip, int port) {
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			socket = new Socket(ip, port);
			
			is = socket.getInputStream();
			os = socket.getOutputStream();
			br = new BufferedReader(new InputStreamReader(is));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			
			String sendMsg = null;
			System.out.print("클라이언트로부터 보내는 메시지: ");
			sendMsg = stdIn.readLine();
			
			bw.write(sendMsg + "\n");
			bw.flush();
				
			String receivedMsg = br.readLine();
			System.out.println("서버로부터 받은 메시지: "+ receivedMsg);
		} catch (Exception e) {
		} finally {
			try {
				if(stdIn!=null) stdIn.close();
				if(bw!=null) bw.close();
				if(br!=null) br.close();
				if(os!=null) os.close();
				if(is!=null) is.close();
				if(socket!=null)socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
