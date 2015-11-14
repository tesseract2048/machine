/**
 * This class is generated by jOOQ
 */
package com.qunar.coach.machine.dao.model;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.4" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Coach extends org.jooq.impl.SchemaImpl {

	private static final long serialVersionUID = -1712282845;

	/**
	 * The singleton instance of <code>coach</code>
	 */
	public static final Coach COACH = new Coach();

	/**
	 * No further instances allowed
	 */
	private Coach() {
		super("coach");
	}

	@Override
	public final java.util.List<org.jooq.Table<?>> getTables() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final java.util.List<org.jooq.Table<?>> getTables0() {
		return java.util.Arrays.<org.jooq.Table<?>>asList(
			com.qunar.coach.machine.dao.model.tables.City.CITY,
			com.qunar.coach.machine.dao.model.tables.IdentityCard.IDENTITY_CARD,
			com.qunar.coach.machine.dao.model.tables.Machine.MACHINE,
			com.qunar.coach.machine.dao.model.tables.MachineInfo.MACHINE_INFO,
			com.qunar.coach.machine.dao.model.tables.Province.PROVINCE,
			com.qunar.coach.machine.dao.model.tables.Station.STATION,
			com.qunar.coach.machine.dao.model.tables.TicketPrintInfo.TICKET_PRINT_INFO);
	}
}
