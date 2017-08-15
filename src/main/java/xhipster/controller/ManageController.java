package xhipster.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;


@Controller
public class ManageController{

    //Spring Boot Actuator View

    @RequestMapping("/admin/manage")
    protected String manage() throws IOException {
        return "/admin/manage";
    }

}
