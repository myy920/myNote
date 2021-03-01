package basic001.net.file_from_server_to_client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServer {
    public static void main(String[] args) throws IOException {
        //创建服务端并获取客户端的socket对象
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();

        //获取服务端文件的输入流和网络的输出流
        FileInputStream fis = new FileInputStream("E:\\ac.jpg");
        OutputStream os = socket.getOutputStream();

        //获取文件并输出到客户端
        byte[] body = new byte[1024];
        int len = 0;
        while ((len = fis.read(body)) != -1) {
            os.write(body, 0, len);
        }

        //禁用此套接字的输出流。对于 TCP 套接字，任何以前写入的数据都将被发送，并且后跟 TCP 的正常连接终止序列。
        // 如果在套接字上调用 shutdownOutput() 后写入套接字输出流，则该流将抛出 IOException。
        socket.shutdownOutput();

        //关闭流
        os.close();
        fis.close();
    }
}
