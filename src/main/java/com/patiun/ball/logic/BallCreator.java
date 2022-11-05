package com.patiun.ball.logic;

import com.patiun.ball.entity.Ball;
import com.patiun.ball.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BallCreator {

    private static final Logger LOGGER = LogManager.getLogger(BallCreator.class);

    private static final String DELIMITER = " ";

    public Ball create(String line) {
        LOGGER.info("Started creating a Ball from string: " + line);
        String[] splitLines = line.split(DELIMITER);
        double radius = Double.parseDouble(splitLines[0]);
        double xCoordinate = Double.parseDouble(splitLines[1]);
        double yCoordinate = Double.parseDouble(splitLines[2]);
        double zCoordinate = Double.parseDouble(splitLines[3]);
        Ball createdBall = new Ball(radius, new Point(xCoordinate, yCoordinate, zCoordinate));
        LOGGER.info("A Ball from string '" + line + "' is " + createdBall);
        return createdBall;
    }
}
