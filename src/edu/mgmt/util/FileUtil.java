package edu.mgmt.util;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

public class FileUtil {

    private Part part;
    private File asDirPath;

    public FileUtil(String dirPath){
        this.asDirPath = new File(dirPath);
        if (!this.asDirPath.exists()){
            this.asDirPath.mkdirs();
        }
    }

    public boolean saveFile(String absPath, Part part) throws IOException {
        boolean f = false;
        part.write(absPath);
        f = true;
        return f;
    }

}
