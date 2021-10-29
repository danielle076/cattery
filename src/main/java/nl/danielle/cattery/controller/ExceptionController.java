package nl.danielle.cattery.controller;

import nl.danielle.cattery.exception.DuplicateRecordInDatabase;
import nl.danielle.cattery.exception.RecordNotFoundException;
import nl.danielle.cattery.exception.StatusErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> exception(RecordNotFoundException exception){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = DuplicateRecordInDatabase.class)
    public ResponseEntity<Object> exception(DuplicateRecordInDatabase exception){
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = StatusErrorException.class)
    public ResponseEntity<Object> exception(StatusErrorException exception){
        return new ResponseEntity<>("Wrong status for this action", HttpStatus.CONFLICT);
    }
}
