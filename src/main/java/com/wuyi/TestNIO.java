package com.wuyi;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class TestNIO {

    public static void readFileWithNIO(String fileName){
        try (FileInputStream file = new FileInputStream(fileName);
             // 获取通道
             FileChannel channel = file.getChannel();
        ){
            // 创建缓冲区
            ByteBuffer byteBbuffer = ByteBuffer.allocate(1024);

            //读取数据到缓冲区
            channel.read(byteBbuffer);

            // 重设buffer，将limit设置为position，position设置为0
            byteBbuffer.flip();

            Charset utf8 = Charset.forName("UTF-8");
            CharsetDecoder decoder = utf8.newDecoder();
            CharBuffer charBuffer = decoder.decode(byteBbuffer);

            while(byteBbuffer.hasRemaining()){
                System.out.print((char)byteBbuffer.get());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String src, String dest) throws IOException {
        FileInputStream in = new FileInputStream(src);
        // 获取输入流的文件通道
        FileChannel cin  = in.getChannel();
        FileOutputStream out = new FileOutputStream(dest);
        //获取输出流的文件通道
        FileChannel cout = out.getChannel();
        // 获取缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(true){
            // 从输入通道中把文件内容写入缓冲区
            int r = cin.read(buffer);

            if (r == -1)
                break;

            // 切换读写
            buffer.flip();

            //把缓冲区的内容写入输出文件
            cout.write(buffer);

            //清空缓冲区
            buffer.clear();

        }
    }

    public static void main(String[] args) throws IOException {
        readFileWithNIO("src.txt");
        //copyFile("src.txt","dest.txt");
    }
}
