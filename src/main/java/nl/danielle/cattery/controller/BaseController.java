package nl.danielle.cattery.controller;

import nl.danielle.cattery.model.Info;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class BaseController {

    @GetMapping(value = "")
    public ResponseEntity<Object> index() {
        return ResponseEntity.ok().body("/user and /admin endpoints available");
    }

    @GetMapping(value = "/user", produces = {"application/json"})
    public String infoUser() {
        return Info.getInfoUser();
    }

    @GetMapping(value = "/admin", produces = {"application/json"})
    public String infoAdmin() {
        return Info.getInfoAdmin();
    }
}
