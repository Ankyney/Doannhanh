package com.backend.utils;

import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static Workbook createExcelFile(String[] headerCells, String[] valueCells) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("NhanVien");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 3000);
        sheet.setColumnWidth(3, 4000);

        DataFormat fmt = workbook.createDataFormat();
        CellStyle textStyle = workbook.createCellStyle();
        textStyle.setDataFormat(fmt.getFormat("@"));

        CellStyle numericStyle = workbook.createCellStyle();
        numericStyle.setDataFormat(fmt.getFormat(BuiltinFormats.getBuiltinFormat(1)));

        sheet.setDefaultColumnStyle(0, textStyle);
        sheet.setDefaultColumnStyle(1, textStyle);
        sheet.setDefaultColumnStyle(2, textStyle);
        sheet.setDefaultColumnStyle(3, textStyle);

        Row header = sheet.createRow(0);
        header.setHeightInPoints(20);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 10);
        font.setBold(true);
        headerStyle.setFont(font);
        Cell headerCell;
        if (headerCells != null) {
            for (int i = 0; i < headerCells.length; i++) {
                headerCell = header.createCell(i);
                headerCell.setCellValue(headerCells[i]);
                headerCell.setCellStyle(headerStyle);
            }
        }
        if (valueCells != null) {
            Row row = sheet.createRow(1);
            for (int i = 0; i < valueCells.length; i++) {
                headerCell = row.createCell(i);
                headerCell.setCellValue(valueCells[i]);
            }
        }
        return workbook;
    }
}
