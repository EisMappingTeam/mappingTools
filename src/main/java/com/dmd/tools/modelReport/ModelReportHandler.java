package com.dmd.tools.modelReport;


import com.dmd.services.excel.ExcelTableWorksheet;
import com.dmd.tools.files.FileHandler;
import com.dmd.tools.json.JsonHandler;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public final class ModelReportHandler {

    public static List<Map<String, Object>> getNodesList(String fileName, String rootNode) throws IOException {
        List<Map<String, Object>> nodes;
        String jsonText = FileHandler.readFile(fileName);

        nodes = JsonHandler.parseModelReportJson(jsonText, rootNode);
        return nodes;
    }


    public static void createModelReportInExcelAttributes(String modelJson, String outputExcelFile) throws IOException {
        List<Map<String, Object>> nodes = ModelReportHandler.getNodesList(modelJson, ModelReportRootNodeName.MODEL_ENTITY_ATTRIBUTES.nodeName());
        populateExcelAttributesReport(nodes, outputExcelFile);

    }

    private static void populateExcelAttributesReport(List<Map<String, Object>> nodes, String excelFile) throws IOException {
        ExcelTableWorksheet wBook = new ExcelTableWorksheet();

        wBook.initializeNew("ModelReportAttributes", 1);

        nodes.forEach((itemMap) -> {
            int row;
            row = wBook.addRow();
            for (String key : itemMap.keySet()) {
                wBook.putValue(key, row, String.valueOf(itemMap.get(key)));
            }
        });

        wBook.save(excelFile);
    }

    public static void createModelReportInExcelLookup(String modelJson, String outputExcelFile) throws IOException {
        List<Map<String, Object>> nodes = ModelReportHandler.getNodesList(modelJson, ModelReportRootNodeName.LOOKUP.nodeName());
        populateExcelLookupReport(nodes, outputExcelFile);

    }

    private static void populateExcelLookupReport(List<Map<String, Object>> nodes, String excelFile) throws IOException {
        ExcelTableWorksheet wBook = new ExcelTableWorksheet();

        wBook.initializeNew("ModelReportLookup", 1);

        nodes.forEach((itemMap) -> {
            AtomicInteger row = new AtomicInteger();

            for (String key : itemMap.keySet()) {
                String lookupName = (String) itemMap.get(ModelReportLookupNodeName.LOOKUP_NAME.nodeName() );

                //lookupValues
                if (itemMap.get(key) instanceof List) {
                    ArrayList array = (ArrayList) itemMap.get(key);
                    array.forEach((arrayItem) -> {
                        row.set(wBook.addRow());
                        wBook.putValue(ModelReportLookupNodeName.LOOKUP_NAME.nodeName(), row.get(),  lookupName);
                        appendExcelLookupRow (wBook,row.get(),"",arrayItem);
                    });

                }

            }
        });

        wBook.save(excelFile);
    }


    private static void appendExcelLookupRow(ExcelTableWorksheet wBook, int row, String key, Object item) {
        if (item instanceof String) {
            wBook.putValue(key, row, String.valueOf(item));

        } else if (item instanceof List) {
            ArrayList array = (ArrayList) item;
            array.forEach((arrayItem) -> {
                appendExcelLookupRow(wBook, row, key, arrayItem);
            });

        } else if (item instanceof Map) {
            HashMap<String, Object> mp = (HashMap<String, Object>) item;
            for (String mapKey : mp.keySet()) {
                appendExcelLookupRow(wBook, row, mapKey, mp.get(mapKey));
            }

        }

    }

}





