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
public class IndexController {

    private final static Logger slf4jLogger = LoggerFactory.getLogger(IndexController.class);


    //http://localhost:8095/
    @RequestMapping("/")
    public String showIndex(HttpServletRequest request){

        slf4jLogger.debug("showIndex");

        return "index";
    }

}
