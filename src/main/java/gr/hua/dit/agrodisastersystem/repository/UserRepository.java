package gr.hua.dit.agrodisastersystem.repository;

import gr.hua.dit.agrodisastersystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByTinNumber(String tin);


}
