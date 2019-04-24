package com.vote.controller;

import com.vote.models.Result;
import com.vote.models.Vote;
import com.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value = "/votes")
public class VoteController {

    @Autowired
    VoteService voteService;

    /**
     * Get all the available votes
     * @return Iterable Vote
     */
    @GetMapping()
    public Iterable<Vote> getVotes() {
        return voteService.getVotes();
    }

    /**
     * Get a vote by name
     * @param name
     * @return
     */
    @GetMapping(value = "/{name}")
    public Vote getVote(@PathVariable("name") String name) {
        return voteService.getVote(name);
    }

    /**
     * Post the vote object
     * @param vote object
     * @return
     */
    @PostMapping()
    public String postVote(@RequestBody() Vote vote) {
        return voteService.postVote(vote);
    }

    /**
     * Change the vote object
     * @param vote object
     * @return
     */
    @PutMapping()
    public String updateVote(@RequestBody() Vote vote) {
        return voteService.updateVote(vote);
    }

    /**
     * Delete a vote by name
     * @param name
     * @return
     */
    @Transactional()
    @DeleteMapping(value = "/{name}")
    public String deleteVote(@PathVariable("name") String name) {
        return voteService.deleteVote(name);
    }

    /**
     * Get the results as an object
     * @return Result object
     */
    @GetMapping(value = "/results")
    public Result getResults() {
        return voteService.getResults();
    }
}
