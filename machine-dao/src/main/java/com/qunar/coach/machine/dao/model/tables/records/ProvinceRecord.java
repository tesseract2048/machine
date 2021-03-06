/**
 * This class is generated by jOOQ
 */
package com.qunar.coach.machine.dao.model.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.4" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ProvinceRecord extends org.jooq.impl.TableRecordImpl<com.qunar.coach.machine.dao.model.tables.records.ProvinceRecord> implements org.jooq.Record2<java.lang.Integer, java.lang.String> {

	private static final long serialVersionUID = 1598619166;

	/**
	 * Setter for <code>machine.province.id</code>.
	 */
	public ProvinceRecord setId(java.lang.Integer value) {
		setValue(0, value);
		return this;
	}

	/**
	 * Getter for <code>machine.province.id</code>.
	 */
	public java.lang.Integer getId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>machine.province.province</code>.
	 */
	public ProvinceRecord setProvince(java.lang.String value) {
		setValue(1, value);
		return this;
	}

	/**
	 * Getter for <code>machine.province.province</code>.
	 */
	public java.lang.String getProvince() {
		return (java.lang.String) getValue(1);
	}

	// -------------------------------------------------------------------------
	// Record2 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row2<java.lang.Integer, java.lang.String> fieldsRow() {
		return (org.jooq.Row2) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row2<java.lang.Integer, java.lang.String> valuesRow() {
		return (org.jooq.Row2) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return com.qunar.coach.machine.dao.model.tables.Province.PROVINCE.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return com.qunar.coach.machine.dao.model.tables.Province.PROVINCE.PROVINCE_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value2() {
		return getProvince();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProvinceRecord value1(java.lang.Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProvinceRecord value2(java.lang.String value) {
		setProvince(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProvinceRecord values(java.lang.Integer value1, java.lang.String value2) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached ProvinceRecord
	 */
	public ProvinceRecord() {
		super(com.qunar.coach.machine.dao.model.tables.Province.PROVINCE);
	}

	/**
	 * Create a detached, initialised ProvinceRecord
	 */
	public ProvinceRecord(java.lang.Integer id, java.lang.String province) {
		super(com.qunar.coach.machine.dao.model.tables.Province.PROVINCE);

		setValue(0, id);
		setValue(1, province);
	}
}
