package nl.danielle.cattery.service;

import nl.danielle.cattery.exceptions.DatabaseErrorException;
import nl.danielle.cattery.exceptions.RecordNotFoundException;
import nl.danielle.cattery.model.Catpart;
import nl.danielle.cattery.repository.CatpartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatpartServiceImpl implements CatpartService {

    final CatpartRepository catpartRepository;

    public CatpartServiceImpl(CatpartRepository catpartRepository) {
        this.catpartRepository = catpartRepository;
    }

    public List<Catpart> getCatparts() {
        return catpartRepository.findAll();
    }

    @Override
    public Catpart getCatpartById(long id) {

        if (catpartRepository.existsById(id)) {
            return catpartRepository.findById(id).orElse(null);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public long saveCatpart(Catpart catpart) {
        return catpartRepository.save(catpart).getId();
    }

    @Override
    public Catpart updateCatpartById(long id, Catpart catpart) {
        if (catpartRepository.existsById(id)) {
            try {
                Catpart existingKitten = catpartRepository.findById(id).orElse(null);
                existingKitten.setDescription(catpart.getDescription());
                existingKitten.setPrice(catpart.getPrice());
                catpartRepository.save(existingKitten);
            } catch (Exception ex) {
                throw new DatabaseErrorException();
            }
        } else {
            throw new RecordNotFoundException();
        }
        return catpart;
    }

    @Override
    public void deleteCatpart(long id) {
        if (catpartRepository.existsById(id)) {
            catpartRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException();
        }
    }
}