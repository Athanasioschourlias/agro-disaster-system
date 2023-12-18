package gr.hua.dit.agrodisastersystem.controller;

import gr.hua.dit.agrodisastersystem.model.CompensationReqForm;
import gr.hua.dit.agrodisastersystem.model.User;
import gr.hua.dit.agrodisastersystem.payload.response.Forms;
import gr.hua.dit.agrodisastersystem.service.CompensationReqFormService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
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
    /**
     * This method is responsible to validate the tin number given as a path variable and to create a list with all the forms
     * the given farmer with the given tin number, farmer_tin has submitted.
     *
     * @param  FarmerTin  A vaid farmet tin number
     *
     * @return A list with all the farmers forms
     */
    @GetMapping("/get-forms/{farmer_tin}")
    public List<CompensationReqForm> getAllFormsForFarmer(@PathVariable("farmer_tin") int FarmerTin) {

        return CompensationReqFormService.findByFarmerTIN(FarmerTin);


    }

    /**
     * This method is responsible to validate the json object and add a new entry(form) to the database
     *
     * @param  FarmerTin  A vaid farmet tin number
     * @param  Form A json object with the type of Form
     *
     * @return on success the newly created form object.
     */
    @PostMapping(path = "/create/form/{farmer_tin}")
    public ResponseEntity<Forms> saveNewForm(@PathVariable("farmer_tin") String FarmerTin, @RequestBody Forms Form ) {

        throw new IllegalStateException("Not yet ready to add new forms");

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

        return new ResponseEntity<>("Can not delete form yet", HttpStatus.OK);
    }

}
