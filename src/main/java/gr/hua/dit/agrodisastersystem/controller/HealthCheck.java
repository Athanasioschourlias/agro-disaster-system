package gr.hua.dit.agrodisastersystem.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@CrossOrigin(origins="*")
public class HealthCheck {

    @GetMapping("/check")
    public String health_check() {
        return "Hello, im alive";
    }

}
