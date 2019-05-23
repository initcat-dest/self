package com.base.self.io;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * excel
 *
 * @author libo
 * @package com.base.self.io
 * @company initcat
 * @date 2019/2/22
 */
public class WriteExcelFileUtil {

    private static final String EXCEL_TYPE_XLS = "xls";
    private static final String EXCEL_TYPE_XLSX = "xlsx";

    public static void main(String[] args) throws Exception {
        String[] title = {"被保险人姓名", "身份证号", "账户类型", "银行卡号", "保险金额(元)", "购买时间", "保单生效时间", "保单失效时间"};
        List<InsuraceExcelBean> list = IntStream.range(0, 6).mapToObj(i -> InsuraceExcelBean.builder().insuraceUser("test" + i).money("20,000").type("储蓄卡")
                .bankCardId("4444444444" + i + "," + "55544444444444" + i + "," + "999999999999999" + i).idCard("" + i)
                .buyTime("2016-05-06").insStartTime("2017-05-06").insEndTime("2016-05-07").build()).collect(Collectors.toList());
        writeExcel("/Users/libo/Desktop/", "writerExcelTest", EXCEL_TYPE_XLSX, list, title);
    }

    /**
     * java写入excel文件poi，支持xlsx与xls，没有文件自动创建
     *
     * @param path     文件路径
     * @param fileName 文件名称
     * @param fileType Excel类型
     * @param list     数据
     * @param titleRow 表头
     */
    public static void writeExcel(String path, String fileName, String fileType, List<InsuraceExcelBean> list, String titleRow[]) throws Exception {
        Workbook wb;
        String excelPath = path + File.separator + fileName + "." + fileType;
        File file = new File(excelPath);
        Sheet sheet = null;
        // 创建工作文档对象
        if (!file.exists()) {
            wb = getWorkbook(fileType);
            //创建sheet对象
            sheet = wb.createSheet("sheet1");
            OutputStream outputStream = new FileOutputStream(excelPath);
            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();

        } else {
            wb = getWorkbook(fileType);
        }
        // 创建sheet对象
        if (sheet == null) {
            sheet = wb.createSheet("sheet1");
        }

        // 添加表头
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        row.setHeight((short) 540);
        // 创建第一行
        cell.setCellValue("被保险人员清单");
        // 样式对象
        CellStyle style = wb.createCellStyle();
        // 设置单元格的背景颜色为淡蓝色
        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        // 垂直
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        // 水平
        style.setAlignment(CellStyle.ALIGN_CENTER);
        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);
        // 样式，居中
        cell.setCellStyle(style);

        Font font = wb.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        font.setFontName("宋体");
        font.setFontHeight((short) 280);
        style.setFont(font);
        // 单元格合并
        // 四个参数分别是：起始行，起始列，结束行，结束列
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
        sheet.autoSizeColumn(5200);
        // 创建第二行
        row = sheet.createRow(1);
        for (int i = 0; i < titleRow.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(titleRow[i]);
            // 样式，居中
            cell.setCellStyle(style);
            sheet.setColumnWidth(i, 20 * 256);
        }
        row.setHeight((short) 540);

        // 循环写入行数据
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 2);
            row.setHeight((short) 500);
            row.createCell(0).setCellValue((list.get(i)).getInsuraceUser());
            row.createCell(1).setCellValue((list.get(i)).getIdCard());
            row.createCell(2).setCellValue((list.get(i)).getType());
            row.createCell(3).setCellValue((list.get(i)).getBankCardId());
            row.createCell(4).setCellValue((list.get(i)).getMoney());
            row.createCell(5).setCellValue((list.get(i)).getBuyTime());
            row.createCell(6).setCellValue((list.get(i)).getInsStartTime());
            row.createCell(7).setCellValue((list.get(i)).getInsEndTime());
        }

        // 创建文件流
        OutputStream stream = new FileOutputStream(excelPath);
        // 写入数据
        wb.write(stream);
        // 关闭文件流
        stream.close();
    }

    private static Workbook getWorkbook(String fileType) throws Exception {
        Workbook wb;
        switch (fileType) {
            case EXCEL_TYPE_XLS:
                wb = new HSSFWorkbook();
                break;
            case EXCEL_TYPE_XLSX:
                wb = new XSSFWorkbook();
                break;
            default:
                throw new Exception("文件格式不正确");
        }
        return wb;
    }

}
