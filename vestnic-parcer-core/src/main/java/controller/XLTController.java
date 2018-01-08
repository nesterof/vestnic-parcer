package controller;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

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

        TransformationType transformationType = TransformationType.valueOf(xltTemplate.toUpperCase());

        StreamSource stylesource = new StreamSource( getClass().getResourceAsStream(transformationType.getFilePath()));

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(stylesource);

        File inputFile = openFile(inputFilePath);
        File outputFile = openFile(outputFilePath);
        try {
             inputFile = new File(inputFilePath);
             outputFile = new File(outputFilePath);
             outputFile.createNewFile();

        } catch (IOException e) {
            throw new Exception("Невозможно создать файл или перезаписать файл "
                    + outputFilePath
                    + "\n Причина:" + e.getMessage());
        }

        StreamResult outputResult = new StreamResult(outputFile);
        StreamSource inputSource = new StreamSource(inputFile);

        transformer.transform(inputSource, outputResult);
    }


    private File openFile(String filePath) throws Exception {
        File file = new File(filePath);
        if(file == null) {
            throw new Exception("Невозможно открытть файл " + filePath);
        }
        return file;
    }
}
