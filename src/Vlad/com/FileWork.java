package Vlad.com;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileWork {
    private java.io.File file;

    public FileWork(String path) {
        this.file = new java.io.File(path);
    }

    public String Read() throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();

        var content = new String(data, StandardCharsets.UTF_8);

        return content;
    }

    public void Write(String content) throws IOException {
        FileOutputStream fis = new FileOutputStream(file);
        fis.write(content.getBytes());
        fis.close();
    }
}
