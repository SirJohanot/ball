package com.epam.ball.logic;

import com.epam.ball.dao.DataException;
import com.epam.ball.dao.DataReader;
import com.epam.ball.entity.Ball;
import com.epam.ball.entity.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class DirectorTest {

    @Test
    public void testShouldReadLinesWhenLinesAreValid() throws DataException {
        //given
        DataReader reader= Mockito.mock(DataReader.class);
        List<String> lines=new ArrayList<>();
        lines.add("1.0 2.0 3.0 4.0");
        lines.add("2.0 -3.0 4.0 5.0");
        String path="";
        Mockito.when(reader.read(path)).thenReturn(lines);
        Director director=new Director(reader, new BallValidator(), new BallCreator());
        //when
        List<Ball> balls=new ArrayList<>();
        balls.add(new Ball(1, new Point(2, 3, 4)));
        balls.add(new Ball(2, new Point(-3, 4, 5)));
        List<Ball> readBalls=director.read(path);
        //then
        Assert.assertEquals(balls, readBalls);
    }

    @Test
    public void testShouldReadLinesWhenSomeLinesAreInvalid() throws DataException {
        //given
        DataReader reader= Mockito.mock(DataReader.class);
        List<String> lines=new ArrayList<>();
        lines.add("1.0 2.0 3.0 4.0");
        lines.add("1z.0 2.0 3.0 4.0");
        lines.add("2.0 -3.0 4.0 5.0");
        String path="";
        Mockito.when(reader.read(path)).thenReturn(lines);
        Director director=new Director(reader, new BallValidator(), new BallCreator());
        //when
        List<Ball> balls=new ArrayList<>();
        balls.add(new Ball(1, new Point(2, 3, 4)));
        balls.add(new Ball(2, new Point(-3, 4, 5)));
        List<Ball> readBalls=director.read(path);
        //then
        Assert.assertEquals(balls, readBalls);
    }
}
