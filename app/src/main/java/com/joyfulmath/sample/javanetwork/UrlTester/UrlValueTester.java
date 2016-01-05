package com.joyfulmath.sample.javanetwork.UrlTester;

import com.joyfulmath.sample.javanetwork.ITestOperator;
import com.joyfulmath.sample.javanetwork.utils.TraceLog;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * @author deman.lu email luyuanchun032@pingan.com.cn
 * @version on 2015-12-28 11:04
 */
public class UrlValueTester implements ITestOperator {
    @Override
    public void startTest() {
        try {
            URL u = new URL("http://tieba.baidu.com/f/fdir?fd=%E7%A7%91%E5%AD%A6%E6%8A%80%E6%9C%AF&ie=utf-8&sd=%E8%AE%A1%E7%AE%97%E6%9C%BA%E8%BD%AF%E4%BB%B6");
            method(u);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void method(URL u) throws InvocationTargetException, IllegalAccessException {
        Class cls = u.getClass();
        Method[] methods = cls.getDeclaredMethods();
        for(Method m:methods)
        {
            try{
                if(m.getName().contains("get"))
                {
                    TraceLog.i(m.getName());
                    TraceLog.i(":"+m.invoke(u));
                }
            }catch (Exception e)
            {
                TraceLog.w(m.getName());
            }

        }
    }
}
