package uz.nb.simple_trello.controller.auth;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.nb.simple_trello.controller.base.AbstractController;
import uz.nb.simple_trello.criteria.GenericCriteria;
import uz.nb.simple_trello.dto.auth.AuthUserCreateDto;
import uz.nb.simple_trello.dto.auth.AuthUserUpdateDto;
import uz.nb.simple_trello.dto.auth.LoginDto;
import uz.nb.simple_trello.entity.auth.AuthUser;
import uz.nb.simple_trello.entity.base.AuditAwareImpl;
import uz.nb.simple_trello.services.auth.AuthUserService;

@Controller
@RequestMapping("/auth/*")
public class AuthUserController extends AbstractController<AuthUserService> {


    private final PasswordEncoder passwordEncoder;
    private final AuditAwareImpl auditAware;


    public AuthUserController(AuthUserService service, PasswordEncoder passwordEncoder, AuditAwareImpl auditAware) {
        super(service);
        this.passwordEncoder = passwordEncoder;
        this.auditAware = auditAware;
    }


    @PreAuthorize("hasRole('SUPER_USER')")
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String createPage() {
        return "auth/register";
    }


    @PreAuthorize("hasRole('SUPER_USER')")
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String create(@ModelAttribute AuthUserCreateDto dto) {
        service.create(dto);
        return "redirect:/index/index";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "/auth/login";
    }


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute LoginDto dto) {
        service.login(dto);
        return "/";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logoutPage() {
        return "auth/logout";
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String updatePage(Model model) {
        Long id = auditAware.getCredentials().getId();
        model.addAttribute("user", service.get(id));
        return "auth/update";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute AuthUserUpdateDto dto) {
        Long id = auditAware.getCredentials().getId();
        dto.setId(id);
        service.update(dto);
        return "redirect:/index/index";
    }

    @PreAuthorize("hasRole('SUPER_USER')")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("users", service.getAll(new GenericCriteria()));
        return "auth/list";
    }


}
