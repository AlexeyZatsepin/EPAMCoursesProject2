package kpi.study.epam.utils;

import kpi.study.epam.language.Sentence;
import kpi.study.epam.language.Dictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * EPAM_Project2_doc_reader
 * Created 6/24/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class Parser {
    private static final String REGEX_MARK = "[.]{3}|\\.|\\?|!";
    private static final String REGEX_SENTENCE_MARK = ", :";
    /**
     * @param text all text
     * @return list of sentences
     */
    public static List<Sentence> parseText(String text){
        List<Sentence> list = new ArrayList<>();
        String [] all= text.split(REGEX_MARK);
        for (String s : all) {
            if (!isCode(s.replace("\n", ""))){
                Sentence sentence = new Sentence();
                for (String c:s.split(REGEX_SENTENCE_MARK)){
                    sentence.addWord(Dictionary.getWord(c.trim()));
                }
                list.add(sentence);
            }
        }
        return list;
    }
    /**
     * @param s candidate to be java code
     * @return bool value
     */
    private static boolean isCode(String s) {
        String [] keywords = {"class","interface","package","import","public","static","abstract","private","try","lang","io","java"};
        for (String key:keywords){
            if (s.startsWith(key)){
                return true;
            }
        }
        return false;
    }
}
