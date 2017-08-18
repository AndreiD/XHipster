package xhipster.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import xhipster.model.ProgrammingLanguage;
import xhipster.service.ProgrammingLanguagesRepository;

@Slf4j
@Controller
public class APIController {

    @Autowired
    ProgrammingLanguagesRepository mRepository;


    @RequestMapping(value = "/api/v1/add_programming_language", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addProgrammingLanguage(@RequestBody ProgrammingLanguage programmingLanguage) {

        if (programmingLanguage.getName().length() < 1 || programmingLanguage.getDescription().length() < 1) {
            String json = "{\"message\": \"Seems like you have an invalid input :(\"}";
            return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
        }


        if (mRepository.countLanguagesByName(programmingLanguage.getName()) > 0) {
            String json = "{\"message\": \"There is already a programming language with that name in the database\"}";
            return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
        }

        log.debug("SAVING!");
        log.info("INFO SAVING!");
        mRepository.save(new ProgrammingLanguage(0, programmingLanguage.getName(), programmingLanguage.getDescription()));


        String message = "Programming language created";
        String json = "{\"message\": \"" + message + "\"}";

        return new ResponseEntity<>(json, HttpStatus.CREATED);
    }


}