package com.dmd.tools.parameters;

import com.dmd.parameters.StartupAction;
import com.dmd.parameters.StartupParameters;
import com.dmd.tools.modelReport.ModelReportHandler;

import java.io.IOException;


public final class ActionRunner {
    private static final String RUN_MODEL_REPORT_HANDLER = "readModelReport";

    public static void runActions(StartupParameters parameters) throws IOException {
        StartupAction[] actions = parameters.getActions();
        for (int i = 0; i < actions.length; i++) {
            if (RUN_MODEL_REPORT_HANDLER.equalsIgnoreCase(actions[i].getActionName())) {
                ModelReportHandler.createModelReportInExcel(actions[i].getParameter01(), actions[i].getParameter02());
                break;
            }
        }

    }
}