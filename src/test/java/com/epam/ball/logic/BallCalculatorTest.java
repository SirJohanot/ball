package com.epam.ball.logic;

import com.epam.ball.entity.Ball;
import com.epam.ball.entity.CoordinatePlane;
import com.epam.ball.entity.Point;
import org.junit.Assert;
import org.junit.Test;

public class BallCalculatorTest {

    private final BallCalculator calculator = new BallCalculator();

    @Test
    public void testCalculateSurfaceAreaShouldCalculateWhenBallIsValid() {
        //given
        Ball ball = new Ball(3, new Point(0, 0, 0));
        //when
        double surfaceArea = calculator.calculateSurfaceArea(ball);
        //then
        Assert.assertEquals(36 * Math.PI, surfaceArea, 0.00000001);
    }

    @Test
    public void testCalculateVolumeShouldCalculateWhenBallIsValid() {
        //given
        Ball ball = new Ball(3, new Point(0, 0, 0));
        //when
        double volume = calculator.calculateVolume(ball);
        //then
        Assert.assertEquals(36.0 * Math.PI, volume, 0.0000000001);
    }

    @Test
    public void testCalculateTheRatioOfVolumesDividedByCoordinatePlaneShouldCalculateWhenBallCrossesThePlane() {
        //given
        Ball ball = new Ball(3, new Point(2, 2, 2));
        double expectedRatio = 0.2611029573;
        //when
        double actualRatio = calculator.calculateTheRatioOfVolumesDividedByCoordinatePlane(ball, CoordinatePlane.XY);
        //then
        Assert.assertEquals(expectedRatio, actualRatio, 0.00000001);
    }

    @Test
    public void testCalculateTheRatioOfVolumesDividedByCoordinatePlaneShouldReturnZeroWhenBallDoesNotCrossThePlane() {
        //given
        Ball ball = new Ball(1, new Point(2, 2, 2));
        //when
        double ratio = calculator.calculateTheRatioOfVolumesDividedByCoordinatePlane(ball, CoordinatePlane.XY);
        //then
        Assert.assertEquals(0, ratio, 0.00000001);
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
