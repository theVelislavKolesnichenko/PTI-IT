package sit.tu_varna.bg.helpers;

import java.io.BufferedReader;
import java.io.IOException;

public class ReaderWorker {
    public static String read(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = reader.readLine()) != null) {
            sb.append(s);
        }
        return sb.toString();
    }
}
