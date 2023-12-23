package gr.hua.dit.agrodisastersystem.service;

import gr.hua.dit.agrodisastersystem.model.CompensationReqForm;
import gr.hua.dit.agrodisastersystem.model.User;
import gr.hua.dit.agrodisastersystem.repository.CompensationReqFormRepository;
import gr.hua.dit.agrodisastersystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompensationReqFormService {

    @Autowired
    private CompensationReqFormRepository CompensationReqFormRepository;

    @Autowired
    private UserRepository UserRepository;

    public List<CompensationReqForm> findAllForms(){
        return CompensationReqFormRepository.findAll();
    }

    public List<CompensationReqForm> findByFarmerTIN(String user_tin) {
        return CompensationReqFormRepository.findByUserTinNumber(user_tin);
    }

    public ResponseEntity<String> addForm(CompensationReqForm form, String userTinNumber) {

        //TODO- Add equals so you can not add the same form two times.

        // Retrieve the user from the database based on TIN number
        User user = UserRepository.findByTinNumber(userTinNumber);

        if (user != null) {
            // Associate the form with the user
            form.setUser(user);
            // Save the form to the database
            CompensationReqFormRepository.save(form);

            return new ResponseEntity<>("The form was added", HttpStatus.OK);

        } else {
            // Handle the case where the user with the given TIN number is not found
            // You might want to throw an exception or handle it based on your requirements
            return new ResponseEntity<>("There is no user with this TIN", HttpStatus.NOT_FOUND);
        }
    }

    //This method lets employees delete forms by id.
    @Transactional
    public ResponseEntity<String> deleteCompensationReqForm(int FormId){

        CompensationReqFormRepository.deleteCompensationReqFormById(
                CompensationReqFormRepository.findCompensationReqFormById(FormId)
                        .getId()
        );

        return new ResponseEntity<>("The form was Deleted successfully", HttpStatus.OK);

    }
    public ResponseEntity<CompensationReqForm> findByCompensationReqFormById(int FormId){

        CompensationReqForm form = CompensationReqFormRepository.findCompensationReqFormById(FormId);

        if (form != null) {
            return new ResponseEntity<>(form, HttpStatus.OK);

        } else {
            // Handle the case where the user with the given TIN number is not found
            // You might want to throw an exception or handle it based on your requirements
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    private boolean checkChanges(CompensationReqForm NewForm, CompensationReqForm form) {
        if (form.equals(NewForm)) {
            return true;
        }

        form.setLocation(NewForm.getLocation());
        form.setDamageDescription(NewForm.getDamageDescription());
        form.setAcres(NewForm.getAcres());
        form.setCropType(NewForm.getCropType());
        form.setStatus(NewForm.getStatus());

        CompensationReqFormRepository.save(form);
        return false;
    }

    //This method can edit forms that do not belong to the user, and is meant to be used by the employees.
    public ResponseEntity<String> replaceFormById(int FormId, CompensationReqForm NewForm){

        CompensationReqForm old_form = CompensationReqFormRepository.findCompensationReqFormById(FormId);


        if (old_form.getId() == FormId){

            if (checkChanges(NewForm, old_form))
                return new ResponseEntity<>("There no details changed, edit at least one filed", HttpStatus.OK);

            return  new ResponseEntity<>("The Form was modified successfully", HttpStatus.OK);

        }

        return new ResponseEntity<>("There is no form with this ID", HttpStatus.OK);


    }

    public ResponseEntity<List<CompensationReqForm>> getUnprocessedForms(){


        List<CompensationReqForm> forms = CompensationReqFormRepository.findCompensationReqFormByStatus(CompensationReqForm.FormStatus.PENDING);

        if(forms.isEmpty())
            return new ResponseEntity<>(null  , HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(forms , HttpStatus.OK);


    }

    public ResponseEntity<List<CompensationReqForm>> getProcessedForms(){


        List<CompensationReqForm> forms = CompensationReqFormRepository.findCompensationReqFormByStatusNot(CompensationReqForm.FormStatus.PENDING);

        if(forms.isEmpty())
            return new ResponseEntity<>(null  , HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(forms , HttpStatus.OK);


    }
}


