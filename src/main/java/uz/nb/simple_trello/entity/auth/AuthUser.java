package uz.nb.simple_trello.entity.auth;

import lombok.Getter;
import lombok.Setter;
import uz.nb.simple_trello.entity.base.Auditable;
import uz.nb.simple_trello.entity.organization.Organization;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Setter
@Getter
public class AuthUser extends Auditable {

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    //    @Column(columnDefinition = "default false")
    private boolean isSuperUser;
    //
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "organization_id", nullable = true)
    private Long organizationId;

    @Column(nullable = false)
    private UUID code;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "role_id", nullable = true)
    private AuthRole role;

    private boolean active = true;

    private boolean blocked;

//    @Column(nullable = false )
//    private String email;
//
//
//    private boolean isSuperUser;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "organization_id", nullable = false)
//    private Organization organizationId;

}
