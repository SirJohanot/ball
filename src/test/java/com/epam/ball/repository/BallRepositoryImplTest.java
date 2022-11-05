package com.epam.ball.repository;

import com.epam.ball.entity.BallObservable;
import com.epam.ball.entity.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BallRepositoryImplTest {

    private static final BallObservable BALL1 = new BallObservable(1.0, new Point(1.0, 1.0, 1.0), 1);
    private static final BallObservable BALL2=new BallObservable(2.0, new Point(1.0, 1.0, 1.0), 2);

    @Test
    public void testQueryShouldReturnBallWhenBallFitsSpecification() {
        //given
        BallRepositoryImpl ballRepository = new BallRepositoryImpl();
        ballRepository.add(BALL1);
        BallSpecification specification = Mockito.mock(BallSpecification.class);
        Mockito.when(specification.specified(BALL1)).thenReturn(true);
        List<BallObservable> expectedQuery = Arrays.asList(BALL1);
        //when
        List<BallObservable> actualQuery = ballRepository.query(specification);
        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testQueryShouldNotReturnBallWhenBallDoesNotFitSpecification() {
        //given
        BallRepositoryImpl ballRepository = new BallRepositoryImpl();
        ballRepository.add(BALL1);
        BallSpecification specification = Mockito.mock(BallSpecification.class);
        Mockito.when(specification.specified(BALL1)).thenReturn(false);
        List<BallObservable> expectedQuery = new ArrayList<>();
        //when
        List<BallObservable> actualQuery = ballRepository.query(specification);
        //then
        Assert.assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testSortShouldSortWhenComparatorComparesByRadius() {
        //given
        BallRepositoryImpl ballRepository = new BallRepositoryImpl();
        ballRepository.add(BALL2);
        ballRepository.add(BALL1);
        Comparator<BallObservable> comparatorMock=Mockito.mock(Comparator.class);
        Mockito.when(comparatorMock.compare(BALL1, BALL2)).thenReturn(-1);
        List<BallObservable> expectedSorted = Arrays.asList(BALL1, BALL2);
        //when
        List<BallObservable> actualSorted = ballRepository.sort(comparatorMock);
        //then
        Assert.assertEquals(expectedSorted, actualSorted);
    }

}
