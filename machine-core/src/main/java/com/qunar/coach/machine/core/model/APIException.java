package com.qunar.coach.machine.core.model;

/**
 * Created by niuli on 15-11-1.
 */
public class APIException extends RuntimeException {
    private APIResponse<String> apiResponse;

    public APIException(String msg) {
        apiResponse = new APIResponse<String>(APIResponse.fail, msg, null);
    }

    public APIResponse<String> getApiResponse() {
        return apiResponse;
    }

    /**
     * Created by niuli on 15-10-21.
     */
    public static enum MachineStatus {
        UNKNOWN(-4), NEED_UPDATE(-3), UPDATING(-2), OFFLINE(-1), LOG_OFF(0), ONLINE(1);

        private final int value;

        MachineStatus(int value) {
            this.value = value;
        }

        public static MachineStatus valueOf(int value) {
             for (MachineStatus status : MachineStatus.values()) {
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
}
