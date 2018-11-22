package com.dmd.services.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.max;

//https://tproger.ru/translations/how-to-read-write-excel-file-java-poi-example/

@Service
public class ExcelTableWorksheet {
    private Workbook book;
    private Sheet sheet;
    private int headerRowsCount;
    private Map<String, Integer> tableHeader;


    public void initializeNew(String worksheetName, int tableHeaderRowCount) {
        book = new HSSFWorkbook();
        sheet = book.createSheet(worksheetName);
        headerRowsCount = tableHeaderRowCount;
        tableHeader = new HashMap<String, Integer>();

        for (int i = 0; i < headerRowsCount; i++) {
            sheet.createRow(i);
        }
    }

    public int addUniqueToHeader(String columnHeader) {
        if (tableHeader.containsKey(columnHeader)) {
            return tableHeader.get(columnHeader);
        }
        tableHeader.put(columnHeader, tableHeader.size());
        adjustRowAccordingHeader(headerRowsCount - 1);
        sheet.getRow(headerRowsCount - 1).getCell(tableHeader.get(columnHeader)).setCellValue(columnHeader);
        return tableHeader.get(columnHeader);
    }


    public int getRowsCount() {
        return sheet.getLastRowNum();
    }


    public int addRow() {
        sheet.createRow(sheet.getLastRowNum() + 1);
        return sheet.getLastRowNum();
    }


    public void putValue(String columnHeader, int rowNum, String value) {
        int colNum = addUniqueToHeader(columnHeader);
        adjustRowAccordingHeader(rowNum);
        sheet.getRow(rowNum).getCell(colNum).setCellValue(value);
    }

    public void save(String filePath) throws IOException {
        book.write(new FileOutputStream(filePath));
    }

    private void adjustRowAccordingHeader(int rowNum) {
        for (int i = max(sheet.getRow(rowNum).getLastCellNum(), 0); i <= tableHeader.size() - 1; i++) {
            sheet.getRow(rowNum).createCell(i);
        }

    }

}
