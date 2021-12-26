package com.epam.ball.logic;

import com.epam.ball.dao.DataException;
import com.epam.ball.dao.DataReader;
import com.epam.ball.entity.Ball;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Director {

    private static final Logger LOGGER = LogManager.getLogger(Director.class);

    private final DataReader reader;
    private final BallValidator validator;
    private final BallCreator creator;

    public Director(DataReader reader, BallValidator validator, BallCreator creator) {
        this.reader = reader;
        this.validator = validator;
        this.creator = creator;
    }

    public List<Ball> read(String path) throws DataException {
        LOGGER.info("Started reading balls from file: " + path);
        List<Ball> balls = new ArrayList<>();
        for (String line : reader.read(path)) {
            if (validator.isValidLine(line)) {
                Ball ball = creator.create(line);
                balls.add(ball);
            }
        }
        return balls;
    }
}
