package bg.tu_varna.sit.web_app.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import bg.tu_varna.sit.web_app.modes.Fruits;

public class XmlWorker {
	
	private String filename = "F:\\DevRepository\\eclipse-workspace\\web-app\\src\\main\\webapp\\source\\fruits.xml";
	
	public Fruits readerFromXmlFile() throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(Fruits.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		FileReader reader = new FileReader(filename);
		Fruits fruits = (Fruits) unmarshaller.unmarshal(reader);
		
		return fruits;
	}
}
