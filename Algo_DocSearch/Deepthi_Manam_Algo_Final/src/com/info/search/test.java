package com.info.search;

import java.io.File;

public class test {

    public static void main(String[] args) {
        File folder = new File("C:\\Users\\Deepthi\\Documents\\Algorithms\\AlgoProject");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName() + file.getTotalSpace()/(1.0));
            }
        }
    }
}
