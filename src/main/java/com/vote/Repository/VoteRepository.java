package com.vote.Repository;

import com.vote.models.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Long> {
    Vote findByName (String name);

    List<Vote> findAllByVote (Boolean vote);

    void deleteByName(String name);
}
