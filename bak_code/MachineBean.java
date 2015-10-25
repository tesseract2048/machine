package com.wandoujia.baobab.bean;

import java.util.Date;

/**
 * Created by niuli on 15-10-20.
 */
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public String getMachineIdMd5() {
        return machineIdMd5;
    }

    public void setMachineIdMd5(String machineIdMd5) {
        this.machineIdMd5 = machineIdMd5;
    }

    public String getMachinePrintMode() {
        return machinePrintMode;
    }

    public void setMachinePrintMode(String machinePrintMode) {
        this.machinePrintMode = machinePrintMode;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStationInfo() {
        return stationInfo;
    }

    public void setStationInfo(String stationInfo) {
        this.stationInfo = stationInfo;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public Date getLastHeartBeat() {
        return lastHeartBeat;
    }

    public void setLastHeartBeat(Date lastHeartBeat) {
        this.lastHeartBeat = lastHeartBeat;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getTicketMode() {
        return ticketMode;
    }

    public void setTicketMode(String ticketMode) {
        this.ticketMode = ticketMode;
    }

    public int getPrintTimes() {
        return printTimes;
    }

    public void setPrintTimes(int printTimes) {
        this.printTimes = printTimes;
    }

    public int getSucTimes() {
        return sucTimes;
    }

    public void setSucTimes(int sucTimes) {
        this.sucTimes = sucTimes;
    }

    public int getFailedTime() {
        return failedTime;
    }

    public void setFailedTime(int failedTime) {
        this.failedTime = failedTime;
    }

    public int getTotalPaperNumber() {
        return totalPaperNumber;
    }

    public void setTotalPaperNumber(int totalPaperNumber) {
        this.totalPaperNumber = totalPaperNumber;
    }

    public int getTotolPaperUsed() {
        return totolPaperUsed;
    }

    public void setTotolPaperUsed(int totolPaperUsed) {
        this.totolPaperUsed = totolPaperUsed;
    }

    public int getPaperNumber() {
        return paperNumber;
    }

    public void setPaperNumber(int paperNumber) {
        this.paperNumber = paperNumber;
    }

    public int getPaperUsed() {
        return paperUsed;
    }

    public void setPaperUsed(int paperUsed) {
        this.paperUsed = paperUsed;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

}
