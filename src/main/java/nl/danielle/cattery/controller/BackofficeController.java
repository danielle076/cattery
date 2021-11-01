package nl.danielle.cattery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/backoffice")
public class BackofficeController {

    @GetMapping(value = "")
    public ResponseEntity<Object> getBackoffice() {
        return ResponseEntity.ok().body("/backoffice endpoint available for BACKOFFICE only!");
    }
}
