package com.joyfulmath.sample.javanetwork.UrlTester;

import com.joyfulmath.sample.javanetwork.ITestOperator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author deman.lu email luyuanchun032@pingan.com.cn
 * @version on 2015-12-28 16:43
 */
public class URLTestFactory {

    public static ITestOperator getOperator(Class<?> c)
    {
        ITestOperator result = null;
        try {
            Constructor<?> ct[] = c.getConstructors();
            result = (ITestOperator) (ct[0].newInstance());
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
