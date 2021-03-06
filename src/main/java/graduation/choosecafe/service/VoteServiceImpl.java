package graduation.choosecafe.service;

import graduation.choosecafe.model.Lunch;
import graduation.choosecafe.model.Vote;
import graduation.choosecafe.model.Voting;
import graduation.choosecafe.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository repository;

    @Autowired
    public VoteServiceImpl(VoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vote create(Vote vote) {
        return repository.saveAndFlush(vote);
    }

    @Override
    public Vote update(Vote vote) {
        return repository.saveAndFlush(vote);
    }

    @Override
    public Vote get(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public List<Vote> getByLunch(Lunch lunch) {
        return repository.findVotesByLunch(lunch);
    }

    @Override
    public List<Vote> getByVoting(Voting voting) {
        return repository.findVotesByVoting(voting);
    }
}
