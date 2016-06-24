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
    private List<String> words;

    public Sentence() { 
        this.words = new LinkedList<>();
    }

    public void addWord(String word){
        words.add(word);
    }
    
    public int size(){
        int size =0;
        for (String s:words){
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
        return Integer.compare(size(),o.size());
    }
}
