

/**
 * User: Bryan
 * Date: 3/13/14
 * Time: 12:25 AM
 */
package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import app.service.HelloService;

@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/")
    @ResponseBody
    public String getMessage() {
        return helloService.getMessage();
    }
}
