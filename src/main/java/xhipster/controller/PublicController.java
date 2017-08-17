package xhipster.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import xhipster.service.NotificationService;

@Slf4j
@Controller
public class PublicController {


    @Autowired
    private NotificationService notifyService;
    //  notifyService.error_notification("Fail! :( Please contact the creator of this page to help you.");

    @RequestMapping(value = "/", method = RequestMethod.GET)
    protected String publicIndex(final HttpServletRequest req, final Map<String, Object> model) {
        return "/public/index";
    }


    @RequestMapping(value = "/list_programming_languages", method = RequestMethod.GET)
    protected String publicListProgrammingLanguages(final HttpServletRequest req, final Map<String, Object> model) {
        return "/public/list_programming_languages";
    }



}