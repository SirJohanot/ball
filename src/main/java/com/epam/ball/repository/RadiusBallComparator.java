package com.epam.ball.repository;

import com.epam.ball.entity.BallObservable;

import java.util.Comparator;

public class RadiusBallComparator implements Comparator<BallObservable> {
    @Override
    public int compare(BallObservable o1, BallObservable o2) {
        return Double.compare(o1.getRadius(), o2.getRadius());
    }
}
