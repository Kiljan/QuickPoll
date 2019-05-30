package com.rest.dao;

import com.rest.model.Vote;

public interface VoteDao {

	public void saveVote(Vote vote);
	public Iterable<Vote> findByPoll(long pollId);
	
}
