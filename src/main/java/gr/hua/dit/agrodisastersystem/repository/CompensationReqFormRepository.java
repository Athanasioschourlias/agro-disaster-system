package gr.hua.dit.agrodisastersystem.repository;

import gr.hua.dit.agrodisastersystem.model.CompensationReqForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface CompensationReqFormRepository extends JpaRepository<CompensationReqForm, String> {

    List<CompensationReqForm> findByUserTinNumber(String user_tin);

    @Query("SELECT c FROM CompensationReqForm c WHERE c.user.tinNumber = :tinNumber")
    List<CompensationReqForm> findAllFormsByUserTinNumber(@Param("tinNumber") String tinNumber);

    CompensationReqForm findCompensationReqFormById(int from_id);
    void deleteCompensationReqFormById(int form_id);

    List<CompensationReqForm> findCompensationReqFormByStatusNot(String status);

    List<CompensationReqForm> findCompensationReqFormByStatus(String status);
}
