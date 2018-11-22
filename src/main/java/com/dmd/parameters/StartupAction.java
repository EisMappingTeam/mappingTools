package com.dmd.parameters;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class StartupAction {
    @JacksonXmlProperty(localName = "actionName")
    private String actionName;

    @JacksonXmlProperty(localName = "parameter01")
    private String parameter01;

    @JacksonXmlProperty(localName = "parameter02")
    private String parameter02;

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getParameter01() {
        return parameter01;
    }

    public void setParameter01(String parameter01) {
        this.parameter01 = parameter01;
    }

    public String getParameter02() {
        return parameter02;
    }

    public void setParameter02(String parameter02) {
        this.parameter02 = parameter02;
    }
}
