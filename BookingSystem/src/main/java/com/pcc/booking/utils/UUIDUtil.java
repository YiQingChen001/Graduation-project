package com.pcc.booking.utils;

import java.util.UUID;

/**
 * 生成订单号
 */
public class UUIDUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
