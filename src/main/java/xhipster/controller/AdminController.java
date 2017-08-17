package xhipster.controller;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import xhipster.form.ProgrammingLanguagesForm;
import xhipster.service.NotificationService;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Slf4j
@Controller
public class AdminController {


    @Autowired
    private NotificationService notifyService;
    //  notifyService.error_notification("Fail! :( Please contact the creator of this page to help you.");

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    protected String adminIndex(final HttpServletRequest req, final Map<String, Object> model) {
        return "/admin/index";
    }


    @RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
    protected String adminLogout(final HttpServletRequest req, final Map<String, Object> model) {

        //Doing nothing at the moment :)

        return "/";
    }

    @RequestMapping(value = "/admin/add_programming_language", method = RequestMethod.GET)
    public String addProgrammingLanguage(ProgrammingLanguagesForm programmingLanguagesForm, HttpServletRequest request) {
        return "/admin/add_programming_language";
    }



}