package gr.hua.dit.agrodisastersystem.service;

import gr.hua.dit.agrodisastersystem.model.CompensationReqForm;

import gr.hua.dit.agrodisastersystem.model.User;
import gr.hua.dit.agrodisastersystem.repository.CompensationReqFormRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

@Service
public class CompensationReqFormService {

    @Autowired
    private CompensationReqFormRepository CompensationReqFormRepository;

    @Autowired
    private gr.hua.dit.agrodisastersystem.repository.UserRepository UserRepository;

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

    @Transactional
    public ResponseEntity<String> deleteCompensationReqForm(String userTinNumber, int FormId){

        //Fetching all the forms the farmer with FarmerTin owns.
        List<CompensationReqForm> forms = CompensationReqFormRepository.findAllFormsByUserTinNumber(userTinNumber);

        if(forms.isEmpty())
            return new ResponseEntity<>("There is no forms registered for the user with TIN number: " + userTinNumber  , HttpStatus.NOT_FOUND);

        // Getting ListIterator
        ListIterator<CompensationReqForm> namesIterator
                = forms.listIterator();

        // Traversing elements using next() method
        while (namesIterator.hasNext()) {
            CompensationReqForm form = namesIterator.next();
            //Checking to find the form the user wants to edit
            if (form.getId() == FormId){

                CompensationReqFormRepository.deleteCompensationReqFormById(form.getId());
                return new ResponseEntity<>("The form was Deleted successfully", HttpStatus.OK);

            }

        }


        return new ResponseEntity<>("There is no form with the given id in our system please try again", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<CompensationReqForm> getCompensationReqFormById(int FormId){

        CompensationReqForm form = CompensationReqFormRepository.findCompensationReqFormById(FormId);

        if (form != null) {
            return new ResponseEntity<>(form, HttpStatus.OK);

        } else {
            // Handle the case where the user with the given TIN number is not found
            // You might want to throw an exception or handle it based on your requirements
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<CompensationReqForm> replaceFormById(int FormId, String FarmerTin, CompensationReqForm NewForm){

        //Fetching all the forms the farmer with FarmerTin owns.
        List<CompensationReqForm> forms = CompensationReqFormRepository.findAllFormsByUserTinNumber(FarmerTin);

        if(forms.isEmpty())
            return new ResponseEntity<>(null, HttpStatus.OK);

        // Getting ListIterator
        ListIterator<CompensationReqForm> namesIterator
                = forms.listIterator();

        // Traversing elements using next() method
        while (namesIterator.hasNext()) {
            CompensationReqForm form = namesIterator.next();
            //Checking to find the form the user wants to edit
            if (form.getId() == FormId){

                if(form.equals(NewForm)){

                    return new ResponseEntity<>(form, HttpStatus.OK);

                }


            }

        }
//        for (CompensationReqForm form : req_form) {
//            if (form.getId() == FormId){
//
//
////                .map(address -> {
//                    address.setCity(newAddress.getCity());
//                    address.setPin(newAddress.getPostalCode());
//                    return repository.save(address);
//                })
//                .orElseGet(() -> {
//                    return repository.save(newAddress);
//                });
//                return new ResponseEntity<>(form, HttpStatus.OK);

//            }
//        }
        return new ResponseEntity<>(null, HttpStatus.OK);


    }
}


