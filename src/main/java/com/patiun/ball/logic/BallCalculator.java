package com.patiun.ball.logic;

import com.patiun.ball.entity.Ball;
import com.patiun.ball.entity.CoordinatePlane;
import com.patiun.ball.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BallCalculator {

    private static final Logger LOGGER = LogManager.getLogger(BallCalculator.class);

    public double calculateSurfaceArea(Ball ball) {
        LOGGER.info("Started calculating the surface area of " + ball.toString());
        double result = 4.0 * Math.PI * Math.pow(ball.getRadius(), 2);
        LOGGER.info("Calculated the surface area of " + ball + ": " + result);
        return result;
    }

    public double calculateVolume(Ball ball) {
        LOGGER.info("Started calculating the volume of " + ball.toString());
        double result = 4.0 / 3.0 * Math.PI * Math.pow(ball.getRadius(), 3);
        LOGGER.info("Calculated the volume of " + ball + ": " + result);
        return result;
    }

    private double distanceFromPlane(CoordinatePlane plane, Point center) {
        switch (plane) {
            case XY:
                return center.getZCoordinate();
            case YZ:
                return center.getXCoordinate();
            case XZ:
                return center.getYCoordinate();
        }
        return 0;
    }

    public double calculateTheRatioOfVolumesDividedByCoordinatePlane(Ball ball, CoordinatePlane plane) {
        LOGGER.info("Started calculating the ratio of volumes of " + ball.toString() + " divided by " + plane.toString() + " plane");
        if (!isCrossingTheCoordinatePlane(ball, plane)) {
            return 0;
        }
        Point center = ball.getCenter();
        double distanceFromCenterToPlane = distanceFromPlane(plane, center);
        double radius = ball.getRadius();
        double lesserHemisphereRadius = Math.sqrt(Math.pow(radius, 2) - Math.pow(distanceFromCenterToPlane, 2));
        double lesserHemisphereVolume = 2.0 / 3.0 * Math.PI * Math.pow(lesserHemisphereRadius, 3);
        double ratio = lesserHemisphereVolume / (calculateVolume(ball) - lesserHemisphereVolume);
        LOGGER.info("Calculated the ratio of volumes of " + ball + " divided by " + plane + " plane: " + ratio);
        return ratio;
    }

    public boolean isAValidBall(Ball ball) {
        return ball.getRadius() > 0;
    }

    public boolean isCrossingTheCoordinatePlane(Ball ball, CoordinatePlane plane) {
        LOGGER.info("Started calculating whether " + ball.toString() + " is crossing the " + plane.toString() + " plane");
        Point center = ball.getCenter();
        double coordinate = distanceFromPlane(plane, center);
        double radius = ball.getRadius();
        boolean isCrossing = Math.abs(coordinate) <= radius;
        LOGGER.info("Calculated whether " + ball + " is crossing the " + plane + " plane: " + isCrossing);
        return isCrossing;
    }
}
