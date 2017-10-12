package com.xhlim.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-26 15:28
 */
public class FileExport {


    public static void main(String[] args) throws IOException {
        String s = "dsfjks" + "\n";
        System.out.print(s);
        StringBuffer sb = new StringBuffer("sdfkjds");

        sb.append("\r\n");
        sb.append("2323");
        sb.append("\r\n");
        sb.append("fjkdsl");
        sb.append("\r\n");
        //\n和\r\n都一样，在在控制台输出正常换行
        System.out.print(sb.toString());


        File f = new File("/Users/xhlim/" + "testStringNextLine.txt");
        f.createNewFile();

        File f2 = new File("/Users/xhlim/" + "testStringNextLine2.txt");
        f2.createNewFile();
        try {
            //无论这里加几个\n，PrintStream输出到文件的换行符都被过滤掉
            PrintStream ps = new PrintStream("/Users/xhlim/" + "testStringNextLine.txt");
            ps.print(sb.toString());
            ps.print("\r\n");
            ps.print("234");
            ps.print("\r\n");
            ps.close();

            FileWriter fw = new FileWriter(f2);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(sb.toString());
            bw.write("\r\n");
            bw.write("\r\n");

            String s2 = "djfkljw\r\n2323\r\n";
            System.out.print(s2);
            bw.write(s2);

            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
