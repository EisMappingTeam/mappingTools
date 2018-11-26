package com.dmd.tools.parameters;

import com.dmd.entity.parameters.StartupAction;
import com.dmd.entity.parameters.StartupParameters;
import com.dmd.tools.modelReport.ModelReportHandler;

import java.io.IOException;


public final class ActionRunner {
    private static final String RUN_MODEL_REPORT_HANDLER = "readModelReport";
    private static final String RUN_LOOKUP_VALUES_PROCESSING = "lookupValuesProcessing";


    public static void runActions(StartupParameters parameters) throws IOException {
        StartupAction[] actions = parameters.getActions();

        //Model Report processing
        for (int i = 0; i < actions.length; i++) {
            if (RUN_MODEL_REPORT_HANDLER.equalsIgnoreCase(actions[i].getActionName())) {
                ModelReportHandler.createModelReportInExcelAttributes(actions[i].getParameter01(), actions[i].getParameter02());
                break;
            }
        }

        //Lookup fetching
        for (int i = 0; i < actions.length; i++) {
            if (RUN_LOOKUP_VALUES_PROCESSING.equalsIgnoreCase(actions[i].getActionName())) {
                ModelReportHandler.createModelReportInExcelLookup(actions[i].getParameter01(), actions[i].getParameter02()) ;
                break;
            }
        }
    }
}
