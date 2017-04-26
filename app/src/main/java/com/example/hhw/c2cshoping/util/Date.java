package com.example.hhw.c2cshoping.util;

public class Date {
    private static String user_id;                          //用户账号
    private static boolean isCartChange = false;            //购物车发生了改变
    public static void setUser_id(String user_id) {
        Date.user_id = user_id;
    }
    public static String getUser_id() {
        return user_id;
    }

    public static void setIsCartChange(boolean isCartChange) {
        Date.isCartChange = isCartChange;
    }
    public static boolean getIsCartChange() {
        return isCartChange;
    }
}
