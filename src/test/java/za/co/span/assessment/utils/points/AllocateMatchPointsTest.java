package za.co.span.assessment.utils.points;

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
    public void when_given_match_result_then_allocate_points_according_to_rules() {
        matchResult = allocateMatchPoints.applyRules(getMatchResult());
    }

    private MatchResult getMatchResult() {

        Team team1 = new Team(1, "Lions", 3, 0, 0);
        Team team2 = new Team(2, "Snakes", 3, 0, 0);

        List<Team> teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);

        MatchResult matchResult = new MatchResult();
        matchResult.setTeams(teams);
        return matchResult;
    }
}
