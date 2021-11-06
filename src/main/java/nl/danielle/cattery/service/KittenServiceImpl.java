package nl.danielle.cattery.service;

import nl.danielle.cattery.exceptions.DatabaseErrorException;
import nl.danielle.cattery.exceptions.RecordNotFoundException;
import nl.danielle.cattery.model.Kitten;
import nl.danielle.cattery.repository.KittenRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class KittenServiceImpl implements KittenService {

    final KittenRepository kittenRepository;

    public KittenServiceImpl(KittenRepository kittenRepository) {
        this.kittenRepository = kittenRepository;
    }

    @Override
    public Collection<Kitten> getKittens() {
        return kittenRepository.findAll();
    }

    @Override
    public Kitten getKittenById(long id) {
        if (!kittenRepository.existsById(id)) {
            throw new RecordNotFoundException();
        }
        return kittenRepository.findById(id).orElse(null);
    }

    @Override
    public long saveKitten(Kitten kitten) {
        Kitten newKitten = kittenRepository.save(kitten);
        return newKitten.getId();
    }

    @Override
    public void updateKitten(long id, Kitten kitten) {
        if (kittenRepository.existsById(id)) {
            try {
                Kitten existingKitten = kittenRepository.findById(id).orElse(null);
                existingKitten.setName(kitten.getName());
                existingKitten.setDateOfBirth(kitten.getDateOfBirth());
                existingKitten.setWeight(kitten.getWeight());
                existingKitten.setBreed(kitten.getBreed());
                existingKitten.setFirstVaccination(kitten.getFirstVaccination());
                existingKitten.setSecondVaccination(kitten.getSecondVaccination());
                kittenRepository.save(existingKitten);
            } catch (Exception ex) {
                throw new DatabaseErrorException();
            }
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void deleteKitten(long id) {
        kittenRepository.deleteById(id);
    }
}

