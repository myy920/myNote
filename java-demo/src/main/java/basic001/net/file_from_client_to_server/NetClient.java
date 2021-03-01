package basic001.net.file_from_client_to_server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端: 上传文件
 */
public class NetClient {
    public static void main(String[] args) throws IOException {
        //连接到服务器
        Socket socket = new Socket("192.168.43.217", 8888);

        //创建读取本地文件的输入流和网络输出流
        FileInputStream fis = new FileInputStream("E:\\ac.jpg");
        OutputStream os = socket.getOutputStream();

        //读取本地文件并上传到服务器
        byte[] body = new byte[1024];
        int len = 0;
        while ((len = fis.read(body)) != -1) {
            os.write(body, 0, len);
        }

        //关闭流
        os.close();
        fis.close();
    }

}
