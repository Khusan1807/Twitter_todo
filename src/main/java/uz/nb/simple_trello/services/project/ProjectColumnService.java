package uz.nb.simple_trello.services.project;

import uz.nb.simple_trello.criteria.GenericCriteria;
import uz.nb.simple_trello.dto.project.ProjectColumnCreateDto;
import uz.nb.simple_trello.dto.project.ProjectColumnDto;
import uz.nb.simple_trello.dto.project.ProjectColumnUpdateDto;
import uz.nb.simple_trello.dto.project.ProjectDto;
import uz.nb.simple_trello.entity.project.ProjectColumn;
import uz.nb.simple_trello.services.base.GenericCrudService;

import java.util.List;


public interface ProjectColumnService extends GenericCrudService<
        ProjectColumnDto,
        ProjectColumnCreateDto,
        ProjectColumnUpdateDto,
        GenericCriteria,
        Long
        > {
//    List<ProjectDto> getAllProjects(Long id);
  List<ProjectColumnDto> getAllProjects(Long id);
}

