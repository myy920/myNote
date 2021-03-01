package basic001.net.file_from_client_to_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器: 保存文件
 */
public class NetServer {
    public static void main(String[] args) throws IOException {
        //创建服务器并获取客户端的socket对象
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();

        //创建服务端保存文件的输出流和网络输入流
        FileOutputStream fos = new FileOutputStream("E:\\bc.jpg");
        InputStream is = socket.getInputStream();

        //读取上传的文件并输出到服务端保存文件
        byte[] body = new byte[1024];
        int len = 0;
        while ((len = is.read(body)) != -1) {
            fos.write(body, 0, len);
        }

        //关闭流
        socket.close();
        server.close();
    }
}
