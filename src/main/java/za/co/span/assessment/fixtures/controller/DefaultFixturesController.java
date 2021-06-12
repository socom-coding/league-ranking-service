package za.co.span.assessment.fixtures.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.span.assessment.fixtures.service.IDefaultFixturesService;

@RestController
@RequestMapping("/fixtures")
public class DefaultFixturesController {

    //TODO: ADD/Instrumentation Metrics - Counter - Gauge - Tracing

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    private IDefaultFixturesService iDefaultFixtures;

    @Autowired
    public DefaultFixturesController(IDefaultFixturesService iDefaultFixtures) {
        this.iDefaultFixtures = iDefaultFixtures;
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/result/{result}", method = RequestMethod.POST)
    public ResponseEntity captureResult(@PathVariable("result") String result){
        iDefaultFixtures.processResult(result);
        return new ResponseEntity<>("Results Captured", HttpStatus.CREATED);
    }

    @Secured("ROLE_GUEST")
    @RequestMapping(value = "/ranking", method = RequestMethod.GET)
    public ResponseEntity ranking(){
        iDefaultFixtures.findAll();
        return new ResponseEntity<>(iDefaultFixtures.findAll(), HttpStatus.OK);
    }
}
