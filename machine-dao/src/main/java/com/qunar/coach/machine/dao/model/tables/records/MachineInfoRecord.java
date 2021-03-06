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
public class MachineInfoRecord extends org.jooq.impl.UpdatableRecordImpl<com.qunar.coach.machine.dao.model.tables.records.MachineInfoRecord> implements org.jooq.Record3<java.lang.Integer, java.lang.Long, java.lang.Integer> {

	private static final long serialVersionUID = 338415016;

	/**
	 * Setter for <code>machine.machine_info.id</code>.
	 */
	public MachineInfoRecord setId(java.lang.Integer value) {
		setValue(0, value);
		return this;
	}

	/**
	 * Getter for <code>machine.machine_info.id</code>.
	 */
	public java.lang.Integer getId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>machine.machine_info.machine_id</code>.
	 */
	public MachineInfoRecord setMachineId(java.lang.Long value) {
		setValue(1, value);
		return this;
	}

	/**
	 * Getter for <code>machine.machine_info.machine_id</code>.
	 */
	public java.lang.Long getMachineId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>machine.machine_info.print_mode</code>.
	 */
	public MachineInfoRecord setPrintMode(java.lang.Integer value) {
		setValue(2, value);
		return this;
	}

	/**
	 * Getter for <code>machine.machine_info.print_mode</code>.
	 */
	public java.lang.Integer getPrintMode() {
		return (java.lang.Integer) getValue(2);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Integer> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Integer, java.lang.Long, java.lang.Integer> fieldsRow() {
		return (org.jooq.Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Integer, java.lang.Long, java.lang.Integer> valuesRow() {
		return (org.jooq.Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return com.qunar.coach.machine.dao.model.tables.MachineInfo.MACHINE_INFO.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return com.qunar.coach.machine.dao.model.tables.MachineInfo.MACHINE_INFO.MACHINE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field3() {
		return com.qunar.coach.machine.dao.model.tables.MachineInfo.MACHINE_INFO.PRINT_MODE;
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
	public java.lang.Long value2() {
		return getMachineId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value3() {
		return getPrintMode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MachineInfoRecord value1(java.lang.Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MachineInfoRecord value2(java.lang.Long value) {
		setMachineId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MachineInfoRecord value3(java.lang.Integer value) {
		setPrintMode(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MachineInfoRecord values(java.lang.Integer value1, java.lang.Long value2, java.lang.Integer value3) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached MachineInfoRecord
	 */
	public MachineInfoRecord() {
		super(com.qunar.coach.machine.dao.model.tables.MachineInfo.MACHINE_INFO);
	}

	/**
	 * Create a detached, initialised MachineInfoRecord
	 */
	public MachineInfoRecord(java.lang.Integer id, java.lang.Long machineId, java.lang.Integer printMode) {
		super(com.qunar.coach.machine.dao.model.tables.MachineInfo.MACHINE_INFO);

		setValue(0, id);
		setValue(1, machineId);
		setValue(2, printMode);
	}
}
