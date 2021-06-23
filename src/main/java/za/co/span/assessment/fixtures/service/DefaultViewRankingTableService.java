package za.co.span.assessment.fixtures.service;

import za.co.span.assessment.fixtures.dto.TeamDTO;

import java.util.List;

public interface DefaultViewRankingTableService {
    List<TeamDTO> getOrderedRankingTable();
}
