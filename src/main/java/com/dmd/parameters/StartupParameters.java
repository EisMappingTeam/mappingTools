package com.dmd.parameters;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "dmdHelper")
public class StartupParameters {
    public StartupParameters() {
    }

    @JacksonXmlElementWrapper(localName = "actions", useWrapping = false)
    private StartupAction[] actions;

    public StartupAction[] getActions() {
        return actions;
    }

    public void setActions(StartupAction[] actions) {
        this.actions = actions;
    }
}
