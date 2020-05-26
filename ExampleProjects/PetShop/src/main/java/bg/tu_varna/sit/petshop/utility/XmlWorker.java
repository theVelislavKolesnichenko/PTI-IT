package bg.tu_varna.sit.petshop.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import bg.tu_varna.sit.petshop.models.Pets;

public class XmlWorker {
	private String filename = "F:\\DevRepository\\eclipse-workspace\\PetShop\\src\\main\\webapp\\source\\pets.xml";

	public Pets readerFromXmlFile() throws JAXBException, FileNotFoundException {
		
		JAXBContext context = JAXBContext.newInstance(Pets.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		FileReader reader = new FileReader(filename);
		
		Pets pets = (Pets) unmarshaller.unmarshal(reader);
		
		return pets;
	}
}
