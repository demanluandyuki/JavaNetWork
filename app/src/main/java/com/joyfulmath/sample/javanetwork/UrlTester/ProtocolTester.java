package com.joyfulmath.sample.javanetwork.UrlTester;

import com.joyfulmath.sample.javanetwork.ITestOperator;
import com.joyfulmath.sample.javanetwork.utils.TraceLog;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author deman.lu email luyuanchun032@pingan.com.cn
 * @version on 2015-12-25 16:48
 */
public class ProtocolTester implements ITestOperator {
    @Override
    public void startTest() {
        testProtocol("http://www.adc.org");
        testProtocol("https://www.amazon.com");
        testProtocol("ftp://metalab.unc.edu");
        testProtocol("telent://dibner.poly.edu/");
        testProtocol("mailto:joyfulmath@163.com");
        testProtocol("file:///etc/passwd");
        testProtocol("gopher://gopher.anc.org.za");
        testProtocol("ladp://ldap.itd.umich.edu");
        testProtocol("jar:http://ldap.itd.umich.edu.jar");
        testProtocol("nfs://utopia.poly.edu");
        testProtocol("jdbc:mysql:/utopia.poly.edu");

    }

    private void testProtocol(String url) {
        try {
            URL u = new URL(url);
            TraceLog.i(u.getProtocol()+" is supported");
        } catch (MalformedURLException e) {
//            e.printStackTrace();
//            TraceLog.w(e.getMessage());
            String protocol  = url.substring(0,url.indexOf(':'));
            TraceLog.w(protocol + " is not supported");
        }
    }
}
