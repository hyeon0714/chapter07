package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException{

		//서버소켓생성
		ServerSocket serverSocket = new ServerSocket();
		
		//바인딩
		serverSocket.bind(new InetSocketAddress("192.168.0.22", 10001));
		
		//서버시작
		System.out.println("<서버시작>");
		System.out.println("==================================================");
		
		////////반복(스레드)
		while(true) {
		System.out.println("[연결을 기다리고 있습니다.]");
		
		//클라이언트가 접속을 하면 accept()가 실행됨
		Socket socket = serverSocket.accept();
		
		//스레드 시작 = thread.start
		
		Thread thread=new ServerThread(socket);
		thread.start();
		/*=>스레드로 반복할 문장들
		System.out.println("[클라이언트가 연결 되었습니다.]");
		
		
		//메세지 받기용 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//메세지 보내기용 스트림
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter isw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(isw);
		
		//////
		while(true) {
			//메세지 받기
			String msg = br.readLine();
			if(msg==null) {
				break;
			}
			
			System.out.println("받은메세지:" + msg);
			
			//메세지 보내기
			bw.write(msg);
			bw.newLine();
			bw.flush();
		}
		*/
		//////반복 종료(스레드)
		
		System.out.println("=======================================");
		System.out.println("<서버 종료>");
		}
		//닫기
		
		//socket.close();
		//serverSocket.close();

	}

}