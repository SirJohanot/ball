package com.epam.ball.repository;

import com.epam.ball.entity.BallObservable;

import java.util.*;

public class BallRepositoryImpl implements BallRepository {

    Map<Integer, BallObservable> balls = new HashMap<>();

    public BallRepositoryImpl(){

    }

    @Override
    public void add(final BallObservable ballObservable) {
        balls.put(ballObservable.getId(), ballObservable);
    }

    @Override
    public void delete(final BallObservable ballObservable) {
        balls.remove(ballObservable.getId());
    }

    @Override
    public void update(final BallObservable ballObservable) {
        balls.put(ballObservable.getId(), ballObservable);
    }

    @Override
    public List<BallObservable> query(final BallSpecification ballSpecification) {
        List<BallObservable> result = new ArrayList<>();
        for (BallObservable ball : balls.values()) {
            if (ballSpecification.specified(ball)) {
                result.add(ball);
            }
        }
        return result;
    }

    @Override
    public List<BallObservable> sort(final Comparator<BallObservable> comparator) {
        List<BallObservable> result = new ArrayList<>(balls.values());
        result.sort(comparator);
        return result;
    }
}
