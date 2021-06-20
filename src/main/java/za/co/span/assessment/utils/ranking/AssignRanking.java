package za.co.span.assessment.utils.ranking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
import za.co.span.assessment.fixtures.dao.TeamDAO;

import java.util.List;

@Component
public class AssignRanking {

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    public List<TeamDAO> assignRank(List<TeamDAO> teamDAOList) {
        int position = 1;

        teamDAOList.get(0).setPosition(position);

        for (int i = 1; i < teamDAOList.size(); i++) {
            if (teamDAOList.get(i).getPoints() == teamDAOList.get(i - 1).getPoints()) {
                teamDAOList.get(i).setPosition(teamDAOList.get(i - 1).getPosition());
                position++;
            } else {
                teamDAOList.get(i).setPosition(++position);
            }
        }
        return teamDAOList;
    }
}
