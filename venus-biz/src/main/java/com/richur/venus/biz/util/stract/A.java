package com.richur.venus.biz.util.stract;



import com.google.common.base.Preconditions;

import java.net.*;

public class A {

    public static String getLocalHostIp() {
        try {
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            return hostAddress;
        } catch (UnknownHostException e) {
            return "127.0.0.1";
        }
    }

    public static long ip2Long(String ipStr) {
        Preconditions.checkNotNull(ipStr);
        long[] ip = new long[4];
        int position1 = ipStr.indexOf(".");
        int position2 = ipStr.indexOf(".", position1 + 1);
        int position3 = ipStr.indexOf(".", position2 + 1);
        ip[0] = Long.parseLong(ipStr.substring(0, position1));
        ip[1] = Long.parseLong(ipStr.substring(position1 + 1, position2));
        ip[2] = Long.parseLong(ipStr.substring(position2 + 1, position3));
        ip[3] = Long.parseLong(ipStr.substring(position3 + 1));
        return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
    }

    public static void main(String[] args) {
        System.out.println(ip2Long("10.70.152.25"));
    }
}
