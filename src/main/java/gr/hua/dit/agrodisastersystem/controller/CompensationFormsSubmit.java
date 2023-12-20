package gr.hua.dit.agrodisastersystem.controller;

import gr.hua.dit.agrodisastersystem.model.CompensationReqForm;
import gr.hua.dit.agrodisastersystem.service.CompensationReqFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/farmer/compensation")
@CrossOrigin(origins="*")
public class CompensationFormsSubmit {

    @Autowired
    private CompensationReqFormService CompensationReqFormService;

    /**
     * This method is responsible to validate the tin number given as a path variable and to create a list with all the forms
     * the given farmer with the given tin number, farmer_tin has submitted.
     *
     * @param  FarmerTin  A valid farmer tin number
     *
     * @return A list with all the farmers forms
     */
    @GetMapping("/get-forms/{farmer_tin}")
    public List<CompensationReqForm> getAllFormsForFarmer(@PathVariable("farmer_tin") String FarmerTin) {

        return CompensationReqFormService.findByFarmerTIN(FarmerTin);

    }

    /**
     * This method is responsible to validate the json object and add a new entry(form) to the database
     *
     * @param  FarmerTin  A vaid farmet tin number
     * @param  form A json object with the type of Form
     *
     * @return on success the newly created form object.
     */
    @PostMapping(path = "/create/form/{farmer_tin}")
    public ResponseEntity<String> saveNewForm(@PathVariable("farmer_tin") String FarmerTin, @RequestBody CompensationReqForm form ) {
        try {

            return CompensationReqFormService.addForm(form, FarmerTin);

        } catch (Exception e){

            return new ResponseEntity<>("Can not Add the form", HttpStatus.EXPECTATION_FAILED);

        }
    }

    /**
     * This method is responsible to take the json object from the request, renew the old form object that is in the database with the new one
     * and make sure a regular user(farmer) can only edit his forms
     *
     * @param  FormId  A vaid farmet tin number
     * @param  Form    A Form type object
     *
     * @return A Form type json object of the newly added form to the database
     */
    @PutMapping("/edit/form/{form_id}/{farmer_tin}")
    public ResponseEntity<CompensationReqForm> updateFormById(
            @PathVariable("form_id") int FormId,
            @PathVariable("farmer_tin") String FarmerTin,
            @RequestBody CompensationReqForm Form)
    {

        return CompensationReqFormService.replaceFormById(FormId,FarmerTin,Form);

    }

    /**
     * This method is responsible to check if the form belongs to the farmer and then if it does to delete it
     *
     * @param  FarmerTin  A vaid farmet tin number
     * @param  FormId The id number of the form the user tries to delete
     *
     * @return on success a message reassuring the success of the deletion
     */
    @DeleteMapping ("/delete/form/{form_id}/{farmer_tin}")
    public ResponseEntity<String> deleteFormById(@PathVariable("form_id") String FormId, @PathVariable("farmer_tin") String FarmerTin) {

        try {

            return CompensationReqFormService.deleteCompensationReqForm(FarmerTin, FormId);

        } catch (Exception e){

            return new ResponseEntity<>("Can not Delete the form", HttpStatus.EXPECTATION_FAILED);

        }

    }

}
