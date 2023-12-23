package gr.hua.dit.agrodisastersystem.controller;

import gr.hua.dit.agrodisastersystem.config.jwt.JwtUtils;
import gr.hua.dit.agrodisastersystem.model.CompensationReqForm;
import gr.hua.dit.agrodisastersystem.service.CompensationReqFormService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmer/compensation")
@CrossOrigin(origins="*")
public class CompensationFormsSubmit {

    @Autowired
    private CompensationReqFormService CompensationReqFormService;

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * This method is responsible to validate the tin number given as a path variable and to create a list with all the forms
     * the given farmer with the given tin number, farmer_tin has submitted.
     *
     * @param  request  The HTTP Request with the Token
     *
     * @return A list with all the farmers forms
     */
    @GetMapping("/get-forms")
    public List<CompensationReqForm> getAllFormsForFarmer(HttpServletRequest request) {
        String token = jwtUtils.extractJwtFromRequest(request);
        String farmerTin = jwtUtils.getUserNameFromJwtToken(token);
        return CompensationReqFormService.findByFarmerTIN(farmerTin);
    }

    /**
     * This method is responsible to validate the json object and add a new entry(form) to the database
     *
     * @param  request  The HTTP Request with the Token
     * @param  form A json object with the type of Form
     *
     * @return on success the newly created form object.
     */
    @PostMapping(path = "/create")
    public ResponseEntity<String> saveNewForm(HttpServletRequest request, @RequestBody CompensationReqForm form ) {
        try {
            String token = jwtUtils.extractJwtFromRequest(request);
            String farmerTin = jwtUtils.getUserNameFromJwtToken(token);
            form.setStatus(CompensationReqForm.FormStatus.PENDING); //Default for all new forms by farmers
            return CompensationReqFormService.addForm(form, farmerTin);
        } catch (Exception e){
            return new ResponseEntity<>("Can not Add the form", HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * This method is responsible to take the json object from the request, renew the old form object that is in the database with the new one
     * and make sure a regular user(farmer) can only edit his forms
     *
     * @param  formId  A valid farmer tin number
     * @param  form    A Form type object
     *
     * @return A Form type json object of the newly added form to the database
     */
    @PutMapping("/edit/form/{form_id}")
    public ResponseEntity<String> updateFormById(HttpServletRequest request, @PathVariable("form_id") int formId, @RequestBody CompensationReqForm form) {
        String token = jwtUtils.extractJwtFromRequest(request);
        String farmerTin = jwtUtils.getUserNameFromJwtToken(token);

        CompensationReqForm existingForm = CompensationReqFormService.findByCompensationReqFormById(formId).getBody();

        if (existingForm == null) {
            return new ResponseEntity<>("Form not found", HttpStatus.NOT_FOUND);
        }

        if (!existingForm.getUser().getTinNumber().equals(farmerTin)) {
            return new ResponseEntity<>("Unauthorized to edit this form", HttpStatus.UNAUTHORIZED);
        }

        return CompensationReqFormService.replaceFormById(formId, form);
    }

    /**
     * This method is responsible to check if the form belongs to the farmer and then if it does to delete it
     *
     * @param  formId The id number of the form the user tries to delete
     *
     * @return on success a message reassuring the success of the deletion
     */
    @DeleteMapping("/delete/form/{form_id}")
    public ResponseEntity<String> deleteFormById(HttpServletRequest request, @PathVariable("form_id") int formId) {
        try {
            String token = jwtUtils.extractJwtFromRequest(request);
            String farmerTin = jwtUtils.getUserNameFromJwtToken(token);

            CompensationReqForm form = CompensationReqFormService.findByCompensationReqFormById(formId).getBody();
            if (form == null) {
                return new ResponseEntity<>("Form not found", HttpStatus.NOT_FOUND);
            }

            if (!form.getUser().getTinNumber().equals(farmerTin)) {
                return new ResponseEntity<>("Unauthorized to delete this form", HttpStatus.UNAUTHORIZED);
            }

            return CompensationReqFormService.deleteCompensationReqForm(formId);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot Delete the form: " + e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }


}
