package com.epam.ball.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private static final Logger LOGGER = LogManager.getLogger(DataReader.class);

    public DataReader() {
    }

    public List<String> read(String path) throws DataException {
        LOGGER.info("Started reading data from " + path);
        List<String> result = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(path));
                String line = bufferedReader.readLine();
                while (line != null) {
                    result.add(line);
                    line = bufferedReader.readLine();
                }
            } catch (Exception e) {
                throw new DataException(e.getMessage(), e);
            } finally {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
        return result;
    }
}
