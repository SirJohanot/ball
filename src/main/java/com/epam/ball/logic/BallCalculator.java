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

    public double calculateTheRatioOfVolumesDividedByCoordinatePlane(Ball ball, CoordinatePlane plane) {
        if (!isCrossingTheCoordinatePlane(ball, plane)) return 0;
        Point center = ball.getCenter();
        double distanceFromCenterToPlane = 0;
        switch (plane) {
            case XY:
                distanceFromCenterToPlane = center.getZCoordinate();
                break;
            case YZ:
                distanceFromCenterToPlane = center.getXCoordinate();
                break;
            case XZ:
                distanceFromCenterToPlane = center.getYCoordinate();
        }
        double radius = ball.getRadius();
        double lesserHemisphereRadius = Math.sqrt(Math.pow(radius, 2) - Math.pow(distanceFromCenterToPlane, 2));
        double lesserHemisphereVolume = 2.0 / 3.0 * Math.PI * Math.pow(lesserHemisphereRadius, 3);
        return lesserHemisphereVolume / (calculateVolume(ball) - lesserHemisphereVolume);
    }

    public boolean isAValidBall(Ball ball) {
        return (ball.getRadius() > 0);
    }

    public boolean isCrossingTheCoordinatePlane(Ball ball, CoordinatePlane plane) {
        Point center = ball.getCenter();
        double coordinate = 0;
        switch (plane) {
            case XY:
                coordinate = center.getZCoordinate();
                break;
            case YZ:
                coordinate = center.getXCoordinate();
                break;
            case XZ:
                coordinate = center.getYCoordinate();
                break;
        }
        double radius = ball.getRadius();
        return Math.abs(coordinate) <= radius;
    }
}
