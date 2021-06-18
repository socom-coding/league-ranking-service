package za.co.span.assessment.utils.points;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
import za.co.span.assessment.fixtures.pojo.Team;

import java.util.List;

@Component
public class AllocateMatchPoints {

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    @Value("${league.points.win}")
    String win;

    @Value("${league.points.loose}")
    String loose;

    @Value("${league.points.draw}")
    String draw;

    public List<Team> applyRules(List<Team> teamList) {

        if (teamList.get(0).getScore() == teamList.get(1).getScore()) {
            teamList.get(0).setPoints(Integer.parseInt(draw));
            teamList.get(1).setPoints(Integer.parseInt(draw));
        } else if (teamList.get(0).getScore() > teamList.get(1).getScore()) {
            teamList.get(0).setPoints(Integer.parseInt(win));
            teamList.get(1).setPoints(Integer.parseInt(loose));
        } else {
            teamList.get(0).setPoints(Integer.parseInt(loose));
            teamList.get(1).setPoints(Integer.parseInt(win));
        }
        return teamList;
    }
}
