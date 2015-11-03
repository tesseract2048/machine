package com.qunar.coach.machine.service.utils;

import org.modelmapper.ModelMapper;

public final class RecordMapperUtils {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    private RecordMapperUtils() {}

    public static <B> B mapObject(Object record, Class<B> beanClass) {
        if (record == null) {
            return null;
        }
        return MODEL_MAPPER.map(record, beanClass);
    }

}
