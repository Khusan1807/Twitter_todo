package uz.nb.simple_trello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.nb.simple_trello.controller.base.AbstractController;
import uz.nb.simple_trello.entity.auth.AuthUser;
import uz.nb.simple_trello.entity.base.AuditAwareImpl;
import uz.nb.simple_trello.services.project.ProjectService;


@Controller
@RequestMapping("/index/*")
public class IndexController extends AbstractController<ProjectService> {

    private final AuditAwareImpl auditAware;

    public IndexController(ProjectService service, AuditAwareImpl auditAware) {
        super(service);
        this.auditAware = auditAware;
    }

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String homePage(Model model) {
        Long orgId = auditAware.getCredentials().getOrganizationId();
        model.addAttribute("projects", service.getAllProjects(orgId));
        return "project/list";
    }


}
