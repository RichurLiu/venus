package com.richur.venus.biz.util.test;

import lombok.Getter;
import lombok.Setter;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author richur
 * @since v0.0.1
 */
@Getter
@Setter
public class AutoExecuteDTO {

    private Boolean hdfsSave;
    private Integer jobType;
    private String sql;

    public static void main(String[] args) {
        try {
            //获取本地所有网络接口
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()) {
                //遍历枚举中的每一个元素
                NetworkInterface ni= en.nextElement();
                Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()  && !inetAddress.isLinkLocalAddress()
                            && inetAddress.isSiteLocalAddress()) {
                        System.out.println(inetAddress.getHostName());
                        System.out.println(inetAddress.getHostAddress());
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

}
