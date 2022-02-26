package uz.nb.simple_trello.services.organization;

import uz.nb.simple_trello.criteria.GenericCriteria;
import uz.nb.simple_trello.dto.organization.OrganizationCreateDto;
import uz.nb.simple_trello.dto.organization.OrganizationDto;
import uz.nb.simple_trello.dto.organization.OrganizationUpdateDto;
import uz.nb.simple_trello.services.base.GenericCrudService;


public interface OrganizationService extends GenericCrudService<
        OrganizationDto,
        OrganizationCreateDto,
        OrganizationUpdateDto,
        GenericCriteria,
        Long> {
}
