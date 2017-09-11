package com.xhlim.tools;

import java.io.*;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xhlim@outlook.com
 * @create 2017-08-30 18:52
 */
public class FileImportTORedis {

    ExecutorService pool = Executors.newFixedThreadPool(10);
    RedisClient client = new RedisClient();

    // 读取文件

    InputStream readFile(String filePath, String encoding) {
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    String[] split = lineTxt.split(",");
                    final String phone = split[0];
                    final String value = split[2];
                    pool.execute(new Runnable() {
                        @Override
                        public void run() {
                            client.install(phone,value);
                        }
                    });

                    // System.out.println(lineTxt);
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

        return null;
    }


    public URL getResource() {
        return this.getClass().getClassLoader().getResource("");
    }

    public static void main(String[] args) {
        FileImportTORedis fileImportTORedis = new FileImportTORedis();
        URL resource = fileImportTORedis.getResource();
        System.out.println(resource.getPath());
        fileImportTORedis.readFile(resource.getPath() + "/HCode.txt", "UTF-8");

        // RedisClient redisClient = new RedisClient();
        // redisClient.install("1","2");
    }


}
