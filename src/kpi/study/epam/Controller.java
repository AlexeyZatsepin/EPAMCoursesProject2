package kpi.study.epam;

import kpi.study.epam.language.Sentence;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * EPAM_Project2_doc_reader
 * Created 6/10/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class Controller {

    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        view.printToConsole(View.SELECT_FILE_MENU);
        List<File> list = getFilesList();
        view.printListToConsole(list);
        int value = inputIntValueWithScanner(scanner);
        while (value > list.size()) {
            value = inputIntValueWithScanner(scanner);
        }
        String text = null;
        try {
            File file = list.get(value - 1);
            if (file.getName().contains(".doc")){
                text = readDocFile(file);
            }else if(file.getName().contains(".docx")){
                text = readDocxFile(file);
            }else{
                text = readFile(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Sentence> sentences = parseText(text);
        //Collections.sort(sentences, (o1, o2) -> Integer.compare(o1.size(),o2.size()));
        Collections.sort(sentences);

        view.printListToConsole(sentences);
    }

    public List<File> getFilesList() {
        File folder = new File("docs");
        List<File> list = new ArrayList<>();
        Collections.addAll(list,folder.listFiles());
        return list;
    }

    public int inputIntValueWithScanner(Scanner sc) {
        view.printToConsole(View.INPUT_INT_DATA);
        while (!sc.hasNextInt()) {
            view.printToConsole(View.WRONG_INPUT_INT_DATA + View.INPUT_INT_DATA);
            sc.next();

        }
        return sc.nextInt();
    }

    public String readFile(File file) throws IOException {
        String text = "";
        FileReader input = new FileReader(file);
        int data = input.read();
        while(data != -1) {
            text += (char) data;
            data = input.read();
        }
        input.close();
        return text;
    }

    public List<Sentence> parseText(String text){
        List<Sentence> list = new ArrayList<>();
        String [] all= text.split("[\\.!\\?]");
        for (String s : all) {
            //if (s.matches("[A-Za-z]")){
                Sentence sentence = new Sentence();
                for (String c:s.split(",: ")){
                    sentence.addWord(c.trim());
                }
                list.add(sentence);
            //}
        }
        return list;
    }

    public String readDocFile(File file) {
        String result ="";
        try {
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());

            HWPFDocument doc = new HWPFDocument(fis);

            WordExtractor we = new WordExtractor(doc);

            String[] paragraphs = we.getParagraphText();
            for (String para : paragraphs) {
                result+=" "+para;
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public String readDocxFile(File file) {
        String result = "";
        try {
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());

            XWPFDocument document = new XWPFDocument(fis);

            XWPFParagraph[] paragraphs = document.getParagraphs();

            for (XWPFParagraph para : paragraphs) {
                result+=" "+para.getText();
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
