package com.epam.ball.logic;

import com.epam.ball.entity.BallObservable;
import com.epam.ball.entity.Parameters;
import com.epam.ball.entity.Point;
import org.junit.Assert;
import org.junit.Test;

public class BallStoreTest {

    private static final double DELTA=0.001;

    @Test
    public void testUpdateShouldUpdateVolumesWhenABallIsChanged(){
        //given
        BallStore ballStore=BallStore.getInstance();
        BallObservable ballObservable1 =new BallObservable(2.0, new Point(0.0, 0.0, 0.0), 1);
        ballObservable1.attach(ballStore);
        ballStore.update(ballObservable1);
        BallObservable ballObservable2=new BallObservable(3.0, new Point(0.0, 0.0, 0.0), 2);
        ballObservable2.attach(ballStore);
        ballStore.update(ballObservable2);
        double expectedVolume=268.082573106;
        //when
        ballObservable2.setRadius(4.0);
        Parameters actualParameters=ballStore.get(2);
        double actualVolume= actualParameters.getVolume();
        //then
        Assert.assertEquals(expectedVolume, actualVolume, DELTA);
    }
}
