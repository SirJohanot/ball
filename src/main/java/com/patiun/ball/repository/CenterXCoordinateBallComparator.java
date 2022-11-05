package com.patiun.ball.repository;

import com.patiun.ball.entity.BallObservable;
import com.patiun.ball.entity.Point;

import java.util.Comparator;

public class CenterXCoordinateBallComparator implements Comparator<BallObservable> {
    @Override
    public int compare(BallObservable firstObservable, BallObservable secondObservable) {
        Point firstObservableCenter = firstObservable.getCenter();
        Point secondObservableCenter = secondObservable.getCenter();
        double firstObservableXCoordinate = firstObservableCenter.getXCoordinate();
        double secondObservableXCoordinate = secondObservableCenter.getXCoordinate();
        return Double.compare(firstObservableXCoordinate, secondObservableXCoordinate);
    }
}
