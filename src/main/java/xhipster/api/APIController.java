package xhipster.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xhipster.model.ProgrammingLanguage;
import xhipster.service.ProgrammingLanguagesRepository;

@Slf4j
@Controller
public class APIController {

  @Autowired
  ProgrammingLanguagesRepository mRepository;


  @RequestMapping(value = "/api/v1/programming_language", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> addProgrammingLanguage(@RequestBody ProgrammingLanguage programmingLanguage) {

    //Security
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    boolean hasAdminRole = authentication.getAuthorities().stream()
        .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
    if(!hasAdminRole) {
      String message = "invalid credentials";
      String json = "{\"message\": \"" + message + "\"}";
      return new ResponseEntity<>(json, HttpStatus.FORBIDDEN);
    }


    if (programmingLanguage.getName().length() < 1 || programmingLanguage.getDescription().length() < 1) {
      String json = "{\"message\": \"Seems like you have an invalid input :(\"}";
      return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
    }

    if (mRepository.countLanguagesByName(programmingLanguage.getName()) > 0) {
      String json = "{\"message\": \"There is already a programming language with that name in the database\"}";
      return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
    }

    mRepository.save(new ProgrammingLanguage(0, programmingLanguage.getName(), programmingLanguage.getDescription()));

    String message = "Programming language created";
    String json = "{\"message\": \"" + message + "\"}";

    return new ResponseEntity<>(json, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/api/v1/programming_language", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> deleteProgrammingLanguage(@RequestBody String payload) throws IOException {

    //Security
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    boolean hasAdminRole = authentication.getAuthorities().stream()
        .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
    if(!hasAdminRole) {
      String message = "invalid credentials";
      String json = "{\"message\": \"" + message + "\"}";
      return new ResponseEntity<>(json, HttpStatus.FORBIDDEN);
    }

    ObjectMapper mapper = new ObjectMapper();
    Map<String, Long> map = mapper.readValue(payload, new TypeReference<Map<String,Long>>(){});
    long toBeDeletedItemId = map.get("itemid");

    //deleting it
    mRepository.delete(toBeDeletedItemId);

    String message = "deleted";
    String json = "{\"message\": \"" + message + "\"}";
    return new ResponseEntity<>(json, HttpStatus.OK);
  }
}