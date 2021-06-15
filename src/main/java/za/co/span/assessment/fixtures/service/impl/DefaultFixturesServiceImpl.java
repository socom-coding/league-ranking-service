package za.co.span.assessment.fixtures.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
import za.co.span.assessment.fixtures.entity.LeagueRanking;
import za.co.span.assessment.fixtures.entity.MatchResult;
import za.co.span.assessment.fixtures.service.DefaultFixturesService;
import za.co.span.assessment.fixtures.service.DefaultRepositoryService;
import za.co.span.assessment.utils.mapper.MapStringToObject;
import za.co.span.assessment.utils.points.AllocateMatchPoints;

import java.util.List;

@Service
public class DefaultFixturesServiceImpl implements DefaultFixturesService {

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    private MatchResult mappedResult;
    private MapStringToObject mapStringToObject;
    private AllocateMatchPoints allocateMatchPoints;
    private DefaultRepositoryService defaultRepositoryService;

    @Autowired
    public DefaultFixturesServiceImpl(MapStringToObject mapStringToObject, AllocateMatchPoints allocateMatchPoints, DefaultRepositoryService defaultRepositoryService) {
        this.mapStringToObject = mapStringToObject;
        this.allocateMatchPoints = allocateMatchPoints;
        this.defaultRepositoryService = defaultRepositoryService;
    }

    @Override
    public void processResult(String matchResult) {
        mappedResult = new MatchResult();
        mappedResult = mapStringToObject.mapResult(matchResult);
        allocateMatchPoints.applyRules(mappedResult);
        defaultRepositoryService.captureResults(mappedResult);
        defaultRepositoryService.updateRankingTable(mappedResult);
    }

    @Override
    public List<LeagueRanking> getOrderedRankingTable() {
        return defaultRepositoryService.getRanking();
    }
}
