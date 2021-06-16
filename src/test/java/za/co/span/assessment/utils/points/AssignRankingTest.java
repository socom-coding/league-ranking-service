package za.co.span.assessment.utils.points;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.span.assessment.fixtures.entity.Team;
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
    public void when_ranking_teams() {
        List<Team> orderedTeamList = assignRanking.assignRank(getSortedPointsList());

        Assert.assertTrue(orderedTeamList.get(0).getName().equals("Tarantulas") && orderedTeamList.get(0).getPosition() == 1);
        Assert.assertTrue(orderedTeamList.get(1).getName().equals("Lions") && orderedTeamList.get(1).getPosition() == 2);
        Assert.assertTrue(orderedTeamList.get(2).getName().equals("FC Awsome") && orderedTeamList.get(2).getPosition() == 3);
        Assert.assertTrue(orderedTeamList.get(3).getName().equals("Snakes") && orderedTeamList.get(3).getPosition() == 3);
        Assert.assertTrue(orderedTeamList.get(4).getName().equals("Grouches") && orderedTeamList.get(4).getPosition() == 5);

    }

    private List<Team> getSortedPointsList() {

        Team lions = new Team(3, "Tarantulas", 0, 6, 0);
        Team snakes = new Team(1, "Lions", 0, 5, 0);
        Team tarantulas = new Team(4, "FC Awsome", 0, 1, 0);
        Team fcAwsome = new Team(2, "Snakes", 0, 1, 0);
        Team grouches = new Team(5, "Grouches", 0, 0, 0);

        List<Team> teamlist = new ArrayList<>();
        teamlist.add(lions);
        teamlist.add(snakes);
        teamlist.add(tarantulas);
        teamlist.add(fcAwsome);
        teamlist.add(grouches);

        return teamlist;
    }
}
