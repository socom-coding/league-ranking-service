package za.co.span.assessment.fixtures.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.span.assessment.fixtures.dto.TeamDTO;
import za.co.span.assessment.fixtures.service.DefaultRepositoryService;
import za.co.span.assessment.fixtures.service.DefaultViewRankingTableService;
import za.co.span.assessment.utils.mapper.TeamMapper;

import java.util.List;

@Service
public class DefaultViewRankingTableServiceImpl implements DefaultViewRankingTableService {

    private DefaultRepositoryService defaultRepositoryService;

    @Autowired
    public DefaultViewRankingTableServiceImpl(DefaultRepositoryService defaultRepositoryService) {
        this.defaultRepositoryService = defaultRepositoryService;
    }

    @Override
    public List<TeamDTO> getOrderedRankingTable() {
        return TeamMapper.INSTANCE.mapToDTO(defaultRepositoryService.getRanking());
    }
}
