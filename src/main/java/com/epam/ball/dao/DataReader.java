package com.epam.ball.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private static final Logger LOGGER = LogManager.getLogger(DataReader.class.getName());

    public DataReader() {
    }

    public List<String> read(String path) throws DataException {
        LOGGER.info("Started reading data from " + path);
        List<String> result = new ArrayList<>();
        try {
            File file = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            while (line != null) {
                result.add(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("Caught " + e);
            DataException dataException = new DataException("Could not find file by that path", e);
            LOGGER.throwing(dataException);
            throw dataException;
        } catch (IOException e) {
            LOGGER.error("Caught " + e);
            DataException dataException = new DataException("An I/O error occured", e);
            LOGGER.throwing(dataException);
            throw dataException;
        }
        return result;
    }
}
