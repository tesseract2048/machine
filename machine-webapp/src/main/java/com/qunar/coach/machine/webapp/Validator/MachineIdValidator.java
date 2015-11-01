package com.qunar.coach.machine.webapp.Validator;

import com.qunar.coach.machine.dao.model.tables.pojos.Machine;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by zhangyunfan on 15-11-1.
 */
public class MachineIdValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(Machine.class);
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
