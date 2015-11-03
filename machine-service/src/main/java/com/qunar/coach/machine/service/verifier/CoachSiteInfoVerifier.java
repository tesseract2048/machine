package com.qunar.coach.machine.service.verifier;

import com.qunar.coach.machine.core.model.TicketSiteInfo;

/**
 * Created by niuli on 15-10-30.
 */
public class CoachSiteInfoVerifier implements IVerifier<TicketSiteInfo>{

    @Override
    public boolean verify(TicketSiteInfo ticketSiteInfo) {
        return true;
    }
}
