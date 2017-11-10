package com.xhlim;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by xhlim on 2017/8/18.
 */
public class Test {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        for (int i = 0;i < 1000 * 1000 * 1000;i++){
            String orderNo = UUID.randomUUID().toString();
            if (set.contains(orderNo)){
                System.out.println(i);
                break;
            }
            set.add(orderNo);
        }
    }

    public static String getOrderNo() {
        String orderNo = "";
        String trandNo = String.valueOf((Math.random() * 9 + 1) * 1000000);
        String sdf = new SimpleDateFormat("yyyyMMddHHMMSS").format(new Date());
        orderNo = trandNo.toString().substring(0, 4);
        orderNo = orderNo + sdf;
        return orderNo;
    }
}
