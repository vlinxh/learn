package com.xhlim.assertion;

/**
 * 启动VM options 参数配置-ea
 * @author xhlim@outlook.com
 * @create 2017-09-15 15:18
 */
public class AssertionMain {

    public static void main(String[] args) {
        String str = null;
        boolean isOpen = false;
        assert isOpen = true;             //如果开启了断言，会将isOpen的值改为true
        System.out.println("是否开启了断言" + isOpen);  //打印是否开启了断言
        if (isOpen) {
            int value = -1;
            assert 0 < value : "value=" + value;
        }
        System.out.println("----end----");
    }
}
