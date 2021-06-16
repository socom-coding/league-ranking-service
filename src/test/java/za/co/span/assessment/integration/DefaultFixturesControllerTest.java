package za.co.span.assessment.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
import za.co.span.assessment.fixtures.entity.Team;
import za.co.span.assessment.fixtures.service.DefaultFixturesService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DefaultFixturesController.class)
public class DefaultFixturesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DefaultFixturesController defaultFixturesController;

    @MockBean
    private DefaultFixturesService defaultFixturesService;

    @Test
    public void test_when_DefaultFixturesController_injected_thenNotNull() throws Exception {
        assertThat(defaultFixturesController).isNotNull();
    }

    @Test
    public void test_authorization_when_processResult_then_correct_response_200() throws Exception {

        given(defaultFixturesService.processResult("Lions 3, Snakes 3")).willReturn("Result Captured");

        mockMvc.perform(post("/fixtures/result/{result}", "Lions 3, Snakes 3")
                .with(httpBasic("admin", "p@55w0rd"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void test_authorization_when_processResult_then_correct_response_401() throws Exception {

        given(defaultFixturesService.processResult("Lions 3, Snakes 3")).willReturn("Result Captured");

        mockMvc.perform(post("/fixtures/result/{result}", "Lions 3, Snakes 3")
                .with(httpBasic("admin", "password"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void test_authorization_when_getOrderedRankingTable_then_correct_response_200() throws Exception {

        given(defaultFixturesService.getOrderedRankingTable()).willReturn(getSortedPointsList());

        mockMvc.perform(get("/fixtures/ranking")
                .with(httpBasic("admin", "p@55w0rd"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void test_authorization_when_getOrderedRankingTable_then_correct_response_401() throws Exception {

        given(defaultFixturesService.getOrderedRankingTable()).willReturn(getSortedPointsList());

        mockMvc.perform(get("/fixtures/ranking")
                .with(httpBasic("guest", "p@55w0rd"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    private List<Team> getSortedPointsList() {

        Team lions = new Team(3, "Tarantulas", 0, 6, 0);
        Team snakes = new Team(1, "Lions", 0, 5, 0);
        Team tarantulas = new Team(4, "FC Awsome", 0, 1, 0);
        Team fcAwsome = new Team(2, "Snakes", 0, 1, 0);
        Team grouches = new Team(5, "Grouches", 0, 0, 0);

        List<Team> teamlist = new ArrayList<>();
        teamlist.add(lions);
        teamlist.add(snakes);
        teamlist.add(tarantulas);
        teamlist.add(fcAwsome);
        teamlist.add(grouches);

        return teamlist;
    }
}
