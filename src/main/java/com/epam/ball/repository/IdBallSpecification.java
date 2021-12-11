package com.epam.ball.repository;

import com.epam.ball.entity.BallObservable;

public class IdBallSpecification implements BallSpecification {

    private final Integer id;

    public IdBallSpecification(Integer id) {
        this.id = id;
    }

    @Override
    public boolean specified(BallObservable ballObservable) {
        return ballObservable.getId().equals(id);
    }
}
