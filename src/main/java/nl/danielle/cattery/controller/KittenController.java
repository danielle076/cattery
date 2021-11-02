package nl.danielle.cattery.controller;

import nl.danielle.cattery.model.Kitten;
import nl.danielle.cattery.service.KittenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/kittens")
public class KittenController {

    private final KittenService kittenService;

    public KittenController(KittenService kittenService) {
        this.kittenService = kittenService;
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getKittens() {
        return ResponseEntity.ok().body(kittenService.getKittens());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getKitten(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(kittenService.getKittenById(id));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Object> saveKitten(@RequestBody Kitten kitten) {
        long newId = kittenService.saveKitten(kitten);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateKitten(@PathVariable("id") long id, @RequestBody Kitten kitten) {
        kittenService.updateKitten(id, kitten);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteKitten(@PathVariable("id") long id) {
        kittenService.deleteKitten(id);
        return ResponseEntity.noContent().build();
    }
}
