package com.dmd.entity.parameters;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class StartupAction {
    @JacksonXmlProperty(localName = "actionName")
    private String actionName;

    @JacksonXmlProperty(localName = "inputFile")
    private String inputFile;
    @JacksonXmlProperty(localName = "outputFile")
    private String outputFile;


    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }
}
