package com.rest.service;

import com.rest.model.Vote;

public interface VoteService {
	public void saveVote(Vote vote);
	public Iterable<Vote> findByPoll(long pollId);
}
