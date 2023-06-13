package ki.lclass.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpClient {
	
	public void testTcpClient(/* String ip, int port */String serverIp, int serverPort) {
		Socket socket = null;
//		InputStream in = null;
//		OutputStream out = null;
		BufferedReader br = null;
		//BufferedWriter wr = null;
		PrintWriter pw = null;
		
		// console에 입력한 문자 읽어들이기 위한 객체 2가지
		// 방법 1
		//Scanner sc = new Scanner(System.in);
		// Scanner와 유사한 기능
		// 방법 2
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			// 1. 서버의 IP주소와 서버가 정한 포트번호를 매개변수로 하여 클라이언트용 소켓 객체 생성
			//socket = new Socket(ip, port);
			socket = new Socket(serverIp, serverPort);
			//System.out.println("서버에 접속 성공");
			System.out.println("나의 Port "+ socket.getLocalPort());
			System.out.println("서버에 포트 "+ socket.getPort());
			
//			// 5.연결된 클라이언트와 입출력 스트림 생성
//			in = socket.getInputStream();
//			out = socket.getOutputStream();
//			// 6.보조 스트림을 통해 성능 개선
//			br = new BufferedReader(new InputStreamReader(in));
//			//wr = new BufferedWriter(new OutputStreamWriter(out));
//			pw = new PrintWriter(new OutputStreamWriter(out));
			
			// 2.연결된 클라이언트와 입출력 스트림 생성
			// 3.보조 스트림을 통해 성능 개선
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String sendMsg = null;
			while(true) {
				System.out.print("메시지>>");
				sendMsg = stdIn.readLine();	// console에 입력한 문자 읽어들이기
				System.out.println("########"+sendMsg);
				// server로 문자 전송
				pw.println(sendMsg);
				pw.flush();
				// server로 부터 메시지 읽기
				String receivedMsg = br.readLine();
				System.out.println("서버로부터 받은메시지: "+ receivedMsg);
			}
//			System.out.print("메시지>>");
//			sendMsg = stdIn.readLine();	// console에 입력한 문자 읽어들이기
//			System.out.println("########"+sendMsg);
//			
//			//wr.write(sendMsg);
//			pr.println(sendMsg);
//			//wr.flush();
//			pr.flush();
//			
//			String receivedMsg = br.readLine();
//			System.out.println("서버로부터 받은메시지: "+ receivedMsg);
			//wr.write("서비스 잘 부탁드립니다.");
			//wr.flush();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stdIn!=null) stdIn.close();
				//if(wr!=null) wr.close();
				if(pw!=null) pw.close();
				if(br!=null) br.close();
//				if(out!=null) out.close();
//				if(in!=null) in.close();
				if(socket!=null)socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
