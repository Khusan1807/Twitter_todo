package uz.nb.simple_trello.reposiroty.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.nb.simple_trello.entity.task.Task;
import uz.nb.simple_trello.reposiroty.base.AbstractRepository;

import java.util.List;

/**
 * @Author Husan Narzullayev
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long>, AbstractRepository {

    List<Task> findTasksByProjectId(Long id);


}
