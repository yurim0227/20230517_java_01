package kh.lclass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer_0612 {
	public void test(int port) {
		ServerSocket ss = null;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
				
		try {
			ss = new ServerSocket(port);
			
			System.out.println("클라이언트 접속 대기 중.......");
			socket = ss.accept();
			System.out.println("클라이언트 접속: "+socket.getLocalPort());
			System.out.println("클라이언트 접속: "+socket.getPort());
			
			is = socket.getInputStream();
			os = socket.getOutputStream();
			br = new BufferedReader(new InputStreamReader(is));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			
			String receivedMsg = null;
			while((receivedMsg = br.readLine()) != null ) {
				System.out.println("클라이언트로부터 받은 메시지: "+receivedMsg);
				bw.write("메시지 수신 완료\n");
				bw.flush();
			}
		} catch (Exception e) {
		} finally {
			try {
				if(bw!=null) bw.close();
				if(br!=null) br.close();
				if(os!=null) os.close();
				if(is!=null) is.close();
				if(socket!=null) socket.close();
				if(ss!=null) ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
