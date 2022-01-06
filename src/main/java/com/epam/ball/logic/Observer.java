package com.epam.ball.logic;

public interface Observer<T> {

    void update(T event);
}
