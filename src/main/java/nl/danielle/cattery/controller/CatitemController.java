package nl.danielle.cattery.controller;

import nl.danielle.cattery.model.Catitem;
import nl.danielle.cattery.service.CatitemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/catitems")
public class CatitemController {

    final CatitemService catitemService;

    public CatitemController(CatitemService catitemService) {
        this.catitemService = catitemService;
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getCatitems() {
        return ResponseEntity.ok().body(catitemService.getCatitems());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCatitemById(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(catitemService.getCatitemById(id));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Object> saveCatitem(@RequestBody Catitem catitem) {
        long newId = catitemService.saveCatitem(catitem);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body("Added new item");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCatitemById(@PathVariable("id") long id, @RequestBody Catitem catitem) {
        catitemService.updateCatitemById(id, catitem);
        return ResponseEntity.ok().body("Updated item: " + id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCatitem(@PathVariable("id") long id) {
        catitemService.deleteCatitem(id);
        return ResponseEntity.ok().body("Deleted item: " + id);
    }
}
