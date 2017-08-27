package xhipster.controller;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageController {

  //Spring Boot Actuator View

  @RequestMapping("/admin/manage")
  protected String manage() throws IOException {
    return "/admin/manage";
  }
}
