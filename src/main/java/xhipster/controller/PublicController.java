package xhipster.controller;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xhipster.model.ProgrammingLanguage;
import xhipster.other.PageWrapper;
import xhipster.service.ProgrammingLanguagesRepository;

@Slf4j
@Controller
public class PublicController {

  @Autowired
  ProgrammingLanguagesRepository mRepository;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  protected String publicIndex(final HttpServletRequest req, final Map<String, Object> model, Pageable pageable) {
    return "/public/index";
  }

  @RequestMapping(value = "/list_programming_languages", method = RequestMethod.GET)
  protected String publicListProgrammingLanguages(final HttpServletRequest req, Model model, Pageable pageable) {

    Page<ProgrammingLanguage> programmingLanguagePage = mRepository.findAllByOrderByNameAsc(pageable);
    PageWrapper<ProgrammingLanguage> page = new PageWrapper<>(programmingLanguagePage, "/list_programming_languages");

    model.addAttribute("programmingLanguagePage", programmingLanguagePage);
    model.addAttribute("page", page);

    return "/public/list_programming_languages";
  }
}