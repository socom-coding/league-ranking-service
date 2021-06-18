package za.co.span.assessment.utils.ranking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
import za.co.span.assessment.fixtures.dao.TeamDAO;

import java.util.Comparator;
import java.util.List;

@Component
public class OrderPoints {

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    public List<TeamDAO> sortTableAccordingToPoints(List<TeamDAO> teamDAOList) {
        teamDAOList.sort(Comparator.comparing(TeamDAO::getPoints).reversed().thenComparing(TeamDAO::getName));
        return teamDAOList;
    }
}
