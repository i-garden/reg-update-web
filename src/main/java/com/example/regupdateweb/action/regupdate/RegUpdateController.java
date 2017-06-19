package com.example.regupdateweb.action.regupdate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Regstory Change Class.
 *
 * @author Junichi Tsuchiya
 */
@Controller
@Scope("prototype")
@RequestMapping("/regUpdate")
public class RegUpdateController {

    /**
     * Regstory Change Page Init.
     *
     * @param model Model
     * @return Regstory Change Page
     */
    @RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("hello", "hello");
        return "sample";
    }

    /**
     * Regstory Change Execute.
     *
     * @param model Model
     * @return Regstory Change Page
     * @throws IOException
     */
    @RequestMapping(value="change", method = RequestMethod.POST)
    public void change(Model model, HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter pw = res.getWriter();
        RegUpdateService service = new RegUpdateService();

        try {
            service.insert();
        } catch (Exception e) {
            pw.print(HttpStatus.SERVICE_UNAVAILABLE);
            return;
        }
        pw.print(HttpStatus.OK);
    }
}
