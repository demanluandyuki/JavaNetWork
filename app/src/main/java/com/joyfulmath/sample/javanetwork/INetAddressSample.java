package com.joyfulmath.sample.javanetwork;

import com.joyfulmath.sample.javanetwork.utils.TraceLog;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * @author  deman.lu on 2015-12-23 16:00
 * email    luyuanchun032@pingan.com.cn
 */
public class INetAddressSample implements ITestOperator {

    @Override
    public void startTest() {
        try {
            test1();
            test2();
            test3();
            test4();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void test1() throws UnknownHostException
    {
        InetAddress address = InetAddress.getByName("www.oreilly.com");
        TraceLog.i(address.toString());

        TraceLog.i(address.getHostName());
    }

    private void test2() throws UnknownHostException
    {
        InetAddress address = InetAddress.getLocalHost();
        TraceLog.i("getLocalHost "+address.toString());

        TraceLog.i(String.valueOf(address.isLoopbackAddress()));
    }


    private void test3() throws IOException
    {
        InetAddress address = InetAddress.getByName("www.oreilly.com");
        TraceLog.i(String.valueOf(address.isReachable(1000)));
    }

    private void test4() throws SocketException
    {
        Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
        while (netInterfaces.hasMoreElements()) {
            NetworkInterface nif = netInterfaces.nextElement();
            Enumeration<InetAddress> iParray = nif.getInetAddresses();
            while (iParray.hasMoreElements()) {
                InetAddress ip = iParray.nextElement();
                TraceLog.i(ip.getHostAddress());
            }
        }
    }
}
