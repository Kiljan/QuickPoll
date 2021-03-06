package com.rest.controller;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.exception.ResourceNotFoundException;
import com.rest.model.Poll;
import com.rest.service.PollService;

@RestController
public class PollRestController {

	@Autowired
	private PollService pollService;
	
	@RequestMapping(value = "/polls", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Poll>> getAllPools(){
		return new ResponseEntity<>(pollService.getAllPolls(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/polls", consumes = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.POST)
	public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll){
		pollService.savePoll(poll);
		
		//Seting location header for created resource
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newPollUri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(poll.getId())
				.toUri();
		
		responseHeaders.setLocation(newPollUri);
		
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}
	
	/*I dont know how to solve it in nice whay. Object Poll got a set of Object Options and 
	 * this doesent work with conventional whay in repository implementation.
	 * */
	@RequestMapping(value = "/polls/{pollId}", method = RequestMethod.GET)
	public ResponseEntity<?> getPoll(@PathVariable("pollId") Long pollID){
		
		verifyPoll(pollID);
		
		List<Poll> pl = pollService.getPollList(pollID);
		return new ResponseEntity<>(pl, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/polls/{pollId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable("pollId") Long pollId){
		
		verifyPoll(pollId);
		
		pollService.updatePoll(poll);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/polls/{pollId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delatePoll(@PathVariable("pollId") long pollId){
		
		verifyPoll(pollId);
		
		pollService.deletePoll(pollId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	/*function created for 404 check, If id doesent exist GET, PUT and DELETE should 
	 * create 404 error not 200
	 * additional for ResourceNotFoundException I create handelResourceNotFoundException for error response
	 * witch json format
	 * */
	protected void verifyPoll(Long pollId) {
		List<Poll> pl = pollService.getPollList(pollId);
		
		if(pl.isEmpty()) {
			throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
		}
		
	}
	
}














