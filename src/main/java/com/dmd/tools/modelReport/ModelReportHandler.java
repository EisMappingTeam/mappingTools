package com.dmd.tools.modelReport;


import com.dmd.services.excel.ExcelTableWorksheet;
import com.dmd.tools.files.FileHandler;
import com.dmd.tools.json.JsonHandler;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class ModelReportHandler {

    public static List<Map<String, Object>> getNodesList(String fileName) throws IOException {
        List<Map<String, Object>> nodes;
        String jsonText = FileHandler.readFile(fileName);

        nodes = JsonHandler.parseModelReportJson(jsonText);
        return nodes;
    }


    public static void createModelReportInExcel(String modelJson, String outputExcelFile) throws IOException {
        List<Map<String, Object>> nodes = ModelReportHandler.getNodesList(modelJson);
        populateExcel(nodes, outputExcelFile);

    }

    private static void populateExcel(List<Map<String, Object>> nodes, String excelFile) throws IOException {
        ExcelTableWorksheet wBook = new ExcelTableWorksheet();

        wBook.initializeNew("ModelReport", 1);

        nodes.forEach((itemMap) -> {
            int row;
            row = wBook.addRow();
            for (String key : itemMap.keySet()) {
                wBook.putValue(key, row, String.valueOf(itemMap.get(key)));
            }
        });

        wBook.save(excelFile);
    }

}





