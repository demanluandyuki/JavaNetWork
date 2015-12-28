package com.joyfulmath.sample.javanetwork;

import com.joyfulmath.sample.javanetwork.utils.TraceLog;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author deman.lu email luyuanchun032@pingan.com.cn
 * @version on 2015-12-25 16:48
 */
public class ProtocolTester implements IOperator {
    @Override
    public void start() {
        testProtocol("http://www.adc.org");
        testProtocol("https://www.amazon.com");
        testProtocol("ftp://metalab.unc.edu");
        testProtocol("telent://dibner.poly.edu");

    }

    private void testProtocol(String url) {
        try {
            URL u = new URL(url);
            TraceLog.i(u.getProtocol()+" is supported");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            TraceLog.w(e.getMessage());
        }
    }
}
