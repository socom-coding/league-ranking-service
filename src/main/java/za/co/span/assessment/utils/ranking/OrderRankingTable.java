package za.co.span.assessment.utils.ranking;

import org.springframework.stereotype.Component;
import za.co.span.assessment.fixtures.entity.LeagueRanking;
import za.co.span.assessment.fixtures.repository.ResultsRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class OrderRankingTable {

    private ResultsRepository resultsRepository;
    private List<LeagueRanking> leagueRankings;

    public OrderRankingTable(ResultsRepository resultsRepository) {
        this.resultsRepository = resultsRepository;
    }

    public List<LeagueRanking> getOrderedRankingTable() {
        leagueRankings = getRankingTable();

        sortTableAccordingToPoints(leagueRankings);
        assignRank(leagueRankings);
        return leagueRankings;
    }

    private void assignRank(List<LeagueRanking> leagueRankings) {
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
    }

    private void sortTableAccordingToPoints(List<LeagueRanking> leagueRankings) {
        leagueRankings.sort(Comparator.comparing(LeagueRanking::getPoints).reversed().thenComparing(LeagueRanking::getName));
    }

    private List<LeagueRanking> getRankingTable() {
        return resultsRepository.findAll();
    }
}
