package racingcar.util;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int RANDOM_BOUNDARY = 10;
    private static final Random random = new Random();

    private RandomNumberGenerator() { }

    public static int generateRacingRandomNumber() {
        return random.nextInt(RANDOM_BOUNDARY);
    }
}
