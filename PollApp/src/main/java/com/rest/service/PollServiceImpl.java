package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.dao.PollRepo;
import com.rest.model.Poll;

@Service
@Transactional
public class PollServiceImpl implements PollService{

	@Autowired
	private PollRepo pollRepo;
	
	@Override
	public List<Poll> getAllPolls() {
		return pollRepo.getAllPolls();
	}

	@Override
	public void savePoll(Poll poll) {
		pollRepo.savePoll(poll);
		
	}

	@Override
	public List<Poll> getPollList(long id) {
		return pollRepo.getPollList(id);
	}

	@Override
	public void updatePoll(Poll poll) {
		pollRepo.updatePoll(poll);
		
	}

	@Override
	public Poll getPoll(long id) {
		return pollRepo.getPoll(id);
	}

	@Override
	public void deletePoll(long id) {
		pollRepo.deletePoll(id);
		
	}

}
