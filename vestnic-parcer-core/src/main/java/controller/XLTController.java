package controller;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

import com.mapforce.DoajMappingConsole;

public class XLTController {

    private static XLTController instance;

    private XLTController(){

    }

    public static XLTController getInstance(){
        if(instance == null) {
            instance = new XLTController();
        }
        return instance;
    }

    public void parceXLT(String inputFilePath, String outputFilePath, String xltTemplate) throws Exception {

            DoajMappingConsole.parceXLT(inputFilePath, outputFilePath);
        }


}
