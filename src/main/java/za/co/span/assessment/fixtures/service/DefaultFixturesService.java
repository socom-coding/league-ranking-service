package za.co.span.assessment.fixtures.service;

import za.co.span.assessment.fixtures.entity.Team;

import java.util.List;

public interface DefaultFixturesService {
    String processResult(String matchResult);

    List<Team> getOrderedRankingTable();
}
