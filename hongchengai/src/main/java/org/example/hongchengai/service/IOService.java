package org.example.hongchengai.service;

import java.io.*;

public class IOService implements IIOService{

    /**
     * 将用户的问题存放到指定目录
     * @param path  存放目录
     * @param content   存放内容
     */
    @Override
    public void writeFile(String path, String content) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(path));
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 从指定目录读取回答
     * @param path  目录路径
     * @return  ai回答
     */
    @Override
    public String readFile(String path) {
        BufferedReader reader = null;
        StringBuffer content  = new StringBuffer();
        try {

            String line = null;
            reader = new BufferedReader(new FileReader(path));
            while((line = reader.readLine())!=null){
                content.append(line);
                content.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return String.format("%-" + 30 +"s",content.toString()) ;
    }


}
