package com.epam.ball.logic;

import com.epam.ball.entity.BallObservable;
import com.epam.ball.entity.Parameters;

import java.util.HashMap;
import java.util.Map;

public class BallStore implements Observer<BallObservable> {

    private static BallStore INSTANCE;

    private final BallCalculator ballCalculator = new BallCalculator();

    private final Map<Integer, Parameters> parameters = new HashMap<>();

    public void update(BallObservable ball) {
        double volume = ballCalculator.calculateVolume(ball);
        double surfaceArea = ballCalculator.calculateSurfaceArea(ball);
        parameters.put(ball.getId(), new Parameters(volume, surfaceArea));
    }

    public Parameters get(Integer key) {
        return parameters.get(key);
    }

    public static BallStore getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BallStore();
        }
        return INSTANCE;
    }
}
