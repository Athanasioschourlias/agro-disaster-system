package gr.hua.dit.agrodisastersystem.service;

import gr.hua.dit.agrodisastersystem.model.CompensationReqForm;

import gr.hua.dit.agrodisastersystem.model.User;
import gr.hua.dit.agrodisastersystem.repository.CompensationReqFormRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompensationReqFormService {

    @Autowired
    private CompensationReqFormRepository CompensationReqFormRepository;

    @Autowired
    private gr.hua.dit.agrodisastersystem.repository.UserRepository UserRepository;

    public List<CompensationReqForm> findAllForms(){
        return CompensationReqFormRepository.findAll();
    }

    public List<CompensationReqForm> findByFarmerTIN(int user_tin) {

        return CompensationReqFormRepository.findByUserTinNumber(user_tin);
    }

    public void addForm(CompensationReqForm form, int userTinNumber) {
        // Retrieve the user from the database based on TIN number
        User user = UserRepository.findByTinNumber(userTinNumber);

        if (user != null) {
            // Associate the form with the user
            form.setUser(user);
            // Save the form to the database
            CompensationReqFormRepository.save(form);
        } else {
            // Handle the case where the user with the given TIN number is not found
            // You might want to throw an exception or handle it based on your requirements
        }
    }

}
