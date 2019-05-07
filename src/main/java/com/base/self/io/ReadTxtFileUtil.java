package com.base.self.io;

import java.io.*;

/**
 * 读取TXT文件
 *
 * @author libo
 * @package com.base.self.io
 * @company initcat
 * @date 2019/2/22
 */
public class ReadTxtFileUtil {

    public static void main(String[] args) {
        String fileContent = ReadTxtFileUtil.readFile("/Users/libo/Desktop/aa.txt");
        System.out.println(fileContent);
    }

    /**
     * 读取文件
     * Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
     *
     * @param filePath 文件地址
     * @return 文件内容
     */
    public static String readFile(String filePath) {
        StringBuilder fileContent = new StringBuilder();
        try (FileReader reader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // 一次读入一行数据
                fileContent.append(line);
            }
        } catch (IOException e) {
            System.out.println("读取文件内容操作出错");
            e.printStackTrace();
        }
        return fileContent.toString();
    }

    /**
     * 读取文件
     * 传统方式
     *
     * @param filePath 文件路径
     * @return 文件内容
     */
    @Deprecated
    public static String readFileOld(String filePath) {
        BufferedReader reader = null;
        InputStreamReader read = null;
        StringBuilder fileContent = new StringBuilder();
        try {
            File f = new File(filePath);
            if (f.isFile() && f.exists()) {
                read = new InputStreamReader(new FileInputStream(f));
                reader = new BufferedReader(read);
                String line;
                while ((line = reader.readLine()) != null) {
                    fileContent.append(line);
                }
            } else {
                System.out.println("文件不正确");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容操作出错");
            e.printStackTrace();
        } finally {
            closeIO(reader, read);
        }
        return fileContent.toString();
    }

    private static void closeIO(BufferedReader reader, InputStreamReader read) {
        try {
            if (read != null) {
                read.close();
            }
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            System.out.println("关闭流错误");
            e.printStackTrace();
        }
    }

}
