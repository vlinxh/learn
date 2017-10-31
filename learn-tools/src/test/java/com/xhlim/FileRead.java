package com.xhlim;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-04 18:10
 */
public class FileRead {


    @Test
    public void read() throws IOException {
        FileReader file = new FileReader("src/main/resources/1.txt");
        BufferedReader reader = new BufferedReader(file);
        String line = "";
        Set<String> list = new HashSet<>();
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Client")) {
                line = line.replace("Client:/", "");
            }
            line = line.split(":")[0];
            if (!line.matches("^\\d+?.*$")) {
                continue;
            }
            String[] split = line.split("\\.");
            list.add(line);
        }
        System.out.println(list.size());
        for (String l : list) {
            System.out.println(l);
        }

        reader.close();
        file.close();
    }

}

