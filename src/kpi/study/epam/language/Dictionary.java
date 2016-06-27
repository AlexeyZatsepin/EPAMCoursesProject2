package kpi.study.epam.language;

import java.util.Map;
import java.util.TreeMap;

/**
 * EPAM_Project2_doc_reader
 * Created 6/27/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class Dictionary {
    /**
     *  words map of language (dictionary)
     */
    private static final Map<String, Word> wordMap = new TreeMap<>();

    /**
     *
     * @param str string word , language unit
     * @return word object that correlate with str
     */
    public static Word getWord(String str) {
        Word word = wordMap.get(str);
        if(word == null) {
            word = new Word(str);
            wordMap.put(str, word);
        }
        return word;
    }
}
