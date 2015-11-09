package com.qunar.coach.machine.core.mode;

/**
 * Created by niuli on 11/9/15.
 */
public enum StationType {
    UNKNOWN(0), YUNNAN(1), SHENZHEN(2), ;

    private final int value;

    StationType(int value) {
        this.value = value;
    }

    public static StationType valueOf(int value) {
        for (StationType status : StationType.values()) {
            if (value == status.getValue()) {
                return status;
            }
        }
        return UNKNOWN;
    }

    public int getValue() {
        return value;
    }
}
