package kpi.study.epam.utils;

import java.io.File;
import java.io.IOException;

/**
 * EPAM_Project2_doc_reader
 * Created 6/24/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public interface FileReader { //State
    /**
     * @param file File .txt
     * @return all text in one String
     * @throws IOException
     */
    String read(File file) throws IOException;
}
