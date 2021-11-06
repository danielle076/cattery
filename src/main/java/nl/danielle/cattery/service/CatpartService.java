package nl.danielle.cattery.service;

import nl.danielle.cattery.exceptions.DatabaseErrorException;
import nl.danielle.cattery.exceptions.RecordNotFoundException;
import nl.danielle.cattery.model.Catpart;
import nl.danielle.cattery.repository.CatPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatpartService {

    @Autowired
    CatPartRepository catPartRepository;

    public List<Catpart> getAllCatParts() {
        return catPartRepository.findAll();
    }

    public Catpart getCatPartById(long id) {

        if (catPartRepository.existsById(id)) {
            return catPartRepository.findById(id).orElse(null);
        } else {
            throw new RecordNotFoundException();
        }
    }

    public Catpart updateCatpartById(long id, Catpart catpart) {
        if (catPartRepository.existsById(id)) {
            try {
                Catpart existingKitten = catPartRepository.findById(id).orElse(null);
                existingKitten.setDescription(catpart.getDescription());
                existingKitten.setPrice(catpart.getPrice());
                catPartRepository.save(existingKitten);
            } catch (Exception ex) {
                throw new DatabaseErrorException();
            }
        } else {
            throw new RecordNotFoundException();
        }
        return catpart;
    }

    public Long saveCatpart(Catpart catPart) {

        return catPartRepository.save(catPart).getId();
    }

    public void deleteCatpart(long id) {
        if (catPartRepository.existsById(id)) {
            catPartRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException();
        }
    }
}