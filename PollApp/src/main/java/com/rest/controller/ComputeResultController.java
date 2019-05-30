package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dataTransferObjects.VoteResult;
import com.rest.model.Vote;
import com.rest.service.VoteService;

@RestController
public class ComputeResultController {

	@Autowired
	private VoteService voteService;
	
	/*@RequestParam is option after ? in url
	 * http://localhost:8080/PollApp/computeresult?pollId=1*/
	@RequestMapping(value = "/computeresult", method = RequestMethod.GET)
	public ResponseEntity<?> computeResult (@RequestParam long pollId){
		
		VoteResult voteResult = new VoteResult();
		Iterable<Vote> allVotes = voteService.findByPoll(pollId);
		
		
		
		return new ResponseEntity<>(voteResult, HttpStatus.OK);
	}
}
