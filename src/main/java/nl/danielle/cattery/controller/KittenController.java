package nl.danielle.cattery.controller;

import nl.danielle.cattery.model.FileUpload;
import nl.danielle.cattery.payload.request.KittenRequest;
import nl.danielle.cattery.payload.response.MessageResponse;
import nl.danielle.cattery.service.FileStorageServiceImpl;
import nl.danielle.cattery.service.KittenService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/kittens")
public class KittenController {

    final KittenService kittenService;

    final FileStorageServiceImpl storageService;

    public KittenController(KittenService kittenService, FileStorageServiceImpl storageService) {
        this.kittenService = kittenService;
        this.storageService = storageService;
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
    public ResponseEntity<Object> saveKitten(@RequestBody KittenRequest kittenRequest) {
        long newId = kittenService.saveKitten(kittenRequest);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body("Added new kitten");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateKitten(@PathVariable("id") long id, @RequestBody KittenRequest kittenRequest) {
        kittenService.updateKitten(id, kittenRequest);
        return ResponseEntity.ok().body("Updated kitten: " + id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteKitten(@PathVariable("id") long id) {
        kittenService.deleteKitten(id);
        return ResponseEntity.ok().body("Deleted kitten: " + id);
    }

    @PostMapping("/upload/kittenid/{id}")
    public ResponseEntity<MessageResponse> uploadFile(@PathVariable long id, @RequestParam("file") MultipartFile file) {

        try {
            storageService.store(file, id);

            String message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.ok().body(new MessageResponse(message));

        } catch (Exception e) {
            String message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.ok().body(new MessageResponse(message));
        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> getFileById(@PathVariable("id") String id) {
        FileUpload fileUpload = storageService.getFileById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileUpload.getName() + "\"")
                .body(fileUpload.getData());
    }
}