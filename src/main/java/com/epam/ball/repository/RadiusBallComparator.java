package com.epam.ball.repository;

import com.epam.ball.entity.BallObservable;

import java.util.Comparator;

public class RadiusBallComparator implements Comparator<BallObservable> {
    @Override
    public int compare(BallObservable firstObservable, BallObservable secondObservable) {
        return Double.compare(firstObservable.getRadius(), secondObservable.getRadius());
    }
}
