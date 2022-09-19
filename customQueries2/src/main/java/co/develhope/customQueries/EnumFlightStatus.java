package co.develhope.customQueries;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum EnumFlightStatus {
    ONTIME,
    DELAYED,
    CANCELLED;

    private static final List<EnumFlightStatus> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int size = VALUES.size();
    private static final Random RANDOM = new Random();

    public static EnumFlightStatus randomEnum() {
        return VALUES.get(RANDOM.nextInt(size));
    }
}
