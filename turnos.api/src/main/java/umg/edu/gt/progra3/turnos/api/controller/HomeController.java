package umg.edu.gt.progra3.turnos.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "API de Gestión de Turnos funcionando";
    }
}