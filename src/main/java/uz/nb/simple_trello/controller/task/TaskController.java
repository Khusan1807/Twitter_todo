package uz.nb.simple_trello.controller.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.nb.simple_trello.controller.base.AbstractController;
import uz.nb.simple_trello.criteria.GenericCriteria;
import uz.nb.simple_trello.dto.task.TaskCreateDto;
import uz.nb.simple_trello.dto.task.TaskUpdateDto;
import uz.nb.simple_trello.services.task.TaskService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/task/*")
public class TaskController extends AbstractController<TaskService> {

    public TaskController(TaskService service) {
        super(service);
    }

    @RequestMapping(value = "task", method = RequestMethod.GET)
    public String taskPage() {
        return "index/index3";
    }


    @RequestMapping(value = "create/{id}", method = RequestMethod.GET)
    public String createPage(@PathVariable(name = "id") Long id,Model model) {
        model.addAttribute( "id",id );
        return "task/create";
    }


    @RequestMapping(value = "create/{id}", method = RequestMethod.POST)
    public String create(@ModelAttribute TaskCreateDto dto, @PathVariable(name = "id") Long id, @RequestParam(name = "deadline1") String deadline ) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime date = LocalDateTime.parse(deadline, format);
        dto.setDeadline(date);
        dto.setColumnId( id );
        service.create(dto);
        return "task/create";
    }


    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("task",service.get(id));
        return "task/create";
    }

    @RequestMapping(value = "list/{id}", method = RequestMethod.GET)
    public String listPage(Model model ,@PathVariable(name = "id") Long id) {
        model.addAttribute("tasks", service.getAllTasks(id));
        return "task/list";

    }


    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("tasks",service.getAll(new GenericCriteria()));
        return "task/create";
    }



    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String updatePage() {
        return "task/update";
    }


    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute TaskUpdateDto dto) {
        service.update(dto);
        return "task/update";
    }


    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "task/update";
    }


}
