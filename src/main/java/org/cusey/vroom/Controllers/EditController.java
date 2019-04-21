package org.cusey.vroom.Controllers;

import org.cusey.vroom.Models.Dictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EditController {



    private final static Logger slf4jLogger = LoggerFactory.getLogger(EditController.class);


    //http://localhost:8095/edit
    @RequestMapping("/edit")
    public String showEdit(HttpServletRequest request){

        slf4jLogger.debug("showEdit");


        List<Dictionary> dictionaryList = new ArrayList<>();

        dictionaryList.add(new Dictionary("abash", "v.", "embarrass.", "He was not at all abashed by her open admiration."));
        dictionaryList.add(new Dictionary("abate",  "v.", "subside or moderate.", "Rather than leaving immediately, they waited for the storm to abate."));
        dictionaryList.add(new Dictionary("abeyance", "N.", "suspended action."," The deal was held in abeyance until her arrival."));
        dictionaryList.add(new Dictionary("abhor", "v.", "detest; hate.", "She abhorred all forms of bigotry, abhorrence, N."));
        dictionaryList.add(new Dictionary("abut", "v.", "border upon; adjoin.", "Where our estates abut, we must build a fence."));
        dictionaryList.add(new Dictionary("accord", "N."," agreement.", "She was in complete accord with the verdict."));
        dictionaryList.add(new Dictionary("accolade", "N.", " award of merit.", " In Hollywood, an Oscar is the highest accolade."));
        dictionaryList.add(new Dictionary("acetic", "ADJ.", " vinegary.", " The salad had an exceedingly acetic flavor."));
        dictionaryList.add(new Dictionary("actuate", "v. ", "motivate.", " I fail to understand what actuated you to reply to this letter so nastily. "));
        dictionaryList.add(new Dictionary("acuity", "N. ", "sharpness.", " In time his youthful acuity of vision failed him, and he needed glasses."));
        dictionaryList.add(new Dictionary("acumen", "N. ", "mental keenness.", " Her business acumen helped her to succeed where others had failed."));
        dictionaryList.add(new Dictionary("amiss", "ADJ. ", "wrong; faulty.", " Seeing her frown, he wondered if anything were amiss, also ADV."));
        dictionaryList.add(new Dictionary("ample", "ADJ. ", "abundant. ", "Bond had ample opportunity to escape. Why, then, did he let us capture him?"));
        dictionaryList.add(new Dictionary("anomaly", "N. ", "irregularity.", " A bird that cannot fly is an anomaly."));


        request.setAttribute("Dictionary", dictionaryList);
        return "edit";
    }
}
