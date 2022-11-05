package com.patiun.ball.logic;

import com.patiun.ball.entity.Ball;
import com.patiun.ball.entity.CoordinatePlane;
import com.patiun.ball.entity.Point;
import org.junit.Assert;
import org.junit.Test;

public class BallCalculatorTest {

    private final BallCalculator calculator = new BallCalculator();
    private static final double DELTA=0.001;

    @Test
    public void testCalculateSurfaceAreaShouldCalculateWhenBallIsValid() {
        //given
        Ball ball = new Ball(3, new Point(0, 0, 0));
        //when
        double surfaceArea = calculator.calculateSurfaceArea(ball);
        //then
        Assert.assertEquals(36 * Math.PI, surfaceArea, DELTA);
    }

    @Test
    public void testCalculateVolumeShouldCalculateWhenBallIsValid() {
        //given
        Ball ball = new Ball(3, new Point(0, 0, 0));
        //when
        double volume = calculator.calculateVolume(ball);
        //then
        Assert.assertEquals(36.0 * Math.PI, volume, DELTA);
    }

    @Test
    public void testCalculateTheRatioOfVolumesDividedByCoordinatePlaneShouldCalculateWhenBallCrossesThePlane() {
        //given
        Ball ball = new Ball(3, new Point(2, 2, 2));
        double expectedRatio = 0.2611029573;
        //when
        double actualRatio = calculator.calculateTheRatioOfVolumesDividedByCoordinatePlane(ball, CoordinatePlane.XY);
        //then
        Assert.assertEquals(expectedRatio, actualRatio, DELTA);
    }

    @Test
    public void testCalculateTheRatioOfVolumesDividedByCoordinatePlaneShouldReturnZeroWhenBallDoesNotCrossThePlane() {
        //given
        Ball ball = new Ball(1, new Point(2, 2, 2));
        //when
        double ratio = calculator.calculateTheRatioOfVolumesDividedByCoordinatePlane(ball, CoordinatePlane.XY);
        //then
        Assert.assertEquals(0, ratio, DELTA);
    }

    @Test
    public void testIsCrossingTheCoordinatePlaneShouldReturnTrueWhenBallIsCrossingThePlane() {
        //given
        Ball ball = new Ball(3, new Point(2, 2, 2));
        //when
        boolean isCrossingPlane = calculator.isCrossingTheCoordinatePlane(ball, CoordinatePlane.XY);
        //then
        Assert.assertTrue(isCrossingPlane);
    }

    @Test
    public void testIsCrossingTheCoordinatePlaneShouldReturnFalseWhenBallIsNotCrossingThePlane() {
        //given
        Ball ball = new Ball(1, new Point(2, 2, 2));
        //when
        boolean isCrossingPlane = calculator.isCrossingTheCoordinatePlane(ball, CoordinatePlane.XY);
        //then
        Assert.assertFalse(isCrossingPlane);
    }

    @Test
    public void testIsAValidBallShouldReturnTrueWhenBallIsValid() {
        //given
        Ball ball = new Ball(1, new Point(2, 2, 2));
        //when
        boolean isValid = calculator.isAValidBall(ball);
        //then
        Assert.assertTrue(isValid);
    }

    @Test
    public void testIsAValidBallShouldReturnFalseWhenBallIsNotValid() {
        //given
        Ball ball = new Ball(-1, new Point(2, 2, 2));
        //when
        boolean isCrossingPlane = calculator.isAValidBall(ball);
        //then
        Assert.assertFalse(isCrossingPlane);
    }
}
