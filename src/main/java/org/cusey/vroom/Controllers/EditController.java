package org.cusey.vroom.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EditController {


    //http://localhost:8095/edit
    @RequestMapping("/edit")
    public String showEdit(HttpServletRequest request){
        return "edit";
    }
}
