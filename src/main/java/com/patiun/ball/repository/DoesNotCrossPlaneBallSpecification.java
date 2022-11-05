package com.patiun.ball.repository;

import com.patiun.ball.entity.BallObservable;
import com.patiun.ball.entity.CoordinatePlane;
import com.patiun.ball.entity.Point;

public class DoesNotCrossPlaneBallSpecification implements BallSpecification {

    private final CoordinatePlane plane;

    public DoesNotCrossPlaneBallSpecification(CoordinatePlane plane) {
        this.plane = plane;
    }

    private double distanceFromPlane(BallObservable ballObservable) {
        Point center = ballObservable.getCenter();
        switch (plane) {
            case XY:
                return center.getZCoordinate();
            case YZ:
                return center.getXCoordinate();
            case XZ:
                return center.getYCoordinate();
        }
        return 0.0;
    }

    @Override
    public boolean specified(BallObservable ballObservable) {
        return distanceFromPlane(ballObservable) > ballObservable.getRadius();
    }
}
