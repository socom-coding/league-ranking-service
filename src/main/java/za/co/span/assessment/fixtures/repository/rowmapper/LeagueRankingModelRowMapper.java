package za.co.span.assessment.fixtures.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import za.co.span.assessment.fixtures.entity.LeagueRanking;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LeagueRankingModelRowMapper implements RowMapper {
    @Override
    public LeagueRanking mapRow(ResultSet rs, int rowNum) throws SQLException {
        LeagueRanking leagueRanking = new LeagueRanking();
        leagueRanking.setId(rs.getInt("id"));
        leagueRanking.setName(rs.getString("team"));
        leagueRanking.setPoints(rs.getString("points"));
        return leagueRanking;
    }
}
