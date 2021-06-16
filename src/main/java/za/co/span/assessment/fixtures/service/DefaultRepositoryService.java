package za.co.span.assessment.fixtures.service;

import za.co.span.assessment.fixtures.entity.MatchResult;
import za.co.span.assessment.fixtures.entity.Team;

import java.util.List;

public interface DefaultRepositoryService {
    void captureResults(MatchResult mappedResult);

    void updateRankingTable(MatchResult mappedResult);

    List<Team> getRanking();
}
