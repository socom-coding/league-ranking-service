package za.co.span.assessment.utils.mapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.span.assessment.fixtures.entity.MatchResult;

@RunWith(SpringRunner.class)
public class MapStringToObjectTest {

    @Autowired
    MapStringToObject mapStringToObject;

    @Autowired
    MatchResult matchResult;

    @TestConfiguration
    static class MapStringToObjectTestContextConfiguration {
        @Bean
        public MapStringToObject mapStringToObject() {
            return new MapStringToObject();
        }

        @Bean
        public MatchResult matchResult() {
            return new MatchResult();
        }
    }

    @Before
    public void setUp() throws Exception {
        this.mapStringToObject = new MapStringToObject();
        this.matchResult = new MatchResult();
    }

    @Test
    public void when_mapResultStringToObject_the_true() {
        matchResult = mapStringToObject.mapResult("Lions 3, Snakes 3");
        Assert.assertEquals("Lions", matchResult.getTeams().get(0).getName());
        Assert.assertEquals(3, matchResult.getTeams().get(0).getScore());
        Assert.assertEquals("Snakes", matchResult.getTeams().get(1).getName());
        Assert.assertEquals(3, matchResult.getTeams().get(1).getScore());
    }
}
