package com.univesp.pgf.domain;

import javax.persistence.Entity;

@Entity
public class PgfDid extends Pgf {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String did;

	public PgfDid() {
		super();
	}

	public PgfDid(String did) {
		super();
		this.did = did;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

}
