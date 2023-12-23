package gr.hua.dit.agrodisastersystem.controller;

import gr.hua.dit.agrodisastersystem.model.CompensationReqForm;
import gr.hua.dit.agrodisastersystem.service.CompensationReqFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/manager")
@CrossOrigin(origins="*")
@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
public class FormManager {

    @Autowired
    private CompensationReqFormService CompensationReqFormService;
    /**
     * This method is responsible to fetch all the forms in the system available, processed and unprocessed
     *
     *
     * @return A list with all the available forms
     */
    @GetMapping("/get-forms/all")
    public List<CompensationReqForm> getAllForms() {
        return CompensationReqFormService.findAllForms();
    }

    /**
     * This method is responsible to fetch all the processed forms in the system
     *
     *
     * @return A list with all the processed forms
     */
    @GetMapping("/get-forms/processed")
    public ResponseEntity<List<CompensationReqForm>> getAllProcessedForms() {

        return CompensationReqFormService.getProcessedForms();

    }

    /**
     * This method is responsible to fetch all the un-processed forms in the system
     *
     *
     * @return A list with all the un-processed forms
     */
    @GetMapping("/get-forms/pending")
    public ResponseEntity<List<CompensationReqForm>> getAllUnProcessedForms() {

        return CompensationReqFormService.getUnprocessedForms();

    }

    /**
     * This method is responsible to validate the json object to be of type Form and then add it to the database and handle any errors.
     *
     * @param  FormId  A valid form id number
     * @param  Form    A Form type object
     *
     * @return A Form type json object of the newly added form to the database
     */
    @PutMapping("/edit/form/{form_id}")
    public ResponseEntity<String> updateFormById(@PathVariable("form_id") int FormId, @RequestBody CompensationReqForm Form) {
        return CompensationReqFormService.replaceFormById(FormId, Form);
    }

    /**
     * This method is responsible to validate the id that exists,
     * and then delete the form from the database and handle possible errors
     *
     * @param  FormId  A valid form id.
     *
     * @return A Form type json object of the newly added form to the database
     */
    @DeleteMapping ("/delete/form/{form_id}")
    public ResponseEntity<String> deleteFormById(@PathVariable("form_id") int FormId) {
        try {
            return CompensationReqFormService.deleteCompensationReqForm(FormId);
        } catch (Exception e){
            return new ResponseEntity<>("Can not Delete the form", HttpStatus.EXPECTATION_FAILED);
        }
    }

}
