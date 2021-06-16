package za.co.span.assessment.utils.points;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
import za.co.span.assessment.fixtures.entity.MatchResult;

@Component
public class AllocateMatchPoints {

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    @Value("${league.points.win}")
    String win;

    @Value("${league.points.loose}")
    String loose;

    @Value("${league.points.draw}")
    String draw;

    public MatchResult applyRules(MatchResult matchResult) {

        if (matchResult.getTeams().get(0).getScore() == matchResult.getTeams().get(1).getScore()) {
            matchResult.getTeams().get(0).setPoints(Integer.parseInt(draw));
            matchResult.getTeams().get(1).setPoints(Integer.parseInt(draw));
        } else if (matchResult.getTeams().get(0).getScore() > matchResult.getTeams().get(1).getScore()) {
            matchResult.getTeams().get(0).setPoints(Integer.parseInt(win));
            matchResult.getTeams().get(1).setPoints(Integer.parseInt(loose));
        } else {
            matchResult.getTeams().get(0).setPoints(Integer.parseInt(loose));
            matchResult.getTeams().get(1).setPoints(Integer.parseInt(win));
        }
        return matchResult;
    }
}
