package kpi.study.epam.language;

/**
 * EPAM_Project2_doc_reader
 * Created 6/24/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class Word {
    String word;

    public Word(String word) {
        this.word = word;
    }


    public int length() {
        return word.length();
    }

    @Override
    public String toString() {
        return word;
    }
}
