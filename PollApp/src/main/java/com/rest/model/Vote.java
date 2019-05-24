package com.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VOTE_ID")
	private long id;

	/*#This fom Option*/
	@ManyToOne
	@JoinColumn(name = "OPTION_ID")
	private Option option;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

}