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

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    @Autowired
    private IDefaultFixturesService iDefaultFixtures;

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/result/{result}", method = RequestMethod.POST)
    public ResponseEntity enterResult(@PathVariable("result") String result){
        log.info("About to capture result: {} ", result);
        iDefaultFixtures.add(result);
        return new ResponseEntity<>("Hallo World", HttpStatus.OK);
    }

    @Secured("ROLE_GUEST")
    @RequestMapping(value = "/ranking", method = RequestMethod.GET)
    public ResponseEntity enterResult(){
        log.info("Retrieving ranking table");
        iDefaultFixtures.findAll();
        return new ResponseEntity<>(iDefaultFixtures.findAll(), HttpStatus.OK);
    }
}
