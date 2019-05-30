package com.rest.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.model.Poll;
import com.rest.model.Vote;

@Repository
public class VoteDaoImpl implements VoteDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unused")
	private Session getCurentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void saveVote(Vote vote) {
		
		Vote newVote = vote;
		
		getCurentSession().save(newVote);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Vote> findByPoll(long pollId) {
		
		String hql = "select v from Option o, Vote v where o.poll = :pollId "
				+ "and v.option = o.id";
		Iterable<Vote> res = getCurentSession().createQuery(hql).setLong("pollId", pollId).list();
		
		return	res;		
	}

	
}
