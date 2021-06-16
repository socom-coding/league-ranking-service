package za.co.span.assessment.utils.ranking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
import za.co.span.assessment.fixtures.entity.LeagueRanking;
import za.co.span.assessment.fixtures.repository.ResultsRepository;

import java.util.List;

@Component
public class OrderRankingTable {

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    private ResultsRepository resultsRepository;
    private List<LeagueRanking> leagueRankings;
    private SortRanking sortRanking;
    private AssignRanking assignRanking;

    public OrderRankingTable(ResultsRepository resultsRepository, SortRanking sortRanking, AssignRanking assignRanking) {
        this.resultsRepository = resultsRepository;
        this.sortRanking = sortRanking;
        this.assignRanking = assignRanking;
    }

    public List<LeagueRanking> getOrderedRankingTable() {
        leagueRankings = getRankingTable();
        sortRanking.sortTableAccordingToPoints(leagueRankings);
        assignRanking.assignRank(leagueRankings);
        return leagueRankings;
    }

    private List<LeagueRanking> getRankingTable() {
        return resultsRepository.findAll();
    }
}
