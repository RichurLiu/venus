package com.richur.venus.web.tomcat;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Project : venus
 * @Package : com.richur.venus.web.tomcat
 * @Author : richur
 * @Date : 2022/12/31 4:34 下午
 */
@Slf4j
public class WebMain {
    public static void main(String[] args) {

    }

    // 是否关闭Server

    private boolean shutdown = false;

    public void await() {
        // 启动ServerSocket
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket =  new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            log.error("create server socket fail", e);
            System.exit(1);
        }
        while (!shutdown) {
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;
            try {
                // 创建socket
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();

                // 封装input至request, 并处理请求
                WebRequest request = new WebRequest(input);
                request.parse();

                // 封装output至response
//                Response response = new Response(output);
//                response.setRequest(request);
//                response.sendStaticResource();

                // 关闭socket
                socket.close();

            } catch (Exception e) {
                log.error("", e);
                continue;
            }
        }
    }
}
