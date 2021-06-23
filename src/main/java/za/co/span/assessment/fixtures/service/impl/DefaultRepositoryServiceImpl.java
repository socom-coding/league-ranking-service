package za.co.span.assessment.fixtures.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
import za.co.span.assessment.fixtures.dao.TeamDAO;
import za.co.span.assessment.fixtures.repository.ResultsRepository;
import za.co.span.assessment.fixtures.service.DefaultRepositoryService;
import za.co.span.assessment.utils.ranking.OrderRankingTable;
import za.co.span.assessment.utils.ranking.UpdateRankingTable;

import java.util.List;

@Service
public class DefaultRepositoryServiceImpl implements DefaultRepositoryService {

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    private ResultsRepository resultsRepository;
    private UpdateRankingTable updateRankingTable;
    private OrderRankingTable orderRankingTable;

    @Autowired
    public DefaultRepositoryServiceImpl(ResultsRepository resultsRepository, UpdateRankingTable updateRankingTable, OrderRankingTable orderRankingTable) {
        this.resultsRepository = resultsRepository;
        this.updateRankingTable = updateRankingTable;
        this.orderRankingTable = orderRankingTable;
    }

    @Override
    public void captureResults(List<TeamDAO> teamDAO) {
        resultsRepository.insertResult(teamDAO);
        resultsRepository.insertFixtures(teamDAO);
    }

    @Override
    public void updateRankingTable(List<TeamDAO> teamDAO) {
        updateRankingTable.updatePoints(teamDAO);
    }

    @Override
    public List<TeamDAO> getRanking() {
        return orderRankingTable.getOrderedRankingTable();
    }
}
