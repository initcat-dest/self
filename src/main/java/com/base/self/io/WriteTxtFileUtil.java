package com.base.self.io;

import java.io.*;

/**
 * class description
 *
 * @author libo
 * @package com.base.self.io
 * @company xmiles
 * @date 2019/2/22
 */
public class WriteTxtFileUtil {

    public static void main(String[] args) {
        WriteTxtFileUtil.writeFileWithCover("/Users/libo/Desktop/aa.txt", "test");
        WriteTxtFileUtil.writeFileWithAppend("/Users/libo/Desktop/aa.txt", "testCreate\r\n");
    }

    /**
     * 覆盖写入TXT文件
     *
     * @param filePath     文件路径
     * @param writeContent 写入内容（ 换行符：\r\n ）
     */
    public static void writeFileWithCover(String filePath, String writeContent) {
        try {
            File file = new File(filePath);
            // 创建新文件,有同名的文件的话直接覆盖
            file.createNewFile();
            try (FileWriter writer = new FileWriter(file);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                out.write(writeContent);
                // 把缓存区内容压入文件
                out.flush();
            }
        } catch (IOException e) {
            System.out.println("写入文件内容操作出错");
            e.printStackTrace();
        }
    }

    /**
     * 追加写入TXT文件
     *
     * @param filePath      文件路径
     * @param appendContent 追加内容
     */
    public static boolean writeFileWithAppend(String filePath, String appendContent) {
        File file = new File(filePath);
        try {
            // 文件不存在就创建
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            System.out.println("文件不存在，新建文件出错");
            e.printStackTrace();
            return false;
        }
        try (FileOutputStream outputStream = new FileOutputStream(file, true)) {
            byte[] buff = appendContent.getBytes();
            outputStream.write(buff);
            outputStream.flush();
        } catch (Exception e) {
            System.out.println("写入文件内容操作出错");
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
