package com.patiun.ball.entity;

public class Parameters {

    private final double volume;
    private final double surfaceArea;

    public Parameters(double volume, double surfaceArea) {
        this.volume = volume;
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Parameters that = (Parameters) o;
        if (Double.compare(that.volume, volume) != 0) {
            return false;
        }
        return Double.compare(that.surfaceArea, surfaceArea) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(volume);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(surfaceArea);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
