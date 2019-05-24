package com.rest.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.model.Option;
import com.rest.model.Poll;

@Repository
public class PollRepoImpl implements PollRepo {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unused")
	private Session getCurentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Poll> getAllPolls() {
		return getCurentSession().createQuery("select P.id, P.question, OP.value from Poll P inner join P.options as OP").list();
	}

	@Override
	public void savePoll(Poll poll) {		
		
		Poll newPoll = poll;	
		
		getCurentSession().save(newPoll);
		
		Set<Option> ops = newPoll.getOptions();
		
		for (Option o : ops) {
			o.setPoll(poll);
			getCurentSession().save(o);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Poll> getPollList(long id) {
		String hql = "select P.id, P.question from Poll P where P.id = :pollId";
		List<Poll> result = getCurentSession().createQuery(hql).setLong("pollId", id).list();
		return result;
	}
	
	@Override
	public Poll getPoll(long id) {
		return (Poll) getCurentSession().get(Poll.class, id);
	}

	@Override
	public void updatePoll(Poll poll) {
		Poll pollToUpdate = getPoll(poll.getId());
		pollToUpdate.setOptions(poll.getOptions());
		pollToUpdate.setQuestion(poll.getQuestion());
		getCurentSession().update(pollToUpdate);		
	}

	@Override
	public void deletePoll(long id) {
		Poll pollToDel = getPoll(id);
		if(pollToDel != null) {
			getCurentSession().delete(pollToDel);
		}

	}



	
}
