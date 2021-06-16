package za.co.span.assessment.utils.points;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.span.assessment.fixtures.dao.TeamDAO;
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
        List<TeamDAO> orderedTeamList = assignRanking.assignRank(getSortedPointsList());

        Assert.assertTrue(orderedTeamList.get(0).getName().equals("Tarantulas") && orderedTeamList.get(0).getPosition() == 1);
        Assert.assertTrue(orderedTeamList.get(1).getName().equals("Lions") && orderedTeamList.get(1).getPosition() == 2);
        Assert.assertTrue(orderedTeamList.get(2).getName().equals("FC Awsome") && orderedTeamList.get(2).getPosition() == 3);
        Assert.assertTrue(orderedTeamList.get(3).getName().equals("Snakes") && orderedTeamList.get(3).getPosition() == 3);
        Assert.assertTrue(orderedTeamList.get(4).getName().equals("Grouches") && orderedTeamList.get(4).getPosition() == 5);
    }

    private List<TeamDAO> getSortedPointsList() {

        TeamDAO lions = new TeamDAO(3, "Tarantulas", 0, 6, 0);
        TeamDAO snakes = new TeamDAO(1, "Lions", 0, 5, 0);
        TeamDAO tarantulas = new TeamDAO(4, "FC Awsome", 0, 1, 0);
        TeamDAO fcAwsome = new TeamDAO(2, "Snakes", 0, 1, 0);
        TeamDAO grouches = new TeamDAO(5, "Grouches", 0, 0, 0);

        List<TeamDAO> teamDAOList = new ArrayList<>();
        teamDAOList.add(lions);
        teamDAOList.add(snakes);
        teamDAOList.add(tarantulas);
        teamDAOList.add(fcAwsome);
        teamDAOList.add(grouches);

        return teamDAOList;
    }
}
