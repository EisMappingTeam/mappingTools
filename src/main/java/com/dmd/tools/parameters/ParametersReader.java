package com.dmd.tools.parameters;

import com.dmd.parameters.StartupParameters;
import com.dmd.tools.files.FileHandler;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.xml.bind.JAXBException;
import java.io.IOException;


public final class ParametersReader {
    public static StartupParameters read(String filePath) throws IOException, JAXBException {

        String xmlData = FileHandler.readFile(filePath);
        XmlMapper xmlMapper = new XmlMapper();
        StartupParameters parameters = xmlMapper.readValue(xmlData, StartupParameters.class);
        return parameters;
    }
}
