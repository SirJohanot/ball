package com.epam.ball.logic;

import com.epam.ball.dao.DataException;
import com.epam.ball.dao.DataReader;
import com.epam.ball.entity.Ball;

import java.util.ArrayList;
import java.util.List;

public class Director {

    private final DataReader reader;
    private final BallValidator validator;
    private final BallCreator creator;

    public Director(DataReader reader, BallValidator validator, BallCreator creator) {
        this.reader = reader;
        this.validator = validator;
        this.creator = creator;
    }

    public List<Ball> read(String path) throws DataException {
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
