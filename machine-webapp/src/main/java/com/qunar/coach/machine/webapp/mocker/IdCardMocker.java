package com.qunar.coach.machine.webapp.mocker;

import com.qunar.coach.machine.core.model.IdentityCard;

import java.util.List;

/**
 * Created by niuli on 15-10-30.
 */
public class IdCardMocker implements IMocker<IdentityCard> {

    @Override
    public List<IdentityCard> mockList() {
        return null;
    }

    @Override
    public IdentityCard mock(){
        return null;
    }

    @Override
    public IdentityCard mockAnother(){
        return null;
    }

}

