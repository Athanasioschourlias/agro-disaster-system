package gr.hua.dit.agrodisastersystem.repository;

import gr.hua.dit.agrodisastersystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLastName(String lastName);

    User findByTinNumber(int tin);



}
