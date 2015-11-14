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
public class IdentityCard implements java.io.Serializable {

	private static final long serialVersionUID = -609549263;

	private java.lang.Integer  id;
	private java.lang.String   cardId;
	private java.lang.String   name;
	private java.lang.String   nation;
	private java.sql.Timestamp birthDate;
	private java.lang.String   address;
	private java.lang.Byte     sex;
	private java.sql.Timestamp modifyTime;
	private java.sql.Timestamp createTime;

	public IdentityCard() {}

	public IdentityCard(
		java.lang.Integer  id,
		java.lang.String   cardId,
		java.lang.String   name,
		java.lang.String   nation,
		java.sql.Timestamp birthDate,
		java.lang.String   address,
		java.lang.Byte     sex,
		java.sql.Timestamp modifyTime,
		java.sql.Timestamp createTime
	) {
		this.id = id;
		this.cardId = cardId;
		this.name = name;
		this.nation = nation;
		this.birthDate = birthDate;
		this.address = address;
		this.sex = sex;
		this.modifyTime = modifyTime;
		this.createTime = createTime;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public IdentityCard setId(java.lang.Integer id) {
		this.id = id;
		return this;
	}

	public java.lang.String getCardId() {
		return this.cardId;
	}

	public IdentityCard setCardId(java.lang.String cardId) {
		this.cardId = cardId;
		return this;
	}

	public java.lang.String getName() {
		return this.name;
	}

	public IdentityCard setName(java.lang.String name) {
		this.name = name;
		return this;
	}

	public java.lang.String getNation() {
		return this.nation;
	}

	public IdentityCard setNation(java.lang.String nation) {
		this.nation = nation;
		return this;
	}

	public java.sql.Timestamp getBirthDate() {
		return this.birthDate;
	}

	public IdentityCard setBirthDate(java.sql.Timestamp birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	public java.lang.String getAddress() {
		return this.address;
	}

	public IdentityCard setAddress(java.lang.String address) {
		this.address = address;
		return this;
	}

	public java.lang.Byte getSex() {
		return this.sex;
	}

	public IdentityCard setSex(java.lang.Byte sex) {
		this.sex = sex;
		return this;
	}

	public java.sql.Timestamp getModifyTime() {
		return this.modifyTime;
	}

	public IdentityCard setModifyTime(java.sql.Timestamp modifyTime) {
		this.modifyTime = modifyTime;
		return this;
	}

	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}

	public IdentityCard setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
		return this;
	}
}
