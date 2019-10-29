package com.michael.util;

import java.util.UUID;

public class UUIDUtil {

    public static String createUserId(){
        return UUID.randomUUID().toString().replace("-","").substring(0,16);
    }

    public static String createOrderId(){
        return UUID.randomUUID().toString().replace("-","").substring(0,18);
    }
}
