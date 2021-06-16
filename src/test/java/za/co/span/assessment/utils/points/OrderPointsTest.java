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
import za.co.span.assessment.utils.ranking.OrderPoints;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class OrderPointsTest {

    @Autowired
    OrderPoints orderPoints;

    @TestConfiguration
    static class SortRankingTestContextConfiguration {

        @Bean
        public OrderPoints sortRanking() {
            return new OrderPoints();
        }
    }

    @Before
    public void setUp() throws Exception {
        this.orderPoints = new OrderPoints();
    }

    @Test
    public void when_order_according_to_points() {
        List<Team> teamList = orderPoints.sortTableAccordingToPoints(getList());
        Assert.assertEquals("Tarantulas", teamList.get(0).getName());
        Assert.assertEquals("Lions", teamList.get(1).getName());
        Assert.assertEquals("FC Awsome", teamList.get(2).getName());
        Assert.assertEquals("Snakes", teamList.get(3).getName());
        Assert.assertEquals("Grouches", teamList.get(4).getName());

    }

    private List<Team> getList() {
        Team lions = new Team(1, "Lions", 0, 5, 0);
        Team snakes = new Team(2, "Snakes", 0, 1, 0);
        Team tarantulas = new Team(3, "Tarantulas", 0, 6, 0);
        Team fcAwsome = new Team(4, "FC Awsome", 0, 1, 0);
        Team grouches = new Team(5, "Grouches", 0, 0, 0);

        List<Team> teamList = new ArrayList<>();
        teamList.add(lions);
        teamList.add(snakes);
        teamList.add(tarantulas);
        teamList.add(fcAwsome);
        teamList.add(grouches);

        return teamList;
    }

}
