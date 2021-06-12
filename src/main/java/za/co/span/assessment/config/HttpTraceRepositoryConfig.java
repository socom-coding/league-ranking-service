package za.co.span.assessment.config;

import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpTraceRepositoryConfig {

    //TODO: Disable for production

    /**
     * The default-implementation stores the captured data in memory.
     * Hence, it consumes much memory, without the user knowing, or even worse: needing it.
     * This is especially undesirable in cluster environments, where memory is a precious good.
     * And remember: Spring Boot was invented to simplify cluster deployments!
     *
     * @return
     */
    @Bean
    public HttpTraceRepository htttpTraceRepository() {
        return new InMemoryHttpTraceRepository();
    }
}
