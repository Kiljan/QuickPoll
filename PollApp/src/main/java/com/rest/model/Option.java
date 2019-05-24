package com.rest.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "opt")
public class Option {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OPTION_ID")
	private long id;
	
	@Column(name = "OPTION_VALUE")
	private String value;
	
	/*One Options with many Votes, mappedBy = "option" is name of Vote Object in Vote calss. I tag it in Class Vote as #This*/
	@OneToMany(mappedBy = "option")
	private Set<Vote> votes;
	
	/*#This fom Poll*/
	@ManyToOne
	@JoinColumn(name = "POLL_ID")
	private Poll poll;
	
	public Option () {
	}
	
	public Option(Poll poll) {
		this.poll = poll;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Poll getPoll() {
		return poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}
	
}
