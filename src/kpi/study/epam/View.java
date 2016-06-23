package kpi.study.epam;

import java.util.List;

/**
 * EPAM_Project2_doc_reader
 * Created 6/11/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class View {
    public static final String SELECT_FILE_MENU= " Please select file by number: ";

    public static final String INPUT_INT_DATA = "Input INT value = ";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";

    void printToConsole(String text){
        System.out.println(text);
    }

    void printListToConsole(List<?> list){
        int k = 1;
        for (Object i :list) {
            System.out.println(String.valueOf(k++)+ ". " + i);
        }
    }
}