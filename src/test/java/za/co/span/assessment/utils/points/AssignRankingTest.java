package za.co.span.assessment.utils.points;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.span.assessment.fixtures.entity.LeagueRanking;
import za.co.span.assessment.utils.ranking.AssignRanking;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class AssignRankingTest {

    @Autowired
    AssignRanking assignRanking;

    @TestConfiguration
    static class AssignRankingTestContextConfiguration {

        @Bean
        public AssignRanking sortRanking() {
            return new AssignRanking();
        }
    }

    @Before
    public void setUp() throws Exception {
        this.assignRanking = new AssignRanking();
    }

    @Test
    public void when_sortRanking() {
        List<LeagueRanking> leagueRankingList = assignRanking.assignRank(getSortedPointsList());

        Assert.assertTrue(leagueRankingList.get(0).getName().equals("Tarantulas") && leagueRankingList.get(0).getPosition() == 1);
        Assert.assertTrue(leagueRankingList.get(1).getName().equals("Lions") && leagueRankingList.get(1).getPosition() == 2);
        Assert.assertTrue(leagueRankingList.get(2).getName().equals("FC Awsome") && leagueRankingList.get(2).getPosition() == 3);
        Assert.assertTrue(leagueRankingList.get(3).getName().equals("Snakes") && leagueRankingList.get(3).getPosition() == 3);
        Assert.assertTrue(leagueRankingList.get(4).getName().equals("Grouches") && leagueRankingList.get(4).getPosition() == 5);

    }

    private List<LeagueRanking> getSortedPointsList() {

        LeagueRanking lionsRanking = new LeagueRanking(3, "Tarantulas", 6);
        LeagueRanking snakesRanking = new LeagueRanking(1, "Lions", 5);
        LeagueRanking tarantulasRanking = new LeagueRanking(4, "FC Awsome", 1);
        LeagueRanking fcAwsomeRanking = new LeagueRanking(2, "Snakes", 1);
        LeagueRanking grouchesRanking = new LeagueRanking(5, "Grouches", 0);

        List<LeagueRanking> leagueRankings = new ArrayList<>();
        leagueRankings.add(lionsRanking);
        leagueRankings.add(snakesRanking);
        leagueRankings.add(tarantulasRanking);
        leagueRankings.add(fcAwsomeRanking);
        leagueRankings.add(grouchesRanking);

        return leagueRankings;
    }
}
