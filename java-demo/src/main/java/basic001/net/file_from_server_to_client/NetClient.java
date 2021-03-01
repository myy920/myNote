package basic001.net.file_from_server_to_client;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class NetClient {
    public static void main(String[] args) throws IOException {
        //创建连接服务端的socket对象
        Socket socket = new Socket("192.168.43.217", 8888);

        //创建客户端保存文件的输出流和网络输入流
        FileOutputStream fos = new FileOutputStream("E:\\cc.jpg");
        InputStream is = socket.getInputStream();

        //获取输入流中文件并将其输出到客户端保存的文件中
        byte[] body = new byte[1024];
        int len = 0;
        while ((len = is.read(body)) != -1) {
            fos.write(body, 0, len);
        }

        //关闭流
        fos.close();
        is.close();
    }
}
