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
public class Province implements java.io.Serializable {

	private static final long serialVersionUID = 914601842;

	private java.lang.Integer id;
	private java.lang.String  province;

	public Province() {}

	public Province(
		java.lang.Integer id,
		java.lang.String  province
	) {
		this.id = id;
		this.province = province;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public Province setId(java.lang.Integer id) {
		this.id = id;
		return this;
	}

	public java.lang.String getProvince() {
		return this.province;
	}

	public Province setProvince(java.lang.String province) {
		this.province = province;
		return this;
	}
}
