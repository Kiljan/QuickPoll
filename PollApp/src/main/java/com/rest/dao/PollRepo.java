package com.rest.dao;

import java.util.List;

import com.rest.model.Poll;

public interface PollRepo {
	
	public List<Poll> getAllPolls();
	public void savePoll(Poll poll);
	public List<Poll> getPollList(long id);
	public Poll getPoll(long id);
	public void updatePoll(Poll poll);
	public void deletePoll(long id);
}
