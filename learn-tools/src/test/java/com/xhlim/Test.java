package com.xhlim;


import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-04 18:10
 */
public class Test {



    public static void main(String[] args) {
        try {
            int i = 1 / 0;
        }catch (Exception e) {
            e.printStackTrace();
            // System.out.println(getTrace(e));

        }

    }

    public static String getTrace(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        return buffer.toString();
    }
}

