/**
 * This class is generated by jOOQ
 */
package com.qunar.coach.machine.dao.model;

/**
 * This class is generated by jOOQ.
 *
 * A class modelling foreign key relationships between tables of the <code>machine</code> 
 * schema
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.4" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

	// -------------------------------------------------------------------------
	// IDENTITY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.Identity<com.qunar.coach.machine.dao.model.tables.records.CityRecord, java.lang.Integer> IDENTITY_CITY = Identities0.IDENTITY_CITY;
	public static final org.jooq.Identity<com.qunar.coach.machine.dao.model.tables.records.IdentityCardRecord, java.lang.Integer> IDENTITY_IDENTITY_CARD = Identities0.IDENTITY_IDENTITY_CARD;
	public static final org.jooq.Identity<com.qunar.coach.machine.dao.model.tables.records.MachineRecord, java.lang.Integer> IDENTITY_MACHINE = Identities0.IDENTITY_MACHINE;
	public static final org.jooq.Identity<com.qunar.coach.machine.dao.model.tables.records.TicketPrintInfoRecord, java.lang.Integer> IDENTITY_TICKET_PRINT_INFO = Identities0.IDENTITY_TICKET_PRINT_INFO;

	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.UniqueKey<com.qunar.coach.machine.dao.model.tables.records.CityRecord> KEY_CITY_PRIMARY = UniqueKeys0.KEY_CITY_PRIMARY;
	public static final org.jooq.UniqueKey<com.qunar.coach.machine.dao.model.tables.records.IdentityCardRecord> KEY_IDENTITY_CARD_PRIMARY = UniqueKeys0.KEY_IDENTITY_CARD_PRIMARY;
	public static final org.jooq.UniqueKey<com.qunar.coach.machine.dao.model.tables.records.IdentityCardRecord> KEY_IDENTITY_CARD_IDENTITY_CARD_IDX = UniqueKeys0.KEY_IDENTITY_CARD_IDENTITY_CARD_IDX;
	public static final org.jooq.UniqueKey<com.qunar.coach.machine.dao.model.tables.records.MachineRecord> KEY_MACHINE_PRIMARY = UniqueKeys0.KEY_MACHINE_PRIMARY;
	public static final org.jooq.UniqueKey<com.qunar.coach.machine.dao.model.tables.records.MachineRecord> KEY_MACHINE_DEVICE_ID = UniqueKeys0.KEY_MACHINE_DEVICE_ID;
	public static final org.jooq.UniqueKey<com.qunar.coach.machine.dao.model.tables.records.MachineInfoRecord> KEY_MACHINE_INFO_PRIMARY = UniqueKeys0.KEY_MACHINE_INFO_PRIMARY;
	public static final org.jooq.UniqueKey<com.qunar.coach.machine.dao.model.tables.records.StationRecord> KEY_STATION_PRIMARY = UniqueKeys0.KEY_STATION_PRIMARY;
	public static final org.jooq.UniqueKey<com.qunar.coach.machine.dao.model.tables.records.TicketPrintInfoRecord> KEY_TICKET_PRINT_INFO_PRIMARY = UniqueKeys0.KEY_TICKET_PRINT_INFO_PRIMARY;
	public static final org.jooq.UniqueKey<com.qunar.coach.machine.dao.model.tables.records.TicketPrintInfoRecord> KEY_TICKET_PRINT_INFO_TICKET_ID_IDX = UniqueKeys0.KEY_TICKET_PRINT_INFO_TICKET_ID_IDX;

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------


	// -------------------------------------------------------------------------
	// [#1459] distribute members to avoid static initialisers > 64kb
	// -------------------------------------------------------------------------

	private static class Identities0 extends org.jooq.impl.AbstractKeys {
		public static org.jooq.Identity<com.qunar.coach.machine.dao.model.tables.records.CityRecord, java.lang.Integer> IDENTITY_CITY = createIdentity(com.qunar.coach.machine.dao.model.tables.City.CITY, com.qunar.coach.machine.dao.model.tables.City.CITY.ID);
		public static org.jooq.Identity<com.qunar.coach.machine.dao.model.tables.records.IdentityCardRecord, java.lang.Integer> IDENTITY_IDENTITY_CARD = createIdentity(com.qunar.coach.machine.dao.model.tables.IdentityCard.IDENTITY_CARD, com.qunar.coach.machine.dao.model.tables.IdentityCard.IDENTITY_CARD.ID);
		public static org.jooq.Identity<com.qunar.coach.machine.dao.model.tables.records.MachineRecord, java.lang.Integer> IDENTITY_MACHINE = createIdentity(com.qunar.coach.machine.dao.model.tables.Machine.MACHINE, com.qunar.coach.machine.dao.model.tables.Machine.MACHINE.ID);
		public static org.jooq.Identity<com.qunar.coach.machine.dao.model.tables.records.TicketPrintInfoRecord, java.lang.Integer> IDENTITY_TICKET_PRINT_INFO = createIdentity(com.qunar.coach.machine.dao.model.tables.TicketPrintInfo.TICKET_PRINT_INFO, com.qunar.coach.machine.dao.model.tables.TicketPrintInfo.TICKET_PRINT_INFO.ID);
	}

	private static class UniqueKeys0 extends org.jooq.impl.AbstractKeys {
		public static final org.jooq.UniqueKey<com.qunar.coach.machine.dao.model.tables.records.CityRecord> KEY_CITY_PRIMARY = createUniqueKey(com.qunar.coach.machine.dao.model.tables.City.CITY, com.qunar.coach.machine.dao.model.tables.City.CITY.ID);
		public static final org.jooq.UniqueKey<com.qunar.coach.machine.dao.model.tables.records.IdentityCardRecord> KEY_IDENTITY_CARD_PRIMARY = createUniqueKey(com.qunar.coach.machine.dao.model.tables.IdentityCard.IDENTITY_CARD, com.qunar.coach.machine.dao.model.tables.IdentityCard.IDENTITY_CARD.ID);
		public static final org.jooq.UniqueKey<com.qunar.coach.machine.dao.model.tables.records.IdentityCardRecord> KEY_IDENTITY_CARD_IDENTITY_CARD_IDX = createUniqueKey(com.qunar.coach.machine.dao.model.tables.IdentityCard.IDENTITY_CARD, com.qunar.coach.machine.dao.model.tables.IdentityCard.IDENTITY_CARD.CARD_ID);
		public static final org.jooq.UniqueKey<com.qunar.coach.machine.dao.model.tables.records.MachineRecord> KEY_MACHINE_PRIMARY = createUniqueKey(com.qunar.coach.machine.dao.model.tables.Machine.MACHINE, com.qunar.coach.machine.dao.model.tables.Machine.MACHINE.ID);
		public static final org.jooq.UniqueKey<com.qunar.coach.machine.dao.model.tables.records.MachineRecord> KEY_MACHINE_DEVICE_ID = createUniqueKey(com.qunar.coach.machine.dao.model.tables.Machine.MACHINE, com.qunar.coach.machine.dao.model.tables.Machine.MACHINE.DEVICE_ID);
		public static final org.jooq.UniqueKey<com.qunar.coach.machine.dao.model.tables.records.MachineInfoRecord> KEY_MACHINE_INFO_PRIMARY = createUniqueKey(com.qunar.coach.machine.dao.model.tables.MachineInfo.MACHINE_INFO, com.qunar.coach.machine.dao.model.tables.MachineInfo.MACHINE_INFO.ID);
		public static final org.jooq.UniqueKey<com.qunar.coach.machine.dao.model.tables.records.StationRecord> KEY_STATION_PRIMARY = createUniqueKey(com.qunar.coach.machine.dao.model.tables.Station.STATION, com.qunar.coach.machine.dao.model.tables.Station.STATION.ID);
		public static final org.jooq.UniqueKey<com.qunar.coach.machine.dao.model.tables.records.TicketPrintInfoRecord> KEY_TICKET_PRINT_INFO_PRIMARY = createUniqueKey(com.qunar.coach.machine.dao.model.tables.TicketPrintInfo.TICKET_PRINT_INFO, com.qunar.coach.machine.dao.model.tables.TicketPrintInfo.TICKET_PRINT_INFO.ID);
		public static final org.jooq.UniqueKey<com.qunar.coach.machine.dao.model.tables.records.TicketPrintInfoRecord> KEY_TICKET_PRINT_INFO_TICKET_ID_IDX = createUniqueKey(com.qunar.coach.machine.dao.model.tables.TicketPrintInfo.TICKET_PRINT_INFO, com.qunar.coach.machine.dao.model.tables.TicketPrintInfo.TICKET_PRINT_INFO.TICKET_ID);
	}
}
