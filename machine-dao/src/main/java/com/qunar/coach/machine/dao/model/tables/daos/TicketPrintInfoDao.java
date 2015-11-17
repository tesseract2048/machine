/**
 * This class is generated by jOOQ
 */
package com.qunar.coach.machine.dao.model.tables.daos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.4" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TicketPrintInfoDao extends org.jooq.impl.DAOImpl<com.qunar.coach.machine.dao.model.tables.records.TicketPrintInfoRecord, com.qunar.coach.machine.dao.model.tables.pojos.TicketPrintInfo, java.lang.Integer> {

	/**
	 * Create a new TicketPrintInfoDao without any configuration
	 */
	public TicketPrintInfoDao() {
		super(com.qunar.coach.machine.dao.model.tables.TicketPrintInfo.TICKET_PRINT_INFO, com.qunar.coach.machine.dao.model.tables.pojos.TicketPrintInfo.class);
	}

	/**
	 * Create a new TicketPrintInfoDao with an attached configuration
	 */
	public TicketPrintInfoDao(org.jooq.Configuration configuration) {
		super(com.qunar.coach.machine.dao.model.tables.TicketPrintInfo.TICKET_PRINT_INFO, com.qunar.coach.machine.dao.model.tables.pojos.TicketPrintInfo.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Integer getId(com.qunar.coach.machine.dao.model.tables.pojos.TicketPrintInfo object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<com.qunar.coach.machine.dao.model.tables.pojos.TicketPrintInfo> fetchById(java.lang.Integer... values) {
		return fetch(com.qunar.coach.machine.dao.model.tables.TicketPrintInfo.TICKET_PRINT_INFO.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public com.qunar.coach.machine.dao.model.tables.pojos.TicketPrintInfo fetchOneById(java.lang.Integer value) {
		return fetchOne(com.qunar.coach.machine.dao.model.tables.TicketPrintInfo.TICKET_PRINT_INFO.ID, value);
	}

	/**
	 * Fetch records that have <code>ticket_id IN (values)</code>
	 */
	public java.util.List<com.qunar.coach.machine.dao.model.tables.pojos.TicketPrintInfo> fetchByTicketId(java.lang.String... values) {
		return fetch(com.qunar.coach.machine.dao.model.tables.TicketPrintInfo.TICKET_PRINT_INFO.TICKET_ID, values);
	}

	/**
	 * Fetch a unique record that has <code>ticket_id = value</code>
	 */
	public com.qunar.coach.machine.dao.model.tables.pojos.TicketPrintInfo fetchOneByTicketId(java.lang.String value) {
		return fetchOne(com.qunar.coach.machine.dao.model.tables.TicketPrintInfo.TICKET_PRINT_INFO.TICKET_ID, value);
	}

	/**
	 * Fetch records that have <code>status IN (values)</code>
	 */
	public java.util.List<com.qunar.coach.machine.dao.model.tables.pojos.TicketPrintInfo> fetchByStatus(com.qunar.coach.machine.core.TicketStatus... values) {
		return fetch(com.qunar.coach.machine.dao.model.tables.TicketPrintInfo.TICKET_PRINT_INFO.STATUS, values);
	}

	/**
	 * Fetch records that have <code>print_machine_id IN (values)</code>
	 */
	public java.util.List<com.qunar.coach.machine.dao.model.tables.pojos.TicketPrintInfo> fetchByPrintMachineId(java.lang.String... values) {
		return fetch(com.qunar.coach.machine.dao.model.tables.TicketPrintInfo.TICKET_PRINT_INFO.PRINT_MACHINE_ID, values);
	}

	/**
	 * Fetch records that have <code>modify_time IN (values)</code>
	 */
	public java.util.List<com.qunar.coach.machine.dao.model.tables.pojos.TicketPrintInfo> fetchByModifyTime(java.sql.Timestamp... values) {
		return fetch(com.qunar.coach.machine.dao.model.tables.TicketPrintInfo.TICKET_PRINT_INFO.MODIFY_TIME, values);
	}

	/**
	 * Fetch records that have <code>create_time IN (values)</code>
	 */
	public java.util.List<com.qunar.coach.machine.dao.model.tables.pojos.TicketPrintInfo> fetchByCreateTime(java.sql.Timestamp... values) {
		return fetch(com.qunar.coach.machine.dao.model.tables.TicketPrintInfo.TICKET_PRINT_INFO.CREATE_TIME, values);
	}

	/**
	 * Fetch records that have <code>print_id IN (values)</code>
	 */
	public java.util.List<com.qunar.coach.machine.dao.model.tables.pojos.TicketPrintInfo> fetchByPrintId(java.lang.String... values) {
		return fetch(com.qunar.coach.machine.dao.model.tables.TicketPrintInfo.TICKET_PRINT_INFO.PRINT_ID, values);
	}
}
