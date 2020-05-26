package bg.tu_varna.sit.vegetables_webapp;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XMLWOrker {

	private static String filename = "F:\\DevRepository\\eclipse-workspace\\Vegetables-webapp\\src\\main\\webapp\\source\\vegetables.xml";
	
	public static void writer(Vegetables vegetables) {
		
		try {
			JAXBContext context = JAXBContext.newInstance(Vegetables.class);
			
			Marshaller marshaller = context.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			marshaller.marshal(vegetables, new File(filename));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
