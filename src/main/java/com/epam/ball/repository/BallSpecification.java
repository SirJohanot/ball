package com.epam.ball.repository;

import com.epam.ball.entity.BallObservable;

public interface BallSpecification {

    boolean specified(BallObservable ballObservable);
}
