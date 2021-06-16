package za.co.span.assessment.fixtures.service;

import za.co.span.assessment.fixtures.dao.TeamDAO;

import java.util.List;

public interface DefaultRepositoryService {
    void captureResults(List<TeamDAO> teamDAO);

    void updateRankingTable(List<TeamDAO> teamDAO);

    List<TeamDAO> getRanking();
}
