/**
 * This class is generated by jOOQ
 */
package com.qunar.coach.machine.dao.model.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.4" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Province extends org.jooq.impl.TableImpl<com.qunar.coach.machine.dao.model.tables.records.ProvinceRecord> {

	private static final long serialVersionUID = 1478858159;

	/**
	 * The singleton instance of <code>machine.province</code>
	 */
	public static final com.qunar.coach.machine.dao.model.tables.Province PROVINCE = new com.qunar.coach.machine.dao.model.tables.Province();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.qunar.coach.machine.dao.model.tables.records.ProvinceRecord> getRecordType() {
		return com.qunar.coach.machine.dao.model.tables.records.ProvinceRecord.class;
	}

	/**
	 * The column <code>machine.province.id</code>.
	 */
	public final org.jooq.TableField<com.qunar.coach.machine.dao.model.tables.records.ProvinceRecord, java.lang.Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>machine.province.province</code>.
	 */
	public final org.jooq.TableField<com.qunar.coach.machine.dao.model.tables.records.ProvinceRecord, java.lang.String> PROVINCE_ = createField("province", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * Create a <code>machine.province</code> table reference
	 */
	public Province() {
		this("province", null);
	}

	/**
	 * Create an aliased <code>machine.province</code> table reference
	 */
	public Province(java.lang.String alias) {
		this(alias, com.qunar.coach.machine.dao.model.tables.Province.PROVINCE);
	}

	private Province(java.lang.String alias, org.jooq.Table<com.qunar.coach.machine.dao.model.tables.records.ProvinceRecord> aliased) {
		this(alias, aliased, null);
	}

	private Province(java.lang.String alias, org.jooq.Table<com.qunar.coach.machine.dao.model.tables.records.ProvinceRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.qunar.coach.machine.dao.model.Machine.MACHINE, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.qunar.coach.machine.dao.model.tables.Province as(java.lang.String alias) {
		return new com.qunar.coach.machine.dao.model.tables.Province(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.qunar.coach.machine.dao.model.tables.Province rename(java.lang.String name) {
		return new com.qunar.coach.machine.dao.model.tables.Province(name, null);
	}
}
