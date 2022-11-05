package com.epam.ball.entity;

import com.epam.ball.logic.Observable;
import com.epam.ball.logic.Observer;

import java.util.ArrayList;
import java.util.List;

public class BallObservable extends Ball implements Observable<BallObservable> {

    private final Integer id;
    private final List<Observer<BallObservable>> observerList = new ArrayList<>();

    public BallObservable(double radius, Point center, Integer id) {
        super(radius, center);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setCenter(Point center) {
        super.setCenter(center);
        notifyObservers();
    }

    @Override
    public void setRadius(double radius) {
        super.setRadius(radius);
        notifyObservers();
    }

    @Override
    public void attach(Observer<BallObservable> observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer<BallObservable> observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer<BallObservable> observer : observerList) {
            observer.update(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        BallObservable that = (BallObservable) o;
        return id == that.id && observerList.equals(that.observerList);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + super.hashCode();
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "BallIdentifiable{" +
                "id=" + id +
                ", observerList=" + observerList +
                '}';
    }
}
