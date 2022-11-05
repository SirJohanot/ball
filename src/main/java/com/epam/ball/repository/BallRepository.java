package com.epam.ball.repository;

import com.epam.ball.entity.BallObservable;

import java.util.Comparator;
import java.util.List;

public interface BallRepository {

    void add(BallObservable ballObservable);

    void delete(BallObservable ballObservable);

    void update(BallObservable ballObservable);

    List<BallObservable> query(BallSpecification ballSpecification);

    List<BallObservable> sort(Comparator<BallObservable> comparator);
}
