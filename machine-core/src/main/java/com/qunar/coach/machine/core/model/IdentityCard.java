package com.qunar.coach.machine.core.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by niuli on 15-10-20.
 */
@Data
@Deprecated
public class IdentityCard {
    //TODO: use lombok to save code scale.

    protected int id;

    protected String cardId;

    protected String name;

    protected String nation;

    protected Date birthDate;

    protected String address;

    //TODO: 改为enum
    protected int sex;

    // 数据生成时间
    protected Date createTime;

    // 数据修改时间
    protected Date modifyTime;
}
