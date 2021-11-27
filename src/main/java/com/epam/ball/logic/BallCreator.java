package com.epam.ball.logic;

import com.epam.ball.entity.Ball;
import com.epam.ball.entity.Point;

public class BallCreator {

    private static final String DELIMITER=" ";

    public BallCreator() {
    }

    public Ball create(String line){
        String[] splitLines=line.split(DELIMITER);
        double radius=Double.parseDouble(splitLines[0]);
        double xCoordinate=Double.parseDouble(splitLines[1]);
        double yCoordinate=Double.parseDouble(splitLines[2]);
        double zCoordinate=Double.parseDouble(splitLines[3]);
        return new Ball(radius, new Point(xCoordinate, yCoordinate, zCoordinate));
    }
}
