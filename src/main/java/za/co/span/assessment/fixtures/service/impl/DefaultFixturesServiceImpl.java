package za.co.span.assessment.fixtures.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
import za.co.span.assessment.fixtures.dao.TeamDAO;
import za.co.span.assessment.fixtures.dto.TeamDTO;
import za.co.span.assessment.fixtures.service.DefaultFixturesService;
import za.co.span.assessment.fixtures.service.DefaultRepositoryService;
import za.co.span.assessment.utils.mapper.MapStringToObject;
import za.co.span.assessment.utils.mapper.TeamMapper;
import za.co.span.assessment.utils.points.AllocateMatchPoints;

import java.util.List;

@Service
public class DefaultFixturesServiceImpl implements DefaultFixturesService {

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    private MapStringToObject mapStringToObject;
    private AllocateMatchPoints allocateMatchPoints;
    private DefaultRepositoryService defaultRepositoryService;

    @Autowired
    public DefaultFixturesServiceImpl(MapStringToObject mapStringToObject, AllocateMatchPoints allocateMatchPoints, DefaultRepositoryService defaultRepositoryService) {
        this.mapStringToObject = mapStringToObject;
        this.allocateMatchPoints = allocateMatchPoints;
        this.defaultRepositoryService = defaultRepositoryService;
    }

    @Override
    public String processResult(String matchResult) {
        List<TeamDAO> teamDAOList = TeamMapper.INSTANCE.mapToDAO(allocateMatchPoints.applyRules(mapStringToObject.mapResult(matchResult)));
        defaultRepositoryService.captureResults(teamDAOList);
        defaultRepositoryService.updateRankingTable(teamDAOList);

        return "";
    }

    @Override
    public List<TeamDTO> getOrderedRankingTable() {
        return TeamMapper.INSTANCE.mapToDTO(defaultRepositoryService.getRanking());
    }
}
