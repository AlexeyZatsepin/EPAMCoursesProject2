package kpi.study.epam.utils;

import java.io.File;
import java.io.IOException;

/**
 * EPAM_Project2_doc_reader
 * Created 6/24/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class TXTReader implements FileReader {
    @Override
    public String read(File file) throws IOException {
        String text = "";
        java.io.FileReader input = new java.io.FileReader(file);
        int data = input.read();
        while(data != -1) {
            text += (char) data;
            data = input.read();
        }
        input.close();
        return text;
    }
}
