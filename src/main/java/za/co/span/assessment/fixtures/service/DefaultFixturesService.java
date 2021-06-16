package za.co.span.assessment.fixtures.service;

import za.co.span.assessment.fixtures.dto.TeamDTO;

import java.util.List;

public interface DefaultFixturesService {
    String processResult(String matchResult);

    List<TeamDTO> getOrderedRankingTable();
}
