package com.epam.ball.logic;

import com.epam.ball.entity.Ball;
import com.epam.ball.entity.Point;
import org.junit.Assert;
import org.junit.Test;

public class BallCreatorTest {

    @Test
    public void testShouldCreateABallWhenDataIsValid(){
        //given
        BallCreator creator=new BallCreator();
        double radius=4;
        double xCoordinate=1;
        double yCoordinate=2;
        double zCoordinate=3;
        String creatorLine="4.0 1.0 2.0 3.0";
        //when
        Ball ball=new Ball(radius, new Point(xCoordinate, yCoordinate, zCoordinate));
        Ball createdBall=creator.create(creatorLine);
        //then
        Assert.assertEquals(ball, createdBall);
    }

    @Test
    public void testShouldCreateABallWhenDataIsInvalid(){
        //given
        BallCreator creator=new BallCreator();
        double radius=-4;
        double xCoordinate=1;
        double yCoordinate=2;
        double zCoordinate=3;
        String creatorLine="-4.0 1.0 2.0 3.0";
        //when
        Ball ball=new Ball(radius, new Point(xCoordinate, yCoordinate, zCoordinate));
        Ball createdBall=creator.create(creatorLine);
        //then
        Assert.assertEquals(ball, createdBall);
    }
}
