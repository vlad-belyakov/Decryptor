package Vlad.com;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileWork {
    private final File file;

    public FileWork(String path) {
        this.file = new File(path);
    }

    public String Read() throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.close();

        return new String(data, StandardCharsets.UTF_8);
    }

    public void Write(String content) throws IOException {
        FileOutputStream fis = new FileOutputStream(file);
        fis.write(content.getBytes());
        fis.close();
    }
}
