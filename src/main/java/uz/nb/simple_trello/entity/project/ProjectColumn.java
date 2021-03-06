package uz.nb.simple_trello.entity.project;

import lombok.Getter;
import lombok.Setter;
import uz.nb.simple_trello.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;


@Setter
@Getter
@Entity
public class ProjectColumn extends Auditable {
    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "project_id", nullable = false)
    private Long projectId;

    private int position;

    private boolean active;

    @Column(columnDefinition = " timestamp ")
    private LocalDateTime deadline;

}
