package com.wuyi.notecode;

import java.io.*;

public class TestJavaIO {
    public static void AllFiles(String dir) {
        File file = new File(dir);
        if (file == null || !file.exists())
            return;

        if (file.isFile()) {
            System.out.println(file.getName());
            return;
        }

        for (File f : file.listFiles()) {
            AllFiles(dir + "\\" + f.getName());
        }
    }

    public static void copyFile(String src, String dest) {
        try (FileInputStream in = new FileInputStream(src);
             FileOutputStream out = new FileOutputStream(dest)
        ) {
            byte[] buffer = new byte[20 * 1024];
            int data;
            while ((data = in.read(buffer, 0, buffer.length)) != -1) {
                out.write(buffer, 0, data);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(String fileName){
        try ( BufferedReader bf = new BufferedReader(
                new FileReader(fileName))){
            String line;
            while((line = bf.readLine()) != null){
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //AllFiles("./");
        //copyFile("src.txt","dest.txt");
        readFile(".idea/vcs.xml");
    }
}
