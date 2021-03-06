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
public class StationDao extends org.jooq.impl.DAOImpl<com.qunar.coach.machine.dao.model.tables.records.StationRecord, com.qunar.coach.machine.dao.model.tables.pojos.Station, java.lang.Integer> {

	/**
	 * Create a new StationDao without any configuration
	 */
	public StationDao() {
		super(com.qunar.coach.machine.dao.model.tables.Station.STATION, com.qunar.coach.machine.dao.model.tables.pojos.Station.class);
	}

	/**
	 * Create a new StationDao with an attached configuration
	 */
	public StationDao(org.jooq.Configuration configuration) {
		super(com.qunar.coach.machine.dao.model.tables.Station.STATION, com.qunar.coach.machine.dao.model.tables.pojos.Station.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Integer getId(com.qunar.coach.machine.dao.model.tables.pojos.Station object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<com.qunar.coach.machine.dao.model.tables.pojos.Station> fetchById(java.lang.Integer... values) {
		return fetch(com.qunar.coach.machine.dao.model.tables.Station.STATION.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public com.qunar.coach.machine.dao.model.tables.pojos.Station fetchOneById(java.lang.Integer value) {
		return fetchOne(com.qunar.coach.machine.dao.model.tables.Station.STATION.ID, value);
	}

	/**
	 * Fetch records that have <code>station_name IN (values)</code>
	 */
	public java.util.List<com.qunar.coach.machine.dao.model.tables.pojos.Station> fetchByStationName(java.lang.String... values) {
		return fetch(com.qunar.coach.machine.dao.model.tables.Station.STATION.STATION_NAME, values);
	}

	/**
	 * Fetch records that have <code>city_id IN (values)</code>
	 */
	public java.util.List<com.qunar.coach.machine.dao.model.tables.pojos.Station> fetchByCityId(java.lang.Integer... values) {
		return fetch(com.qunar.coach.machine.dao.model.tables.Station.STATION.CITY_ID, values);
	}
}
