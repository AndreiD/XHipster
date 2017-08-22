package xhipster.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import xhipster.form.ProgrammingLanguagesForm;

@Slf4j
@Controller
public class AdminController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    protected String theLogin(final HttpServletRequest req, Model model, Pageable pageable) {


        return "/public/login";
    }



    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    protected String adminIndex(final HttpServletRequest req, final Map<String, Object> model) {
        return "/admin/index";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    protected String adminLogout(final HttpServletRequest req, final Map<String, Object> model) {

        //Doing nothing at the moment :)

        return "/";
    }

    @RequestMapping(value = "/admin/add_programming_language", method = RequestMethod.GET)
    public String addProgrammingLanguage(ProgrammingLanguagesForm programmingLanguagesForm, HttpServletRequest request) {
        return "/admin/add_programming_language";
    }



}