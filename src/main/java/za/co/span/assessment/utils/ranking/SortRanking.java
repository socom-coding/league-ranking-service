package za.co.span.assessment.utils.ranking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
import za.co.span.assessment.fixtures.entity.LeagueRanking;

import java.util.Comparator;
import java.util.List;

@Component
public class SortRanking {

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    public List<LeagueRanking> sortTableAccordingToPoints(List<LeagueRanking> leagueRankings) {
        leagueRankings.sort(Comparator.comparing(LeagueRanking::getPoints).reversed().thenComparing(LeagueRanking::getName));
        return leagueRankings;
    }
}
