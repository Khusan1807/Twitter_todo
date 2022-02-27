package uz.nb.simple_trello.services.auth;

import uz.nb.simple_trello.criteria.GenericCriteria;
import uz.nb.simple_trello.dto.auth.AuthUserCreateDto;
import uz.nb.simple_trello.dto.auth.AuthUserDto;
import uz.nb.simple_trello.dto.auth.AuthUserUpdateDto;
import uz.nb.simple_trello.dto.auth.LoginDto;
import uz.nb.simple_trello.entity.auth.AuthUser;
import uz.nb.simple_trello.services.base.GenericCrudService;

import java.util.List;

public interface AuthUserService extends GenericCrudService<
        AuthUserDto,
        AuthUserCreateDto,
        AuthUserUpdateDto,
        GenericCriteria,
        Long
        > {
    void login(LoginDto dto);
    List<AuthUserDto> usersList();

    Object getUsers();


//    AuthUser find(AuthUser authUser);

}
