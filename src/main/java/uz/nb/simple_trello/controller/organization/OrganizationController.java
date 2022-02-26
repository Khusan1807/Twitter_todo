package uz.nb.simple_trello.controller.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.nb.simple_trello.controller.base.AbstractController;
import uz.nb.simple_trello.criteria.GenericCriteria;
import uz.nb.simple_trello.dto.organization.OrganizationCreateDto;
import uz.nb.simple_trello.dto.organization.OrganizationUpdateDto;
import uz.nb.simple_trello.services.organization.OrganizationService;

@Controller
@RequestMapping("/organization/*")
public class OrganizationController extends AbstractController<OrganizationService> {


    @Autowired
    public OrganizationController(OrganizationService service) {
        super(service);
    }

    @RequestMapping(value = "")
    public String listsPage(Model model) {
        model.addAttribute("organizations", service.getAll(new GenericCriteria()));
        return "index/index";
    }
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage() {
        return "organization/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute OrganizationCreateDto dto) {
        service.create(dto);
        return "redirect:/organization/list";
    }

    @RequestMapping("detail/{id}/")
    public String detail(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/detail";
    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public String listPage(Model model) {
//        model.addAttribute("organizations", service.getAll());
//        return "organization/list";
//    }


    @RequestMapping(value = "update/{id}/", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/update";
    }

    @RequestMapping(value = "update/{id}/", method = RequestMethod.PATCH)
    public String update(@ModelAttribute OrganizationUpdateDto dto) {
        service.update(dto);
        return "redirect:/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/delete";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("organizations", service.getAll(new GenericCriteria()));
        return "organization/list";
    }
}
