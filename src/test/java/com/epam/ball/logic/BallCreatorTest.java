package com.epam.ball.logic;

import com.epam.ball.entity.Ball;
import com.epam.ball.entity.Point;
import org.junit.Assert;
import org.junit.Test;

public class BallCreatorTest {

    private static final String VALID_LINE = "4.0 1.0 2.0 3.0";
    private static final String INVALID_LINE = "-4.0 1.0 2.0 3.0";

    private final BallCreator creator = new BallCreator();

    @Test
    public void testCreateShouldCreateABallWhenDataIsValid() {
        //given
        Ball expectedBall = new Ball(4.0, new Point(1.0, 2.0, 3.0));
        //when
        Ball createdBall = creator.create(VALID_LINE);
        //then
        Assert.assertEquals(expectedBall, createdBall);
    }

    @Test
    public void testCreateShouldCreateABallWhenDataIsInvalid() {
        //given
        Ball expectedBall = new Ball(-4.0, new Point(1.0, 2.0, 3.0));
        //when
        Ball createdBall = creator.create(INVALID_LINE);
        //then
        Assert.assertEquals(expectedBall, createdBall);
    }
}
