package xhipster.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import xhipster.model.ProgrammingLanguage;

@Slf4j
@Controller
public class APIController {


    @RequestMapping(value = "/api/v1/add_programming_language", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addProgrammingLanguage(@RequestBody ProgrammingLanguage programmingLanguage) {

        if(programmingLanguage.getName().length() < 1 || programmingLanguage.getDescription().length() <1){
            String json = "{\"message\": \"Seems like you have an invalid input :(\"}";
            return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
        }

        String message = "Programming language created";
        String json = "{\"message\": \"" + message + "\"}";

        return new ResponseEntity<>(json, HttpStatus.CREATED);
    }


}