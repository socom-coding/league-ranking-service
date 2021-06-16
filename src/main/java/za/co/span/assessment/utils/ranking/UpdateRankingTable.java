package za.co.span.assessment.utils.ranking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
import za.co.span.assessment.fixtures.dao.TeamDAO;
import za.co.span.assessment.fixtures.repository.ResultsRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class UpdateRankingTable {

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    private ResultsRepository resultsRepository;

    public UpdateRankingTable(ResultsRepository resultsRepository) {
        this.resultsRepository = resultsRepository;
    }

    public void updatePoints(List<TeamDAO> teamDAOList) {
        for (TeamDAO teamDAO : teamDAOList) {

            List<TeamDAO> teamList = new ArrayList<>();

            try {
                teamList = resultsRepository.findTeam(teamDAO.getName());
            } catch (Exception e) {
                log.error(String.valueOf(e));
            }
            if (teamList.isEmpty()) {
                resultsRepository.insertPoints(teamDAO);
            } else {
                teamDAO.setId(teamList.get(0).getId());
                teamDAO.setPoints(teamList.get(0).getPoints() + teamDAO.getPoints());
                resultsRepository.updatePoints(teamDAO);
            }
        }
    }
}
