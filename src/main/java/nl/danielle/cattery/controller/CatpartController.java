package nl.danielle.cattery.controller;

import nl.danielle.cattery.model.Catpart;
import nl.danielle.cattery.service.CatpartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/catparts")
public class CatpartController {

    final CatpartService catpartService;

    public CatpartController(CatpartService catPartService) {
        this.catpartService = catPartService;
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getCatparts() {
        return ResponseEntity.ok().body(catpartService.getCatparts());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCatpartById(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(catpartService.getCatpartById(id));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Object> saveCatpart(@RequestBody Catpart catpart) {
        long newId = catpartService.saveCatpart(catpart);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCatpartById(@PathVariable("id") long id, @RequestBody Catpart catpart) {
        catpartService.updateCatpartById(id, catpart);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCatpart(@PathVariable("id") long id) {
        catpartService.deleteCatpart(id);
        return ResponseEntity.ok().build();
    }
}

