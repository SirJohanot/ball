package com.epam.ball.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public DataReader() {
    }

    public List<String> read(String path) throws DataException {
        List<String> result = new ArrayList<>();
        try {
            File file = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line= bufferedReader.readLine();
            while (line!=null) {
                result.add(line);
                line= bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new DataException("Could not find file by that path", e);
        } catch (IOException e) {
            throw new DataException("An I/O error occured", e);
        }
        return result;
    }
}
