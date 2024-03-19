package bg.tu_varna.sit.utilites;

import bg.tu_varna.sit.domain.Task;
import bg.tu_varna.sit.models.ResponseMessage;
import jakarta.xml.bind.JAXBException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;

public class HttpWorker {
    public static String readBody(BufferedReader bufferedReader) throws IOException {
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }

    public static <T> void writeBody(Writer writer, T message) throws JAXBException {
        new XmlWorker<T>().writeXML(message, writer);
    }
}
