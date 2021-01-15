package com.lyao.socket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author lyao
 * @date 2018/7/13 15:26
 * @description
 */
public class ClientSocket {

    public static void main(String[] args) {
        Socket socket = new Socket();
        SocketAddress hostAddress = new InetSocketAddress("www.baidu.com",80);
        try {


            socket.connect(hostAddress,6000);

            StringBuilder sb = new StringBuilder();
            sb.append("GET / HTTP/1.1\r\n");
            sb.append("Host: www.baidu.com:80\r\n");
            sb.append("\r\n");
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(sb.toString().getBytes());

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String data;
            while ((data = bufferedReader.readLine()) != null){
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
