package za.co.span.assessment.fixtures.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
import za.co.span.assessment.fixtures.entity.LeagueRanking;
import za.co.span.assessment.fixtures.entity.MatchResult;
import za.co.span.assessment.fixtures.entity.Team;
import za.co.span.assessment.fixtures.repository.ResultsRepository;
import za.co.span.assessment.utils.AllocatePoints;
import za.co.span.assessment.utils.MapStringToObject;
import za.co.span.assessment.fixtures.service.DefaultFixturesService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class DefaultFixturesServiceImpl implements DefaultFixturesService {

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    private ResultsRepository resultsRepository;
    private MapStringToObject mapStringToObject;
    private AllocatePoints allocatePoints;

    @Autowired
    public DefaultFixturesServiceImpl(ResultsRepository resultsRepository, MapStringToObject mapStringToObject, AllocatePoints allocatePoints) {
        this.resultsRepository = resultsRepository;
        this.mapStringToObject = mapStringToObject;
        this.allocatePoints = allocatePoints;
    }

    @Override
    public void processResult(String matchResult) {
        MatchResult mappedResult = mapStringToObject.mapResult(matchResult);
        allocatePoints.determinePoints(mappedResult);
        resultsRepository.insertResult(mappedResult);
        resultsRepository.insertFixtures(mappedResult);

        for (Team team : mappedResult.getTeams()) {

            List<LeagueRanking> leagueRanking = new ArrayList<>();

            try {
                leagueRanking = resultsRepository.findTeam(team.getName());
            } catch (Exception e) {
                log.error(String.valueOf(e));
            }
            if (leagueRanking.isEmpty()) {
                resultsRepository.insertPoints(team);
            } else {
                team.setId(leagueRanking.get(0).getId());
                team.setPoints(leagueRanking.get(0).getPoints() + team.getPoints());
                resultsRepository.updatePoints(team);
            }
        }
    }

    @Override
    public List<LeagueRanking> findAll() {
        List<LeagueRanking> leagueRankings = new ArrayList<>();
        leagueRankings = resultsRepository.findAll();

        leagueRankings.sort(Comparator.comparing(LeagueRanking::getPoints).reversed().thenComparing(LeagueRanking::getName));

        int position = 1;

        leagueRankings.get(0).setPosition(position);

        for (int i = 1; i < leagueRankings.size(); i++) {
            if (leagueRankings.get(i).getPoints() == leagueRankings.get(i - 1).getPoints()) {
                leagueRankings.get(i).setPosition(leagueRankings.get(i - 1).getPosition());
                position++;
            } else {
                leagueRankings.get(i).setPosition(++position);
            }
        }

        return leagueRankings;
    }
}
