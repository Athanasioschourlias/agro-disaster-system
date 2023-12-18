package gr.hua.dit.agrodisastersystem.service;

import gr.hua.dit.agrodisastersystem.model.CompensationReqForm;
import gr.hua.dit.agrodisastersystem.payload.response.Forms;
import gr.hua.dit.agrodisastersystem.repository.CompensationReqFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompensationReqFormService {

    @Autowired
    private CompensationReqFormRepository CompensationReqFormRepository;

    public List<CompensationReqForm> findAllForms(){
        return CompensationReqFormRepository.findAll();
    }

    public List<CompensationReqForm> findByFarmerTIN(int TIN) {return CompensationReqFormRepository.findByFarmerTIN(TIN);}
}
