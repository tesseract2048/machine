/**
 * This class is generated by jOOQ
 */
package com.qunar.coach.machine.dao.model.tables.pojos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.4" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Machine implements java.io.Serializable {

	private static final long serialVersionUID = -825358893;

	private java.lang.Integer                                id;
	private java.lang.String                                 machinePrintMode;
	private java.lang.String                                 ip;
	private java.lang.String                                 province;
	private java.lang.String                                 city;
	private java.lang.String                                 stationInfo;
	private com.qunar.coach.machine.core.model.MachineStatus login;
	private java.lang.Byte                                   groupNumber;
	private java.lang.String                                 ticketMode;
	private java.lang.Integer                                printTimes;
	private java.lang.Integer                                sucTimes;
	private java.lang.Integer                                failedTimes;
	private java.lang.Integer                                scanSucTimes;
	private java.lang.Integer                                scanFailedTimes;
	private java.lang.Integer                                paperNumber;
	private java.lang.Integer                                paperUsed;
	private java.lang.String                                 userId;
	private java.lang.String                                 version;
	private java.lang.String                                 passWord;
	private java.sql.Timestamp                               modifyTime;
	private java.sql.Timestamp                               createTime;
	private java.sql.Timestamp                               syncTime;
	private java.lang.String                                 deviceId;
	private java.lang.Integer                                sequenceNumber;
	private java.lang.Integer                                maintenance;

	public Machine() {}

	public Machine(
		java.lang.Integer                                id,
		java.lang.String                                 machinePrintMode,
		java.lang.String                                 ip,
		java.lang.String                                 province,
		java.lang.String                                 city,
		java.lang.String                                 stationInfo,
		com.qunar.coach.machine.core.model.MachineStatus login,
		java.lang.Byte                                   groupNumber,
		java.lang.String                                 ticketMode,
		java.lang.Integer                                printTimes,
		java.lang.Integer                                sucTimes,
		java.lang.Integer                                failedTimes,
		java.lang.Integer                                scanSucTimes,
		java.lang.Integer                                scanFailedTimes,
		java.lang.Integer                                paperNumber,
		java.lang.Integer                                paperUsed,
		java.lang.String                                 userId,
		java.lang.String                                 version,
		java.lang.String                                 passWord,
		java.sql.Timestamp                               modifyTime,
		java.sql.Timestamp                               createTime,
		java.sql.Timestamp                               syncTime,
		java.lang.String                                 deviceId,
		java.lang.Integer                                sequenceNumber,
		java.lang.Integer                                maintenance
	) {
		this.id = id;
		this.machinePrintMode = machinePrintMode;
		this.ip = ip;
		this.province = province;
		this.city = city;
		this.stationInfo = stationInfo;
		this.login = login;
		this.groupNumber = groupNumber;
		this.ticketMode = ticketMode;
		this.printTimes = printTimes;
		this.sucTimes = sucTimes;
		this.failedTimes = failedTimes;
		this.scanSucTimes = scanSucTimes;
		this.scanFailedTimes = scanFailedTimes;
		this.paperNumber = paperNumber;
		this.paperUsed = paperUsed;
		this.userId = userId;
		this.version = version;
		this.passWord = passWord;
		this.modifyTime = modifyTime;
		this.createTime = createTime;
		this.syncTime = syncTime;
		this.deviceId = deviceId;
		this.sequenceNumber = sequenceNumber;
		this.maintenance = maintenance;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public Machine setId(java.lang.Integer id) {
		this.id = id;
		return this;
	}

	public java.lang.String getMachinePrintMode() {
		return this.machinePrintMode;
	}

	public Machine setMachinePrintMode(java.lang.String machinePrintMode) {
		this.machinePrintMode = machinePrintMode;
		return this;
	}

	public java.lang.String getIp() {
		return this.ip;
	}

	public Machine setIp(java.lang.String ip) {
		this.ip = ip;
		return this;
	}

	public java.lang.String getProvince() {
		return this.province;
	}

	public Machine setProvince(java.lang.String province) {
		this.province = province;
		return this;
	}

	public java.lang.String getCity() {
		return this.city;
	}

	public Machine setCity(java.lang.String city) {
		this.city = city;
		return this;
	}

	public java.lang.String getStationInfo() {
		return this.stationInfo;
	}

	public Machine setStationInfo(java.lang.String stationInfo) {
		this.stationInfo = stationInfo;
		return this;
	}

	public com.qunar.coach.machine.core.model.MachineStatus getLogin() {
		return this.login;
	}

	public Machine setLogin(com.qunar.coach.machine.core.model.MachineStatus login) {
		this.login = login;
		return this;
	}

	public java.lang.Byte getGroupNumber() {
		return this.groupNumber;
	}

	public Machine setGroupNumber(java.lang.Byte groupNumber) {
		this.groupNumber = groupNumber;
		return this;
	}

	public java.lang.String getTicketMode() {
		return this.ticketMode;
	}

	public Machine setTicketMode(java.lang.String ticketMode) {
		this.ticketMode = ticketMode;
		return this;
	}

	public java.lang.Integer getPrintTimes() {
		return this.printTimes;
	}

	public Machine setPrintTimes(java.lang.Integer printTimes) {
		this.printTimes = printTimes;
		return this;
	}

	public java.lang.Integer getSucTimes() {
		return this.sucTimes;
	}

	public Machine setSucTimes(java.lang.Integer sucTimes) {
		this.sucTimes = sucTimes;
		return this;
	}

	public java.lang.Integer getFailedTimes() {
		return this.failedTimes;
	}

	public Machine setFailedTimes(java.lang.Integer failedTimes) {
		this.failedTimes = failedTimes;
		return this;
	}

	public java.lang.Integer getScanSucTimes() {
		return this.scanSucTimes;
	}

	public Machine setScanSucTimes(java.lang.Integer scanSucTimes) {
		this.scanSucTimes = scanSucTimes;
		return this;
	}

	public java.lang.Integer getScanFailedTimes() {
		return this.scanFailedTimes;
	}

	public Machine setScanFailedTimes(java.lang.Integer scanFailedTimes) {
		this.scanFailedTimes = scanFailedTimes;
		return this;
	}

	public java.lang.Integer getPaperNumber() {
		return this.paperNumber;
	}

	public Machine setPaperNumber(java.lang.Integer paperNumber) {
		this.paperNumber = paperNumber;
		return this;
	}

	public java.lang.Integer getPaperUsed() {
		return this.paperUsed;
	}

	public Machine setPaperUsed(java.lang.Integer paperUsed) {
		this.paperUsed = paperUsed;
		return this;
	}

	public java.lang.String getUserId() {
		return this.userId;
	}

	public Machine setUserId(java.lang.String userId) {
		this.userId = userId;
		return this;
	}

	public java.lang.String getVersion() {
		return this.version;
	}

	public Machine setVersion(java.lang.String version) {
		this.version = version;
		return this;
	}

	public java.lang.String getPassWord() {
		return this.passWord;
	}

	public Machine setPassWord(java.lang.String passWord) {
		this.passWord = passWord;
		return this;
	}

	public java.sql.Timestamp getModifyTime() {
		return this.modifyTime;
	}

	public Machine setModifyTime(java.sql.Timestamp modifyTime) {
		this.modifyTime = modifyTime;
		return this;
	}

	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}

	public Machine setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
		return this;
	}

	public java.sql.Timestamp getSyncTime() {
		return this.syncTime;
	}

	public Machine setSyncTime(java.sql.Timestamp syncTime) {
		this.syncTime = syncTime;
		return this;
	}

	public java.lang.String getDeviceId() {
		return this.deviceId;
	}

	public Machine setDeviceId(java.lang.String deviceId) {
		this.deviceId = deviceId;
		return this;
	}

	public java.lang.Integer getSequenceNumber() {
		return this.sequenceNumber;
	}

	public Machine setSequenceNumber(java.lang.Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
		return this;
	}

	public java.lang.Integer getMaintenance() {
		return this.maintenance;
	}

	public Machine setMaintenance(java.lang.Integer maintenance) {
		this.maintenance = maintenance;
		return this;
	}
}