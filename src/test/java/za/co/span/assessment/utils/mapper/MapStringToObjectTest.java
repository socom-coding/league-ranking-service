package za.co.span.assessment.utils.mapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.span.assessment.fixtures.pojo.Team;

import java.util.List;

@RunWith(SpringRunner.class)
public class MapStringToObjectTest {

    @Autowired
    MapStringToObject mapStringToObject;

    @TestConfiguration
    static class MapStringToObjectTestContextConfiguration {
        @Bean
        public MapStringToObject mapStringToObject() {
            return new MapStringToObject();
        }
    }

    @Before
    public void setUp() throws Exception {
        this.mapStringToObject = new MapStringToObject();
    }

    @Test
    public void when_mapResultStringToObject() {
        List<Team> teamList = mapStringToObject.mapResult("Lions 3, Snakes 3");
        Assert.assertEquals("Lions", teamList.get(0).getName());
        Assert.assertEquals(3, teamList.get(0).getScore());
        Assert.assertEquals("Snakes", teamList.get(1).getName());
        Assert.assertEquals(3, teamList.get(1).getScore());
    }
}
