package za.co.span.assessment.fixtures.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.span.assessment.fixtures.entity.LeagueRanking;
import za.co.span.assessment.fixtures.repository.ResultsRepository;
import za.co.span.assessment.fixtures.service.IDefaultFixturesService;
import za.co.span.assessment.utils.MapStringToObject;

import java.util.List;

@Service
public class DefaultFixturesService implements IDefaultFixturesService {

    @Autowired
    ResultsRepository resultsRepository;

    @Override
    public int add(String matchResult) {
        MapStringToObject mapStringToObject = new MapStringToObject();
        return resultsRepository.insert(mapStringToObject.mapResult(matchResult));
    }

    @Override
    public List<LeagueRanking> findAll() {
        return resultsRepository.findAll();
    }
}
