package sit.tu_varna.bg.helpers;

import java.io.PrintWriter;

public class WriterWorker {
    public static void write(PrintWriter writer, String json) {
        writer.println(json);
        writer.flush();
    }
}
