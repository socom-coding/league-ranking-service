package za.co.span.assessment.utils.ranking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
import za.co.span.assessment.fixtures.entity.Team;

import java.util.Comparator;
import java.util.List;

@Component
public class OrderPoints {

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    public List<Team> sortTableAccordingToPoints(List<Team> teams) {
        teams.sort(Comparator.comparing(Team::getPoints).reversed().thenComparing(Team::getName));
        return teams;
    }
}
