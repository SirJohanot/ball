package com.epam.ball.logic;

import com.epam.ball.dao.DataReader;
import com.epam.ball.entity.Ball;

import java.util.ArrayList;
import java.util.List;

public class Director {

    private DataReader reader;
    private BallValidator validator;
    private BallCreator creator;

    public Director(DataReader reader, BallValidator validator, BallCreator creator) {
        this.reader = reader;
        this.validator = validator;
        this.creator = creator;
    }

    public List<Ball> read(String path){
        List<Ball> balls=new ArrayList<>();
        for (String line:reader.read(path)){
            if (validator.isValidBallLine(line)){
                balls.add(creator.create(line));
            }
        }
        return balls;
    }
}
