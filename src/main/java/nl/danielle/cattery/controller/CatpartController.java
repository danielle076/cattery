package nl.danielle.cattery.controller;

import nl.danielle.cattery.model.Catpart;
import nl.danielle.cattery.service.CatpartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catparts")
public class CatpartController {

    final CatpartService catPartService;

    public CatpartController(CatpartService catPartService) {
        this.catPartService = catPartService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Object> getAllCatParts() {
        List<Catpart> catparts = catPartService.getAllCatParts();
        return new ResponseEntity<>(catparts, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getcatPartById(@PathVariable("id") long id) {
        Catpart catPart = catPartService.getCatPartById(id);
        return new ResponseEntity<>(catPart, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Object> saveCatpart(@RequestBody Catpart catPart) {
        Long newId = catPartService.saveCatpart(catPart);
        return new ResponseEntity<>(newId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCatpartById(@PathVariable("id") int id, @RequestBody Catpart catPart) {
        Catpart savedCatpart = catPartService.updateCatpartById(id, catPart);
        return new ResponseEntity<>(savedCatpart, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCatpart(@PathVariable("id") long id) {
        catPartService.deleteCatpart(id);
        return new ResponseEntity<>("Catpart with ID: " + id + " deleted", HttpStatus.OK);
    }
}

