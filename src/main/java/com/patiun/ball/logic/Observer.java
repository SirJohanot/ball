package com.patiun.ball.logic;

public interface Observer<T> {

    void update(T event);
}
