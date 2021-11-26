package com.epam.ball.entity;

import java.util.Objects;

public class Point {

    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;

    public Point() {
    }

    public Point(double xCoordinate, double yCoordinate, double zCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public double getZCoordinate() {
        return zCoordinate;
    }

    public void setZCoordinate(double zCoordinate) {
        this.zCoordinate = zCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.xCoordinate, xCoordinate) == 0 && Double.compare(point.yCoordinate, yCoordinate) == 0 && Double.compare(point.zCoordinate, zCoordinate) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (int)xCoordinate;
        result = 31 * result + (int)yCoordinate;
        result = 31 * result + (int)zCoordinate;
        return result;
    }
}
