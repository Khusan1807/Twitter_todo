package uz.nb.simple_trello.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import uz.nb.simple_trello.dto.base.GenericDto;
import uz.nb.simple_trello.entity.organization.Organization;

import javax.persistence.Column;
import java.time.LocalDateTime;


@Setter
@Getter
public class ProjectDto extends GenericDto {
    private String name;
    private String description;
    private Long organizationId;
    private String tz;
    private boolean closed;
    private LocalDateTime deadline;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP default NOW()")
    private LocalDateTime createdAt;

    @Builder(builderMethodName = "childBuilder")
    public ProjectDto(Long id, String name, Long organizationId, String description, boolean closed, String tz) {
        super(id);
        this.name = name;
        this.description = description;
        this.organizationId = organizationId;
        this.closed = closed;
        this.tz = tz;
    }
}
