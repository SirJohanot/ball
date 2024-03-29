package com.patiun.ball.entity;

public class Ball {

    private Point center = new Point();
    private double radius;

    public Ball() {
    }

    public Ball(double radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return Double.compare(ball.radius, radius) == 0 && center.equals(ball.center);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + center.hashCode();
        result = 31 * result + (int) radius;
        return result;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
