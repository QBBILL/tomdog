package socket;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.GZIPOutputStream;

/**
 * Created by 钱斌 on 2016/8/22.
 */
public class TestSocket {

    @Test
    public void SocketServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = null;
        try {
            socket = serverSocket.accept();//使用accept()阻塞等待客户请求，有客户
        } catch (Exception e) {
            System.out.println("Error." + e);
        }
        PrintWriter os =new PrintWriter(socket.getOutputStream());
    }

    // http://54.222.253.178:8080/poi-tools/jobresult/59

    @Test
    public void SocketClient() throws IOException {
        Socket socket = new Socket("www.baidu.com", 80);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(outputStream, true);
        pw.println("GET /index.html HTTP/1.1");
        pw.println("Host: www.baidu.com:80");
        pw.println("Connection:Close");
        pw.println();//这里一定要一个回车换行，表示消息头完，不然服务器会等待
        StringBuffer sb = new StringBuffer();
        InputStreamReader fis = new InputStreamReader(socket.getInputStream());
        int i;
        while ((i = fis.read()) != -1) {
            sb.append((char) i);
        };
        fis.close();
        outputStream.close();
        socket.close();
        System.out.println(sb);
    }


    @Test
    public void testHttp() throws IOException {
        Socket socket = new Socket("54.222.253.178", 8080);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(outputStream, true);
        pw.println("GET /poi-tools/jobresult/59 HTTP/1.1");
        pw.println("Host: 54.222.253.178:8080");
        pw.println("Connection; Close");
        pw.println();

        InputStreamReader fis = new InputStreamReader(socket.getInputStream());
        GZIPOutputStream gos = new GZIPOutputStream(new FileOutputStream("C:\\home\\1.zip"));
        int i;
        while ((i = fis.read()) != -1) {
            gos.write(i);
        }
        ;
        gos.close();
        fis.close();
        socket.close();

    }


    public void client() {

    }
}
