package com.joyfulmath.sample.javanetwork.UrlTester;

import com.joyfulmath.sample.javanetwork.ITestOperator;
import com.joyfulmath.sample.javanetwork.utils.TraceLog;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author deman.lu email luyuanchun032@pingan.com.cn
 * @version on 2015-12-28 16:35
 */
public class EncoderTester implements ITestOperator{
    public static final String DEFAULT_ENCODE = "UTF-8";
    @Override
    public void startTest() {
        try {
            String str = URLEncoder.encode("This is a + base string 我 吃 饭",DEFAULT_ENCODE);
            TraceLog.i(str);
            str = URLDecoder.decode(str, DEFAULT_ENCODE);
            TraceLog.i(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
