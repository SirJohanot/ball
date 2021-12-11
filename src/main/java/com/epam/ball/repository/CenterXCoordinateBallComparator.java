package com.epam.ball.repository;

import com.epam.ball.entity.BallObservable;
import com.epam.ball.entity.Point;

import java.util.Comparator;

public class CenterXCoordinateBallComparator implements Comparator<BallObservable> {
    @Override
    public int compare(BallObservable o1, BallObservable o2) {
        Point center1 = o1.getCenter();
        Point center2 = o2.getCenter();
        double xCoordinate1 = center1.getXCoordinate();
        double xCoordinate2 = center2.getXCoordinate();
        return Double.compare(xCoordinate1, xCoordinate2);
    }
}
