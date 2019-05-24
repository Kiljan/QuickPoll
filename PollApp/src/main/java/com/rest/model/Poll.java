package com.rest.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "polls")
public class Poll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POLL_ID")
	private long id;
	
	@Column(name = "QUESTION")
	private String question;
	
	/*One Poll with many Options, mappedBy = "poll" is name of Poll Object in Option calss. I tag it in Class Option as #This*/
	@OneToMany(mappedBy = "poll")
	private Set<Option> options;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Set<Option> getOptions() {
		return options;
	}

	public void setOptions(Set<Option> options) {
		this.options = options;
	}
	
}
