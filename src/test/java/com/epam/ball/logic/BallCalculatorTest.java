package com.epam.ball.logic;

import com.epam.ball.entity.Ball;
import com.epam.ball.entity.CoordinatePlane;
import com.epam.ball.entity.Point;
import org.junit.Assert;
import org.junit.Test;

public class BallCalculatorTest {

    @Test
    public void testShouldCalculateSurfaceAreaWhenBallIsValid() {
        //given
        BallCalculator calculator = new BallCalculator();
        Ball ball = new Ball(3, new Point(0, 0, 0));
        //when
        double surfaceArea = calculator.calculateSurfaceArea(ball);
        //then
        Assert.assertEquals(36 * Math.PI, surfaceArea, 0);
    }

    @Test
    public void testShouldCalculateVolumeWhenBallIsValid() {
        //given
        BallCalculator calculator = new BallCalculator();
        Ball ball = new Ball(3, new Point(0, 0, 0));
        //when
        double volume = calculator.calculateVolume(ball);
        //then
        Assert.assertEquals(36.0 * Math.PI, volume, 0.0000000001);
    }

    @Test
    public void testShouldCalculateVolumeRatioWhenBallCrossesThePlane() {
        //given
        BallCalculator calculator = new BallCalculator();
        Ball ball = new Ball(3, new Point(2, 2, 2));
        //when
        double volume = 4.0 / 3.0 * Math.PI * Math.pow(ball.getRadius(), 3);
        double ratio = calculator.calculateTheRatioOfVolumesDividedByCoordinatePlane(ball, CoordinatePlane.XY);
        double lesserHemisphereVolume = 2.0 / 3.0 * Math.pow(Math.sqrt(5), 2);
        //then
        Assert.assertEquals(lesserHemisphereVolume / (volume - lesserHemisphereVolume), ratio, 0);
    }

    @Test
    public void testShouldReturnZeroAsRatioWhenBallDoesNotCrossThePlane() {
        //given
        BallCalculator calculator = new BallCalculator();
        Ball ball = new Ball(1, new Point(2, 2, 2));
        //when
        double ratio = calculator.calculateTheRatioOfVolumesDividedByCoordinatePlane(ball, CoordinatePlane.XY);
        //then
        Assert.assertEquals(0, ratio, 0);
    }

    @Test
    public void testShouldReturnTrueWhenBallIsCrossingThePlane() {
        //given
        BallCalculator calculator = new BallCalculator();
        Ball ball = new Ball(3, new Point(2, 2, 2));
        //when
        boolean isCrossingPlane = calculator.isCrossingTheCoordinatePlane(ball, CoordinatePlane.XY);
        //then
        Assert.assertTrue(isCrossingPlane);
    }

    @Test
    public void testShouldReturnFalseWhenBallIsNotCrossingThePlane() {
        //given
        BallCalculator calculator = new BallCalculator();
        Ball ball = new Ball(1, new Point(2, 2, 2));
        //when
        boolean isCrossingPlane = calculator.isCrossingTheCoordinatePlane(ball, CoordinatePlane.XY);
        //then
        Assert.assertFalse(isCrossingPlane);
    }

    @Test
    public void testShouldReturnTrueWhenBallIsValid() {
        //given
        BallCalculator calculator = new BallCalculator();
        Ball ball = new Ball(1, new Point(2, 2, 2));
        //when
        boolean isValid = calculator.isAValidBall(ball);
        //then
        Assert.assertTrue(isValid);
    }

    @Test
    public void testShouldReturnFalseWhenBallIsNotValid() {
        //given
        BallCalculator calculator = new BallCalculator();
        Ball ball = new Ball(-1, new Point(2, 2, 2));
        //when
        boolean isCrossingPlane = calculator.isAValidBall(ball);
        //then
        Assert.assertFalse(isCrossingPlane);
    }
}
