package com.qunar.coach.machine.core.mocker;

import java.util.List;

/**
 * Created by niuli on 15-10-30.
 */
public interface IMocker<T> {
    T mock();

    T mockAnother();

    List<T> mockList();
}


