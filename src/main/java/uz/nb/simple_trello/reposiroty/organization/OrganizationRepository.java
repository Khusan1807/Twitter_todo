package uz.nb.simple_trello.reposiroty.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.nb.simple_trello.entity.organization.Organization;
import uz.nb.simple_trello.reposiroty.base.AbstractRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long>, AbstractRepository {

}
