package graduation.choosecafe.service;

import graduation.choosecafe.model.Lunch;
import graduation.choosecafe.model.Voting;
import graduation.choosecafe.repository.LunchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LunchServiceImpl implements LunchService {

    private final LunchRepository repository;

    @Autowired
    public LunchServiceImpl(LunchRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public Lunch get(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public void delete(Integer id) {
            repository.deleteById(id);
    }

    @Override
    public Lunch create(Lunch lunch) {
        return repository.save(lunch);
    }

    @Override
    public Lunch update(Lunch lunch) {
        return repository.save(lunch);
    }

    @Override
    public List<Lunch> getByVoting(Voting voting) {
        return repository.fildLunchesbyVoting(voting);
    }
}
