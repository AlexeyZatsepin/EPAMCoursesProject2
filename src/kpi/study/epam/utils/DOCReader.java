package kpi.study.epam.utils;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * EPAM_Project2_doc_reader
 * Created 6/24/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class DOCReader implements FileReader {
    @Override
    public String read(File file) throws IOException {
        String result ="";
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
        HWPFDocument doc = new HWPFDocument(fis);
        WordExtractor we = new WordExtractor(doc);
        String[] paragraphs = we.getParagraphText();
        for (String para : paragraphs) {
            result+=" "+para;
        }
        fis.close();
        return result;
    }
}
