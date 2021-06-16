package za.co.span.assessment.utils.points;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.span.assessment.fixtures.entity.MatchResult;
import za.co.span.assessment.fixtures.entity.Team;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
public class AllocateMatchPointsTest {

    @Autowired
    AllocateMatchPoints allocateMatchPoints;

    @Autowired
    MatchResult matchResult;

    @TestConfiguration
    static class AllocateMatchPointsTestContextConfiguration {

        @Bean
        public MatchResult matchResult() {
            return new MatchResult();
        }

        @Bean
        public AllocateMatchPoints allocateMatchPoints() {
            return new AllocateMatchPoints();
        }
    }

    @Before
    public void setUp() throws Exception {
        this.allocateMatchPoints = new AllocateMatchPoints();
        this.matchResult = new MatchResult();
    }

    @Test
    public void when_mapResultStringToObject() {
        matchResult = allocateMatchPoints.applyRules(getMatchResult());
        Assert.assertEquals("Lions", matchResult.getTeams().get(0).getName());
        Assert.assertEquals(3, matchResult.getTeams().get(0).getScore());
        Assert.assertEquals("Snakes", matchResult.getTeams().get(1).getName());
        Assert.assertEquals(3, matchResult.getTeams().get(1).getScore());
    }

    private MatchResult getMatchResult() {

        Team team1 = new Team("Lions", 3);
        Team team2 = new Team("Snakes", 3);

        List<Team> teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);

        MatchResult matchResult = new MatchResult();
        matchResult.setTeams(teams);
        return matchResult;
    }
}
