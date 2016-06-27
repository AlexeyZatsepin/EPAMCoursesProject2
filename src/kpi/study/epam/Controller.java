package kpi.study.epam;

import kpi.study.epam.language.Sentence;
import kpi.study.epam.utils.Parser;
import kpi.study.epam.utils.ReadDirector;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * EPAM_Project2_doc_reader
 * Created 6/10/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class Controller {
    // Java code regexp pattern
    public static final String KEYWORD_PATTERN = "(class|interface|import|package) +\\w+?";

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
        File file = list.get(value - 1);
        String text = new ReadDirector().read(file);

        List<Sentence> sentences = Parser.parseText(text);
        //Collections.sort(sentences, (o1, o2) -> Integer.compare(o1.size(),o2.size()));
        Collections.sort(sentences);

        view.printListToConsole(sentences);
    }

    /**
     * @return return existed file list
     */
    private List<File> getFilesList() {
        File folder = new File("docs");
        List<File> list = new ArrayList<>();
        Collections.addAll(list,folder.listFiles());
        return list;
    }

    /**
     * @param sc Scanner
     * @return input value
     */
    private int inputIntValueWithScanner(Scanner sc) {
        view.printToConsole(View.INPUT_INT_DATA);
        while (!sc.hasNextInt()) {
            view.printToConsole(View.WRONG_INPUT_INT_DATA + View.INPUT_INT_DATA);
            sc.next();

        }
        return sc.nextInt();
    }
}
