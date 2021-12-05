package com.epam.ball.repository;

import com.epam.ball.entity.BallObservable;
import com.epam.ball.entity.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BallRepositoryImplTest {

    @Test
    public void testQueryShouldReturnBallWhenBallFitsSpecification() {
        //given
        BallRepositoryImpl ballRepository = new BallRepositoryImpl();
        BallObservable ballObservable = new BallObservable(1.0, new Point(1.0, 1.0, 1.0), 1);
        ballRepository.add(ballObservable);
        BallSpecification specification = Mockito.mock(BallSpecification.class);
        Mockito.when(specification.specified(ballObservable)).thenReturn(true);
        List<BallObservable> expectedQuery = Arrays.asList(ballObservable);
        //when
        List<BallObservable> actualQuery = ballRepository.query(specification);
        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testQueryShouldNotReturnBallWhenBallDoesNotFitSpecification() {
        //given
        BallRepositoryImpl ballRepository = new BallRepositoryImpl();
        BallObservable ballObservable = new BallObservable(1.0, new Point(1.0, 1.0, 1.0), 1);
        ballRepository.add(ballObservable);
        BallSpecification specification = Mockito.mock(BallSpecification.class);
        Mockito.when(specification.specified(ballObservable)).thenReturn(false);
        List<BallObservable> expectedQuery = new ArrayList<>();
        //when
        List<BallObservable> actualQuery = ballRepository.query(specification);
        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }
}
