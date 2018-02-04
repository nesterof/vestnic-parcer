package controller;

import com.mapforce.MappingMapTodoajArticles;

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

          	try {           		// Mapping

			MappingMapTodoajArticles mappingMapTodoajArticles = new MappingMapTodoajArticles();


			// run mapping
			//
			// you have different options to provide mapping input and output:
			//
			// files using file names (available for XML, text, and Excel):
			//   com.altova.io.FileInput(String filename)
			//   com.altova.io.FileOutput(String filename)
			//
			// streams (available for XML, text, and Excel):
			//   com.altova.io.StreamInput(java.io.InputStream stream)
			//   com.altova.io.StreamOutput(java.io.OutputStream stream)
			//
			// strings (available for XML and text):
			//   com.altova.io.StringInput(String xmlcontent)
			//   com.altova.io.StringOutput()	(call getContent() after run() to get StringBuffer with content)
			//
			// Java IO reader/writer (available for XML and text):
			//   com.altova.io.ReaderInput(java.io.Reader reader)
			//   com.altova.io.WriterOutput(java.io.Writer writer)
			//
			// DOM documents (for XML only):
			//   com.altova.io.DocumentInput(org.w3c.dom.Document document)
			//   com.altova.io.DocumentOutput(org.w3c.dom.Document document)
			//
			// By default, run will close all inputs and outputs. If you do not want this,
			// call the following function:
			// MappingMapTodoajArticlesObject.setCloseObjectsAfterRun(false);

			{
				com.altova.io.Input Name25420429_2017_17_3_unicode2Source = com.altova.io.StreamInput.createInput(inputFilePath);
				com.altova.io.Output doajArticles2Target = new com.altova.io.FileOutput(outputFilePath);

				mappingMapTodoajArticles.run(
						Name25420429_2017_17_3_unicode2Source,
						doajArticles2Target);
			}

			System.out.println("Finished");
		}
		catch (com.altova.UserException ue)
		{
			StringBuilder errorMessage = new StringBuilder();
			errorMessage.append("USER EXCEPTION:");
			errorMessage.append(System.lineSeparator());
			errorMessage.append( ue.getMessage() );
			throw new Exception(errorMessage.toString());
		}
		catch (com.altova.AltovaException e)
		{
			StringBuilder errorMessage = new StringBuilder();
			errorMessage.append("ERROR: ");
			errorMessage.append(System.lineSeparator());
			errorMessage.append( e.getMessage() );
			if (e.getInnerException() != null)
			{
				errorMessage.append("Inner exception: ");
				errorMessage.append(System.lineSeparator());
				errorMessage.append(e.getInnerException().getMessage());
				if (e.getInnerException().getCause() != null)
				{
					errorMessage.append("Cause: ");
					errorMessage.append(System.lineSeparator());
					errorMessage.append(e.getInnerException().getCause().getMessage());
				}
			}
			throw new Exception(errorMessage.toString());
		}
	}

}
