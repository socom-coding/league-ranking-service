package za.co.span.assessment.utils.ranking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
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

            List<Team> teamList = new ArrayList<>();

            try {
                teamList = resultsRepository.findTeam(team.getName());
            } catch (Exception e) {
                log.error(String.valueOf(e));
            }
            if (teamList.isEmpty()) {
                resultsRepository.insertPoints(team);
            } else {
                team.setId(teamList.get(0).getId());
                team.setPoints(teamList.get(0).getPoints() + team.getPoints());
                resultsRepository.updatePoints(team);
            }
        }
    }
}
