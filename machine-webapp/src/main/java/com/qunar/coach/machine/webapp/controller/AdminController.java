package com.qunar.coach.machine.webapp.controller;

import com.qunar.coach.machine.core.model.APIResponse;
import com.qunar.coach.machine.dao.model.Machine;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.UpdatableRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by niuli on 15-10-21.
 */
@Controller
public class AdminController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private DSLContext context;

    private Map<String, Table> tables;

    @PostConstruct
    public void init() {
        tables = new HashMap<>();
        for (Table<?> table : Machine.MACHINE.getTables()) {
            tables.put(table.getName().toLowerCase(), table);
        }
    }

    @RequestMapping("/api/v1/admin/{model}")
    public APIResponse<List<Map>> listEntity(
            @PathVariable(value = "model") String model) {
        assert (tables != null);
        List<Map> records = context.selectFrom(tables.get(model.toLowerCase())).fetchMaps();

        return APIResponse.success(records);
    }

    @RequestMapping(value = "/api/v1/admin/{model}/{id}", method = RequestMethod.GET)
    public APIResponse<Map> getEntity(
            @PathVariable(value = "model") String model,
            @PathVariable(value = "id") Integer id) {
        assert (tables != null);
        Table table = tables.get(model.toLowerCase());
        Map record = context.selectFrom(table)
                .where(table.getIdentity().getField().eq(id)).fetchOneMap();

        return APIResponse.success(record);

    }

    @RequestMapping(value = "/api/v1/admin/{model}/{id}", method = RequestMethod.DELETE)
    public APIResponse<Object> removeEntity(
            @PathVariable(value = "model") String model,
            @PathVariable(value = "id") Integer id) {
        assert (tables != null);
        Table table = tables.get(model.toLowerCase());
        int rowsAffected = context.delete(table).where(table.getIdentity().getField().eq(id)).execute();

        return APIResponse.success();

    }

    @RequestMapping(value = "/api/v1/admin/{model}", method = RequestMethod.PUT)
    public APIResponse<Object> newEntity(
            @PathVariable(value = "model") String model,
            HttpServletRequest request) {
        assert (tables != null);
        Map parameters = request.getParameterMap();
        Table table = tables.get(model.toLowerCase());
        Record record = context.newRecord(table);
        for (Field field : table.fields()) {
            if (parameters.containsKey(field.getName())) {
                record.setValue(field, parameters.get(field.getName()));
            }
        }
        int rowsAffected = ((UpdatableRecord) record).insert();
        return APIResponse.success();

    }

    @RequestMapping(value = "/api/v1/admin/{model}/{id}", method = RequestMethod.POST)
    public APIResponse<Object> modifyEntity(
            @PathVariable(value = "model") String model,
            @PathVariable(value = "id") Integer id,
            HttpServletRequest request) {
        assert (tables != null);
        Table table = tables.get(model.toLowerCase());
        Record record = context.selectFrom(table)
                .where(table.getIdentity().getField().eq(id)).fetchOne();
        Map parameters = request.getParameterMap();
        for (Field field : table.fields()) {
            if (parameters.containsKey(field.getName())) {
                record.setValue(field, parameters.get(field.getName()));
            }
        }
        int rowsAffected = ((UpdatableRecord) record).update();

        return APIResponse.success();

    }

}
