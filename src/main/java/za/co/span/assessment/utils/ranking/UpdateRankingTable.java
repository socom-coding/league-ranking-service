package za.co.span.assessment.utils.ranking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
import za.co.span.assessment.fixtures.entity.LeagueRanking;
import za.co.span.assessment.fixtures.entity.MatchResult;
import za.co.span.assessment.fixtures.entity.Team;
import za.co.span.assessment.fixtures.repository.ResultsRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class UpdateRankingTable {

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    private ResultsRepository resultsRepository;

    public UpdateRankingTable(ResultsRepository resultsRepository) {
        this.resultsRepository = resultsRepository;
    }

    public void updatePoints(MatchResult mappedResult) {
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
}
