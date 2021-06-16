package za.co.span.assessment.utils.ranking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
import za.co.span.assessment.fixtures.entity.Team;
import za.co.span.assessment.fixtures.repository.ResultsRepository;

import java.util.List;

@Component
public class OrderRankingTable {

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    private ResultsRepository resultsRepository;
    private List<Team> teams;
    private OrderPoints orderPoints;
    private AssignRanking assignRanking;

    public OrderRankingTable(ResultsRepository resultsRepository, OrderPoints orderPoints, AssignRanking assignRanking) {
        this.resultsRepository = resultsRepository;
        this.orderPoints = orderPoints;
        this.assignRanking = assignRanking;
    }

    public List<Team> getOrderedRankingTable() {
        teams = getRankingTable();
        orderPoints.sortTableAccordingToPoints(teams);
        assignRanking.assignRank(teams);
        return teams;
    }

    private List<Team> getRankingTable() {
        return resultsRepository.findAll();
    }
}
