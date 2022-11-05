package com.epam.ball.logic;

import com.epam.ball.dao.DataException;
import com.epam.ball.dao.DataReader;
import com.epam.ball.entity.Ball;
import com.epam.ball.entity.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class DirectorTest {

    private static final String TEST_PATH = "path";
    private static final String VALID_LINE1 = "1.0 2.0 3.0 4.0";
    private static final String VALID_LINE2 = "2.0 -3.0 4.0 5.0";
    private static final String INVALID_LINE = "1z.0 2.0 3.0 4.0";
    private static final Ball VALID_BALL1 = new Ball(1, new Point(2, 3, 4));
    private static final Ball VALID_BALL2 = new Ball(2, new Point(-3, 4, 5));

    @Test
    public void testReadShouldReadLinesWhenLinesAreValid() throws DataException {
        //given
        List<String> actualLines = Arrays.asList(VALID_LINE1, VALID_LINE2);
        DataReader reader = Mockito.mock(DataReader.class);
        Mockito.when(reader.read(TEST_PATH)).thenReturn(actualLines);
        BallValidator validator = Mockito.mock(BallValidator.class);
        Mockito.when(validator.isValidLine(VALID_LINE1)).thenReturn(true);
        Mockito.when(validator.isValidLine(VALID_LINE2)).thenReturn(true);
        BallCreator creator = Mockito.mock(BallCreator.class);
        Mockito.when(creator.create(VALID_LINE1)).thenReturn(VALID_BALL1);
        Mockito.when(creator.create(VALID_LINE2)).thenReturn(VALID_BALL2);
        Director director = new Director(reader, validator, creator);
        List<Ball> expectedBalls = Arrays.asList(VALID_BALL1, VALID_BALL2);
        //when
        List<Ball> actualBalls = director.read(TEST_PATH);
        //then
        Assert.assertEquals(expectedBalls, actualBalls);
    }

    @Test
    public void testReadShouldReadLinesWhenSomeLinesAreInvalid() throws DataException {
        //given
        List<String> actualLines = Arrays.asList(VALID_LINE1, INVALID_LINE, VALID_LINE2);
        DataReader reader = Mockito.mock(DataReader.class);
        Mockito.when(reader.read(TEST_PATH)).thenReturn(actualLines);
        BallValidator validator = Mockito.mock(BallValidator.class);
        Mockito.when(validator.isValidLine(VALID_LINE1)).thenReturn(true);
        Mockito.when(validator.isValidLine(INVALID_LINE)).thenReturn(false);
        Mockito.when(validator.isValidLine(VALID_LINE2)).thenReturn(true);
        BallCreator creator = Mockito.mock(BallCreator.class);
        Mockito.when(creator.create(VALID_LINE1)).thenReturn(VALID_BALL1);
        Mockito.when(creator.create(VALID_LINE2)).thenReturn(VALID_BALL2);
        Director director = new Director(reader, validator, creator);
        List<Ball> expectedBalls = Arrays.asList(VALID_BALL1, VALID_BALL2);
        //when
        List<Ball> readBalls = director.read(TEST_PATH);
        //then
        Assert.assertEquals(expectedBalls, readBalls);
    }
}
