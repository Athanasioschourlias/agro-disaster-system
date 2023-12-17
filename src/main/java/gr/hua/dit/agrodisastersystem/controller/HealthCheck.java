package gr.hua.dit.agrodisastersystem.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/health")
@CrossOrigin(origins="*")
public class HealthCheck {

    /**
     * This is an endpoint used only for a quick and dirty way to know your up is up and running
     *
     * @param   key this is the variable that will be returned in order to know the system is up and running.
     * @return  String Echo of the path variable in order to automate health checks.
     */
    @GetMapping("/check/{key}")
    public String health_check(@PathVariable("key") String key) {
        return key;
    }

}
