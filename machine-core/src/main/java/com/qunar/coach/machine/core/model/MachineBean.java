package com.qunar.coach.machine.core.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by niuli on 15-10-20.
 */
@Data
@Deprecated
public class MachineBean {
    //TODO: use lombok to save code scale.

    protected int id;

    // 机器名
    protected String machineId;

    // 机器名Md5
    protected String machineIdMd5;

    // 由于票样不同,机器打印模式, 每个车站的打印模式有可能不同.
    protected String machinePrintMode;

    // 机器IP. 预留
    protected String ip;

    // 省
    protected String province;

    // 市
    protected String city;

    // 车站信息
    protected String stationInfo;

    // 登录状态, 0为未登录, 1为已登录, -1 为登录失败.
    protected int login;

    // 上次心跳时间
    protected Date lastHeartBeat;

    // 版本号
    protected String versionNumber;

    // 注册时间
    protected  Date registerTime;

    // 分组组号
    protected int groupNumber;

    // 车票模式
    protected String ticketMode;

    // 打印次数
    protected int printTimes;

    // 出票成功次数
    protected int sucTimes;

    // 出票失败次数
    protected int failedTime;

    // 总加纸量
    protected int totalPaperNumber;

    // 总用纸数量
    protected int totolPaperUsed;

    // 本次加纸,纸张剩余量
    protected int paperNumber;

    // 本次加纸之后, 用纸数量
    protected int paperUsed;

    // 远程登录机器用户名
    protected String userId;

    // 远程登录机器密码
    protected String passWord;

    // 数据生成时间
    protected Date createTime;

    // 数据修改时间
    protected Date modifyTime;
}
