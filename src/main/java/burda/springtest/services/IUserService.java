package burda.springtest.services;

import burda.springtest.dto.UserDto;
import burda.springtest.exceptions.EmailExistsException;
import org.springframework.security.core.userdetails.User;

public interface IUserService {

    User registerNewUserAccount(UserDto accountDto)
                throws EmailExistsException;

}
