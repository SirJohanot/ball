package com.epam.ball.logic;

import com.epam.ball.entity.Ball;
import com.epam.ball.entity.CoordinatePlane;
import com.epam.ball.entity.Point;

public class BallCalculator {

    public BallCalculator() {
    }

    public double calculateSurfaceArea(Ball ball) {
        double result = 4.0 * Math.PI * Math.pow(ball.getRadius(), 2);
        return result;
    }

    public double calculateVolume(Ball ball) {
        double result = 4.0 / 3.0 * Math.PI * Math.pow(ball.getRadius(), 3);
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
        if (!isCrossingTheCoordinatePlane(ball, plane)) {
            return 0;
        }
        Point center = ball.getCenter();
        double distanceFromCenterToPlane = distanceFromPlane(plane, center);
        double radius = ball.getRadius();
        double lesserHemisphereRadius = Math.sqrt(Math.pow(radius, 2) - Math.pow(distanceFromCenterToPlane, 2));
        double lesserHemisphereVolume = 2.0 / 3.0 * Math.PI * Math.pow(lesserHemisphereRadius, 3);
        return lesserHemisphereVolume / (calculateVolume(ball) - lesserHemisphereVolume);
    }

    public boolean isAValidBall(Ball ball) {
        return ball.getRadius() > 0;
    }

    public boolean isCrossingTheCoordinatePlane(Ball ball, CoordinatePlane plane) {
        Point center = ball.getCenter();
        double coordinate = distanceFromPlane(plane, center);
        double radius = ball.getRadius();
        return Math.abs(coordinate) <= radius;
    }
}
