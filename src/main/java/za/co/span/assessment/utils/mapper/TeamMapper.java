package za.co.span.assessment.utils.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import za.co.span.assessment.fixtures.dao.TeamDAO;
import za.co.span.assessment.fixtures.dto.TeamDTO;
import za.co.span.assessment.fixtures.pojo.Team;

import java.util.List;

@Mapper
public interface TeamMapper {
    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    TeamDTO teamDAOToTeamDTO(TeamDAO teamDAO);

    TeamDAO teamToTeamDAO(Team team);

    List<TeamDAO> mapToDAO(List<Team> teams);

    List<TeamDTO> mapToDTO(List<TeamDAO> teamDAO);

}
