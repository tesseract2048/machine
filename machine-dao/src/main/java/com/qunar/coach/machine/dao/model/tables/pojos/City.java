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
public class City implements java.io.Serializable {

	private static final long serialVersionUID = 331191769;

	private java.lang.Integer id;
	private java.lang.Integer province;
	private java.lang.String  cityName;

	public City() {}

	public City(
		java.lang.Integer id,
		java.lang.Integer province,
		java.lang.String  cityName
	) {
		this.id = id;
		this.province = province;
		this.cityName = cityName;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public City setId(java.lang.Integer id) {
		this.id = id;
		return this;
	}

	public java.lang.Integer getProvince() {
		return this.province;
	}

	public City setProvince(java.lang.Integer province) {
		this.province = province;
		return this;
	}

	public java.lang.String getCityName() {
		return this.cityName;
	}

	public City setCityName(java.lang.String cityName) {
		this.cityName = cityName;
		return this;
	}
}
