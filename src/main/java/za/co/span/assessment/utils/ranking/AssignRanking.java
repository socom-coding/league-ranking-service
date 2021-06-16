package za.co.span.assessment.utils.ranking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
import za.co.span.assessment.fixtures.entity.LeagueRanking;

import java.util.List;

@Component
public class AssignRanking {

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    public List<LeagueRanking> assignRank(List<LeagueRanking> leagueRankings) {
        int position = 1;

        //TODO: cater for empty result
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
