package gr.hua.dit.agrodisastersystem.repository;

import gr.hua.dit.agrodisastersystem.model.CompensationReqForm;
import gr.hua.dit.agrodisastersystem.payload.response.Forms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompensationReqFormRepository extends JpaRepository<CompensationReqForm, String> {

    List<CompensationReqForm> findByFarmerTIN(int TinNumber);

}
