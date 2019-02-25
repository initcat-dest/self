package com.base.self.io;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取Excel文件
 * apache.poi
 *
 * @author libo
 * @package com.base.self.io
 * @company xmiles
 * @date 2019/2/22
 */
public class ReadExcelFileUtil {

    public static final String EXCEL_TYPE_XLS = "xls";
    public static final String EXCEL_TYPE_XLSX = "xlsx";

    public static void main(String[] args) {
        String path = "d:/software/企发支付-员工信息表.xlsx";
        List<List<String>> lists = readExcel(path);
        for (List<String> list : lists) {
            for (String strs : list) {
                System.out.println(strs);
            }
        }
    }

    /**
     * 根据fileType不同读取excel文件
     *
     * @param path 路径
     */
    public static List<List<String>> readExcel(String path) {
        String fileType = path.substring(path.lastIndexOf(".") + 1);
        // return a list contains many list
        List<List<String>> lists = new ArrayList<>();
        // 读取excel文件
        InputStream is = null;
        try {
            is = new FileInputStream(path);
            // 获取工作薄
            Workbook wb;
            if (EXCEL_TYPE_XLS.equals(fileType)) {
                wb = new HSSFWorkbook(is);
            } else if (EXCEL_TYPE_XLSX.equals(fileType)) {
                wb = new XSSFWorkbook(is);
            } else {
                System.out.println("--------文件类型辨识失败--------");
                return null;
            }

            // 读取第一个工作页sheet
            Sheet sheet = wb.getSheetAt(0);
            // 第一行为标题
            for (Row row : sheet) {
                ArrayList<String> list = new ArrayList<>();
                for (Cell cell : row) {
                    // 根据不同类型转化成字符串
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    list.add(cell.getStringCellValue());
                }
                lists.add(list);
            }
        } catch (Exception e) {
            System.out.println("--------readException--------");
            e.printStackTrace();
        } finally {
            closeIO(is);
        }
        return lists;
    }

    private static void closeIO(InputStream is) {
        try {
            if (is != null) {
                is.close();
            }
        } catch (IOException e) {
            System.out.println("关闭流错误");
            e.printStackTrace();
        }
    }


}
