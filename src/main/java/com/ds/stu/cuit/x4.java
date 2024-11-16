package com.ds.stu.cuit;

import java.io.*;

public class x4 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\HP\\OneDrive\\Desktop\\MyantTemp\\tmp.txt"; // 文件路径
        StringBuilder content = new StringBuilder();

        // 读取文件内容
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 在这里可以对每一行进行修改
                content.append(line.replace(". ", ". \n"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 写回文件
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}