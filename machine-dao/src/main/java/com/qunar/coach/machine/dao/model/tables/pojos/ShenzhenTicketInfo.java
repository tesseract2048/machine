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
public class ShenzhenTicketInfo implements java.io.Serializable {

	private static final long serialVersionUID = -1307967601;

	private java.lang.Integer    id;
	private java.lang.String     ticketNumber;
	private java.lang.String     line;
	private java.lang.String     takePlace;
	private java.lang.String     destination;
	private java.sql.Timestamp   startTime;
	private java.lang.String     coachType;
	private java.lang.String     seatNumber;
	private java.math.BigDecimal price;
	private java.lang.String     checkPortNumber;
	private java.lang.String     sellTicketPlace;
	private java.lang.String     coachNumber;
	private java.lang.String     ticketId;
	private java.lang.String     passengerName;
	private java.lang.String     cardId;
	private java.sql.Timestamp   modifyTime;
	private java.sql.Timestamp   createTime;

	public ShenzhenTicketInfo() {}

	public ShenzhenTicketInfo(
		java.lang.Integer    id,
		java.lang.String     ticketNumber,
		java.lang.String     line,
		java.lang.String     takePlace,
		java.lang.String     destination,
		java.sql.Timestamp   startTime,
		java.lang.String     coachType,
		java.lang.String     seatNumber,
		java.math.BigDecimal price,
		java.lang.String     checkPortNumber,
		java.lang.String     sellTicketPlace,
		java.lang.String     coachNumber,
		java.lang.String     ticketId,
		java.lang.String     passengerName,
		java.lang.String     cardId,
		java.sql.Timestamp   modifyTime,
		java.sql.Timestamp   createTime
	) {
		this.id = id;
		this.ticketNumber = ticketNumber;
		this.line = line;
		this.takePlace = takePlace;
		this.destination = destination;
		this.startTime = startTime;
		this.coachType = coachType;
		this.seatNumber = seatNumber;
		this.price = price;
		this.checkPortNumber = checkPortNumber;
		this.sellTicketPlace = sellTicketPlace;
		this.coachNumber = coachNumber;
		this.ticketId = ticketId;
		this.passengerName = passengerName;
		this.cardId = cardId;
		this.modifyTime = modifyTime;
		this.createTime = createTime;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public ShenzhenTicketInfo setId(java.lang.Integer id) {
		this.id = id;
		return this;
	}

	public java.lang.String getTicketNumber() {
		return this.ticketNumber;
	}

	public ShenzhenTicketInfo setTicketNumber(java.lang.String ticketNumber) {
		this.ticketNumber = ticketNumber;
		return this;
	}

	public java.lang.String getLine() {
		return this.line;
	}

	public ShenzhenTicketInfo setLine(java.lang.String line) {
		this.line = line;
		return this;
	}

	public java.lang.String getTakePlace() {
		return this.takePlace;
	}

	public ShenzhenTicketInfo setTakePlace(java.lang.String takePlace) {
		this.takePlace = takePlace;
		return this;
	}

	public java.lang.String getDestination() {
		return this.destination;
	}

	public ShenzhenTicketInfo setDestination(java.lang.String destination) {
		this.destination = destination;
		return this;
	}

	public java.sql.Timestamp getStartTime() {
		return this.startTime;
	}

	public ShenzhenTicketInfo setStartTime(java.sql.Timestamp startTime) {
		this.startTime = startTime;
		return this;
	}

	public java.lang.String getCoachType() {
		return this.coachType;
	}

	public ShenzhenTicketInfo setCoachType(java.lang.String coachType) {
		this.coachType = coachType;
		return this;
	}

	public java.lang.String getSeatNumber() {
		return this.seatNumber;
	}

	public ShenzhenTicketInfo setSeatNumber(java.lang.String seatNumber) {
		this.seatNumber = seatNumber;
		return this;
	}

	public java.math.BigDecimal getPrice() {
		return this.price;
	}

	public ShenzhenTicketInfo setPrice(java.math.BigDecimal price) {
		this.price = price;
		return this;
	}

	public java.lang.String getCheckPortNumber() {
		return this.checkPortNumber;
	}

	public ShenzhenTicketInfo setCheckPortNumber(java.lang.String checkPortNumber) {
		this.checkPortNumber = checkPortNumber;
		return this;
	}

	public java.lang.String getSellTicketPlace() {
		return this.sellTicketPlace;
	}

	public ShenzhenTicketInfo setSellTicketPlace(java.lang.String sellTicketPlace) {
		this.sellTicketPlace = sellTicketPlace;
		return this;
	}

	public java.lang.String getCoachNumber() {
		return this.coachNumber;
	}

	public ShenzhenTicketInfo setCoachNumber(java.lang.String coachNumber) {
		this.coachNumber = coachNumber;
		return this;
	}

	public java.lang.String getTicketId() {
		return this.ticketId;
	}

	public ShenzhenTicketInfo setTicketId(java.lang.String ticketId) {
		this.ticketId = ticketId;
		return this;
	}

	public java.lang.String getPassengerName() {
		return this.passengerName;
	}

	public ShenzhenTicketInfo setPassengerName(java.lang.String passengerName) {
		this.passengerName = passengerName;
		return this;
	}

	public java.lang.String getCardId() {
		return this.cardId;
	}

	public ShenzhenTicketInfo setCardId(java.lang.String cardId) {
		this.cardId = cardId;
		return this;
	}

	public java.sql.Timestamp getModifyTime() {
		return this.modifyTime;
	}

	public ShenzhenTicketInfo setModifyTime(java.sql.Timestamp modifyTime) {
		this.modifyTime = modifyTime;
		return this;
	}

	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}

	public ShenzhenTicketInfo setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
		return this;
	}
}
