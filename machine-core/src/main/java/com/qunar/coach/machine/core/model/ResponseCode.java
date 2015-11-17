package com.qunar.coach.machine.core.model;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by niuli on 11/16/15.
 */
public class ResponseCode {
    private static final Map<Integer, String> RESPONSE_MAP = new HashMap<>();

    public static final int CODE_OK = 0;

    public static final int NO_TICKET = 1;

    public static final int INVALID_MACHINE = 2;

    public static final String DEFAULT_MSG = "Unknown error";

    static {
        RESPONSE_MAP.put(CODE_OK, "OK");
        RESPONSE_MAP.put(NO_TICKET, "NO ticket message");
        RESPONSE_MAP.put(INVALID_MACHINE, "Machine not registered");
    }

    public String getMsg(int code){
        if (RESPONSE_MAP.containsKey(code)) {
            return RESPONSE_MAP.get(code);
        }
        else{
            return DEFAULT_MSG;
        }
    }

}

