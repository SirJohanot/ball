package com.epam.ball.logic;

import java.util.regex.Pattern;

public class BallValidator {

    private static final String BALL_LINE_REGEX = "\\d+\\.\\d+( (-)?\\d+\\.\\d+){3}";

    public boolean isValidLine(String line) {
        return Pattern.matches(BALL_LINE_REGEX, line);
    }
}
