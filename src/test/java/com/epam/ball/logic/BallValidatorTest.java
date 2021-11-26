package com.epam.ball.logic;

import com.epam.ball.entity.Ball;
import org.junit.Assert;
import org.junit.Test;

public class BallValidatorTest {

    @Test
    public void testShouldReturnTrueWhenTheLineIsValid(){
        //given
        BallValidator validator=new BallValidator();
        String validLine="1.0 2.0 3.0 4.0";
        //when
        boolean statement=validator.isValidBallLine(validLine);
        //then
        Assert.assertTrue(statement);
    }

    @Test
    public void testShouldReturnTrueWhenTheLineIsInvalid(){
        //given
        BallValidator validator=new BallValidator();
        String invalidLine="1.z0 2.0 3.0 4.0";
        //when
        boolean statement=validator.isValidBallLine(invalidLine);
        //then
        Assert.assertFalse(statement);
    }
}
