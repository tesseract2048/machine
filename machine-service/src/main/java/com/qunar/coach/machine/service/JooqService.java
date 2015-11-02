package com.qunar.coach.machine.service;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by niuli on 15-6-19.
 */
@Service
public abstract class JooqService {

    @Autowired
    private DSLContext context;

    protected DSLContext getContext() {
        return context;
    }

    protected <R extends Record> R fetchOneByCondition(Table<R> table,
        Condition condition) {
        return context.selectFrom(table).where(condition).fetchOne();
    }

    protected <R extends Record> Result<R> fetchByCondition(Table<R> table,
        Condition condition) {
        return context.selectFrom(table).where(condition).fetch();
    }
}
