package com.patiun.ball.repository;

import com.patiun.ball.entity.BallObservable;

import java.util.Comparator;

public class RadiusBallComparator implements Comparator<BallObservable> {
    @Override
    public int compare(BallObservable firstObservable, BallObservable secondObservable) {
        return Double.compare(firstObservable.getRadius(), secondObservable.getRadius());
    }
}
