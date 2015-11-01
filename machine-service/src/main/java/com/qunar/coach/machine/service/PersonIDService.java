package com.qunar.coach.machine.service;

import com.qunar.coach.machine.dao.model.tables.pojos.IdentityCard;

/**
 * Created by zhangyunfan on 15-10-26.
 */
public interface PersonIDService {
    public int addPerson(String cardId, String name, String nation);

    public int addPerson(IdentityCard identityCard);
}
