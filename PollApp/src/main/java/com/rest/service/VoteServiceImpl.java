package com.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.dao.VoteDao;
import com.rest.model.Poll;
import com.rest.model.Vote;

@Service
@Transactional
public class VoteServiceImpl implements VoteService{

	@Autowired
	private VoteDao voteDao;
	
	@Override
	public void saveVote(Vote vote) {
		voteDao.saveVote(vote);		
	}

	@Override
	public Iterable<Vote> findByPoll(long pollId) {
		return voteDao.findByPoll(pollId);
	}

}
