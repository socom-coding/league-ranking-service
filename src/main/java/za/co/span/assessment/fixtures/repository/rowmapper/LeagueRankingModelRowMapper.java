package za.co.span.assessment.fixtures.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import za.co.span.assessment.fixtures.entity.LeagueRanking;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LeagueRankingModelRowMapper implements RowMapper {
    @Override
    public LeagueRanking mapRow(ResultSet rs, int rowNum) throws SQLException {
        LeagueRanking leagueRanking = new LeagueRanking(rs.getInt("id"),
                rs.getString("team"), Integer.parseInt(rs.getString("points")));
        return leagueRanking;
    }
}
