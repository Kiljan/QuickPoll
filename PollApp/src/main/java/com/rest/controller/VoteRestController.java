package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.model.Vote;
import com.rest.service.VoteService;

@RestController
public class VoteRestController {

	@Autowired
	private VoteService voteService;
	
	@RequestMapping(value = "/polls/{pollId}/votes", method = RequestMethod.POST)
	public ResponseEntity<?> createVote(@PathVariable("pollId") long pollId, @RequestBody Vote vote){
		
		voteService.saveVote(vote);
		
		//Setting headers
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}").buildAndExpand(vote.getId()).toUri());
		
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/polls/{pollId}/votes", method = RequestMethod.GET)
	public Iterable<Vote> getAllVotes(@PathVariable("pollId") long pollId){
		return voteService.findByPoll(pollId);
	}
}
