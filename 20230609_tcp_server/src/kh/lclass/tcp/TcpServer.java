package kh.lclass.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public void testTcpServer(int port) {
		// 1. 서버의 포트번호 정함 ==> 프로그램의 포트번호
		
		ServerSocket ss = null;
		Socket sc = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedReader br = null;
		BufferedWriter wr = null;
		try/* (ServerSocket ss=new ServerSocket(port);) */{
			// 2. 서버용 소켓 객체 생성
			ss = new ServerSocket(port);
			
			// 3. 클라이언트 쪽에서 접속 요청이 오길 기다림
			// 4.접속 요청이 오면 요청 수락 후 해당 클라이언트에 대한 소켓 객체 생성
			sc = ss.accept();
			
			// 5.연결된 클라이언트와 입출력 스트림 생성
			in = sc.getInputStream();
			out = sc.getOutputStream();
			// 6.보조 스트림을 통해 성능 개선
			br = new BufferedReader(new InputStreamReader(in));
			//BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			wr = new BufferedWriter(new OutputStreamWriter(out));
			//BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));
			
			wr.write("반갑습니다.");
			wr.flush();
			
			String receivedMsg = br.readLine();
			System.out.println("받은메시지: "+receivedMsg);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//Resource leak: '<unassigned Closeable value>' is never closed
				if(wr!=null)ss.close();
				if(br!=null)ss.close();
				if(out!=null)ss.close();
				if(in!=null)ss.close();
				if(sc!=null)ss.close();
				if(ss!=null)ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
