package kpi.study.epam.utils;

import java.io.File;
import java.io.IOException;

/**
 * EPAM_Project2_doc_reader
 * Created 6/24/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class ReadDirector {
    private FileReader reader;

    public void setReader(FileReader reader){
        this.reader = reader;
    }

    public String read(File file){
        if (file.getName().contains(".doc")){
            setReader(new DOCReader());
        }else if(file.getName().contains(".docx")){
            setReader(new DOCXReader());
        }else if(file.getName().contains(".txt")){
            setReader(new TXTReader());
        }
        try {
            return reader.read(file);
        } catch (IOException e) {
            return null;
        }
    }

}
