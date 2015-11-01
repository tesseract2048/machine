package com.qunar.coach.machine.service.impl;

import static com.qunar.coach.machine.dao.model.tables.IdentityCard.IDENTITY_CARD;

import com.qunar.coach.machine.dao.model.tables.daos.IdentityCardDao;
import com.qunar.coach.machine.dao.model.tables.pojos.IdentityCard;
import com.qunar.coach.machine.dao.model.tables.records.IdentityCardRecord;
import com.qunar.coach.machine.service.JooqService;
import com.qunar.coach.machine.service.PersonIDService;
import com.qunar.coach.machine.service.utils.RecordMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangyunfan on 15-10-26.
 */
@Service
public class PersonIDServiceImpl extends JooqService implements PersonIDService {
    @Autowired
    private IdentityCardDao identityCardDao;

    @Override
    public int addPerson(String cardId, String name, String nation) {
        IdentityCardRecord identityCard = new IdentityCardRecord();

        identityCard.setCardId(cardId);
        identityCard.setName(name);
        identityCard.setNation(nation);

        int ret = getContext().insertInto(IDENTITY_CARD).set(identityCard).onDuplicateKeyIgnore().execute();
        return 0;
    }

    @Override
    public int addPerson(IdentityCard identityCard) {
        IdentityCardRecord identityCardRecord = toRecord(identityCard);

        return getContext().insertInto(IDENTITY_CARD).set(identityCardRecord).onDuplicateKeyIgnore().execute();
    }

    private IdentityCardRecord toRecord(IdentityCard identityCard) {
        return RecordMapperUtils.mapObject(identityCard, IdentityCardRecord.class);
    }
}
