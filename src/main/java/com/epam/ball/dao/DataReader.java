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
            String temp;
            while ((temp=bufferedReader.readLine())!=null)
                result.add(temp);
        } catch (FileNotFoundException e) {
            throw new DataException("Could not find file by that path");
        } catch (IOException e) {
            throw new DataException("An I/O error occured");
        }
        return result;
    }
}
