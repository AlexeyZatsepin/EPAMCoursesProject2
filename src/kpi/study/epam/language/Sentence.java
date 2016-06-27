package kpi.study.epam.language;

import java.util.LinkedList;
import java.util.List;

/**
 * EPAM_Project2_doc_reader
 * Created 6/10/16, with IntelliJ IDEA
 * Basic language comparable class , that describe sentence entity
 * @author Alex
 */
public class Sentence implements Comparable<Sentence>{
    // sentence is list of words
    private List<Word> words;

    public Sentence() { 
        this.words = new LinkedList<>();
    }

    public void addWord(Word word){
        words.add(word);
    }

    // @return size of sentence
    public int size(){
        int size =0;
        for (Word s:words){
            size+=s.length();
        }
        return size;
    }
    @Override
    public String toString() {
        return words.toString();
    }

    @Override
    public int compareTo(Sentence o) {
        return Integer.compare(o.size(),size());
    }
}
