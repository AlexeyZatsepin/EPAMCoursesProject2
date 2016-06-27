package kpi.study.epam.utils;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * EPAM_Project2_doc_reader
 * Created 6/24/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class DOCXReader implements FileReader {
    @Override
    public String read(File file) throws IOException {
        String result = "";
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
        XWPFDocument document = new XWPFDocument(fis);
        XWPFParagraph[] paragraphs = document.getParagraphs();
        for (XWPFParagraph para : paragraphs) {
            result+=" "+para.getText();
        }
        fis.close();
        return result;
    }
}
