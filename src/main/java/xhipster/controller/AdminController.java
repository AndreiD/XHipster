package xhipster.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import xhipster.form.ProgrammingLanguagesForm;
import xhipster.model.ProgrammingLanguage;
import xhipster.other.PageWrapper;
import xhipster.service.ProgrammingLanguagesRepository;

@Slf4j
@Controller
public class AdminController {


    @Autowired
    ProgrammingLanguagesRepository mRepository;

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


    @RequestMapping(value = "/admin/list_programming_languages", method = RequestMethod.GET)
    protected String adminListProgrammingLanguages(final HttpServletRequest req, Model model, Pageable pageable) {

        Page<ProgrammingLanguage> programmingLanguagePage = mRepository.findAllByOrderByNameAsc(pageable);
        PageWrapper<ProgrammingLanguage> page = new PageWrapper<>(programmingLanguagePage, "/admin/list_programming_languages");

        model.addAttribute("programmingLanguagePage", programmingLanguagePage);
        model.addAttribute("page", page);

        return "/admin/list_programming_languages";
    }



}