package com.sky.fly.rr.utils;

/**
 * Created by Android Studio.
 * Des:the description of current file
 * User: sky_fly_cloud
 * Date: 2018/2/26
 * Time: 上午9:51
 */

public class StringUtils
{
    /**
     * 字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str)
    {
        return str == null || str.length() == 0 || str.equals("null");
    }

    /**
     * 判断两个字符串是否相等
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equals(String str1, String str2)
    {
        return str1 == null || str2 == null?false:str1.equals(str2);
    }
}
