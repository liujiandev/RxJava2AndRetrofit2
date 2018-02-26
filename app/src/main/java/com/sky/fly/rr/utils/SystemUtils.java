package com.sky.fly.rr.utils;

/**
 * Created by sky on 2016/11/18.
 */

public class SystemUtils
{

    public static boolean isDebug = true;// 是否需要打印bug，可以在application的onCreate函数里面初始化
    public static void println(String content)
    {
        if(isDebug)
        {
            System.out.println(content);
        }
    }

    public static void println(boolean content)
    {
        if(isDebug)
        {
            System.out.println(content);
        }
    }

    public static void println(char content)
    {
        if(isDebug)
        {
            System.out.println(content);
        }
    }

    public static void println(int content)
    {
        if(isDebug)
        {
            System.out.println(content);
        }
    }

    public static void print(String content)
    {
        if(isDebug)
        {
            System.out.print(content);
        }
    }

    public static void print(boolean content)
    {
        if(isDebug)
        {
            System.out.print(content);
        }
    }

    public static void print(char content)
    {
        if(isDebug)
        {
            System.out.print(content);
        }
    }

    public static void print(int content)
    {
        if(isDebug)
        {
            System.out.print(content);
        }
    }
}
