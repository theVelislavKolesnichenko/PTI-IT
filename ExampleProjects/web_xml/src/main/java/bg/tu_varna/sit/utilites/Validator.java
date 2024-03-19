package bg.tu_varna.sit.utilites;

import java.io.File;

public class Validator {
    public File getFile(String location) {
        return new File(getClass().getClassLoader().getResource(location).getFile());
    }
}
