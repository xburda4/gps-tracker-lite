package burda.springtest.repositories;


import burda.springtest.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDto, String> {

    User findByNick(String nick);

    User findByEmail(String email);
}
