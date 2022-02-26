package uz.nb.simple_trello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.nb.simple_trello.controller.base.AbstractController;
import uz.nb.simple_trello.services.auth.AuthUserService;


@Controller
@RequestMapping("/index/*")
public class IndexController extends AbstractController<AuthUserService> {

    public IndexController(AuthUserService service) {
        super(service);
    }

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String homePage() {
        return "/index/index";
    }


}
