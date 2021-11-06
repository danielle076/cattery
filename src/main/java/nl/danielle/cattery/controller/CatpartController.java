package nl.danielle.cattery.controller;

import nl.danielle.cattery.model.Catpart;
import nl.danielle.cattery.service.CatpartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catparts")
public class CatpartController {

    @Autowired
    CatpartService catPartService;

    //get a listing of all the catparts
    @GetMapping(value = "/list")
    public ResponseEntity<Object> getAllCatParts(){
        List<Catpart> catparts = catPartService.getAllCatParts();
        return new ResponseEntity<>(catparts, HttpStatus.OK);
    }

    //get a catpart by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getcatPartById(@PathVariable("id") long id){
        Catpart catPart =  catPartService.getCatPartById(id);
        return new ResponseEntity<>(catPart, HttpStatus.OK);
    }

    //add a new catpart
    @PostMapping(value = "/add")
    public ResponseEntity<Object> saveCatpart(@RequestBody Catpart catPart){
        Long newId = catPartService.saveCatpart(catPart);
        return new ResponseEntity<>(newId, HttpStatus.CREATED);
    }

    //update catpart by id and body
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCatpartById(@PathVariable("id") int id, @RequestBody Catpart catPart){
        Catpart savedCatpart = catPartService.updateCatpartById(id, catPart);
        return new ResponseEntity<>(savedCatpart,HttpStatus.OK);
    }

    //delete catpart
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCatpart(@PathVariable("id") long id){
        catPartService.deleteCatpart(id);
        return new ResponseEntity<>("Catpart with ID: " + id + " deleted", HttpStatus.OK);
    }
}

