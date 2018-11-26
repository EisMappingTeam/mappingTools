package com.dmd.tools.modelReport;

public enum ModelReportLookupNodeName {
    LOOKUP_NAME("lookupName"),
    LOOKUP_VALUES("lookupValues"),
    CODE("code"),
    DISPLAY_VALUE("displayValue"),
    FILTERS("filters");

    private String nodeName;

    ModelReportLookupNodeName(String _nodeName) {
        this.nodeName = _nodeName;
    }

    public String nodeName() {
        return this.nodeName;
    }
}