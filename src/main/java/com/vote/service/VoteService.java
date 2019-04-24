package com.vote.service;

import com.vote.Repository.VoteRepository;
import com.vote.models.Result;
import com.vote.models.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;

    private static Map<String, Vote> voteList = new HashMap<>();

    public Iterable<Vote> getVotes() {
        return voteRepository.findAll();
    }

    public Vote getVote(String name) {
        return voteRepository.findByName(name);
    }

    public String postVote(Vote vote) {
        if (vote.getAge() >= 18) {
            if (voteList.containsKey(vote.getName())) {
                return "Nope can't do that, you already voted, " + HttpStatus.ALREADY_REPORTED.toString();
            }
            voteRepository.save(vote);
            if (vote.isVote()) {
                return "Thank you, Trump loves you. Let's build that wall!";
            }
            return "Seriously? No wall?!. Our country will be destroyed!";
        } else {
            return "Nope can't do that you are too young!";
        }
    }

    public String updateVote(Vote vote) {
        if (voteRepository.findByName(vote.getName()) != null) {
            voteRepository.save(vote);
            return "Updated you vote to " + vote.isVote();
        }
        return "No vote found with the name " + vote.getName();
    }

    public Result getResults() {
        return new Result(
                voteRepository.findAllByVote(true).size(),
                voteRepository.findAllByVote(false).size()
        );
    }

    public String deleteVote(String name) {
        voteRepository.deleteByName(name);
        return "We deleted your vote with name: " + name;
    }
}
