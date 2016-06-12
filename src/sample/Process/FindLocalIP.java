package sample.Process;

import java.net.InetAddress;

/**
 * Created by JKKim on 2016. 6. 12..
 */
public class FindLocalIP {
    public static String getLocalServerIp()
    {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            return ip.getHostAddress();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return "0.0.0.0";
    }
}
