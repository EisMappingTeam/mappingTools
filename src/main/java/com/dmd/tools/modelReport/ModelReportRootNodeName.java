package com.dmd.tools.modelReport;

public enum ModelReportRootNodeName {
    LOOKUP("lookup"),
    MODEL_ENTITY_ATTRIBUTES("modelEntityAttributes");

    private String nodeName;

    ModelReportRootNodeName(String _nodeName) {
        this.nodeName = _nodeName;
    }

    public String nodeName() {
        return this.nodeName;
    }
}