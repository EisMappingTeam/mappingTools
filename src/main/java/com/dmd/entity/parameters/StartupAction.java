package com.dmd.entity.parameters;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class StartupAction {
    @JacksonXmlProperty(localName = "actionName")
    private String actionName;

    @JacksonXmlProperty(localName = "parameter01")
    private String parameter01;
    @JacksonXmlProperty(localName = "parameter02")
    private String parameter02;
    @JacksonXmlProperty(localName = "parameter03")
    private String parameter03;
    @JacksonXmlProperty(localName = "parameter04")
    private String parameter04;
    @JacksonXmlProperty(localName = "parameter05")
    private String parameter05;


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

    public String getParameter03() {
        return parameter03;
    }

    public void setParameter03(String parameter03) {
        this.parameter03 = parameter03;
    }

    public String getParameter04() {
        return parameter04;
    }

    public void setParameter04(String parameter04) {
        this.parameter04 = parameter04;
    }

    public String getParameter05() {
        return parameter05;
    }

    public void setParameter05(String parameter05) {
        this.parameter05 = parameter05;
    }
}
