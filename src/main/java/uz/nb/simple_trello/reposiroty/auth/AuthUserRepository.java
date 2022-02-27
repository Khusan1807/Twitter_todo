package uz.nb.simple_trello.reposiroty.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.nb.simple_trello.entity.auth.AuthUser;
import uz.nb.simple_trello.reposiroty.base.AbstractRepository;

import java.util.List;
import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, AbstractRepository {
    Optional<AuthUser> findAuthUserByUsername(String username);


    AuthUser findAuthUserById(Long id);

    @Query("from AuthUser a order by a.id asc ")
    List<AuthUser> findAllUsers();

}
