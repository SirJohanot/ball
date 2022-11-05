package com.patiun.ball.repository;

import com.patiun.ball.entity.BallObservable;

public interface BallSpecification {

    boolean specified(BallObservable ballObservable);
}
