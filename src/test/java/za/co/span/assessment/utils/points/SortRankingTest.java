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
import za.co.span.assessment.utils.ranking.SortRanking;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class SortRankingTest {

    @Autowired
    SortRanking sortRanking;

    @TestConfiguration
    static class SortRankingTestContextConfiguration {

        @Bean
        public SortRanking sortRanking() {
            return new SortRanking();
        }
    }

    @Before
    public void setUp() throws Exception {
        this.sortRanking = new SortRanking();
    }

    @Test
    public void when_sortRanking() {
        List<LeagueRanking> leagueRankingList = sortRanking.sortTableAccordingToPoints(getList());
        Assert.assertEquals("Tarantulas", leagueRankingList.get(0).getName());
        Assert.assertEquals("Lions", leagueRankingList.get(1).getName());
        Assert.assertEquals("FC Awsome", leagueRankingList.get(2).getName());
        Assert.assertEquals("Snakes", leagueRankingList.get(3).getName());
        Assert.assertEquals("Grouches", leagueRankingList.get(4).getName());

    }

    private List<LeagueRanking> getList() {
        LeagueRanking lionsRanking = new LeagueRanking(1, "Lions", 5);
        LeagueRanking snakesRanking = new LeagueRanking(2, "Snakes", 1);
        LeagueRanking tarantulasRanking = new LeagueRanking(3, "Tarantulas", 6);
        LeagueRanking fcAwsomeRanking = new LeagueRanking(4, "FC Awsome", 1);
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
