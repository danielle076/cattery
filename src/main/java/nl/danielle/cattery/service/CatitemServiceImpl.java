package nl.danielle.cattery.service;

import nl.danielle.cattery.exception.DatabaseErrorException;
import nl.danielle.cattery.exception.RecordNotFoundException;
import nl.danielle.cattery.model.Catitem;
import nl.danielle.cattery.repository.CatitemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatitemServiceImpl implements CatitemService {

    final CatitemRepository catitemRepository;

    public CatitemServiceImpl(CatitemRepository catitemRepository) {
        this.catitemRepository = catitemRepository;
    }

    public List<Catitem> getCatitems() {
        return catitemRepository.findAll();
    }

    @Override
    public Catitem getCatitemById(long id) {

        if (catitemRepository.existsById(id)) {
            return catitemRepository.findById(id).orElse(null);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public long saveCatitem(Catitem catitem) {
        return catitemRepository.save(catitem).getId();
    }

    @Override
    public Catitem updateCatitemById(long id, Catitem catitem) {
        if (catitemRepository.existsById(id)) {
            try {
                Catitem existingKitten = catitemRepository.findById(id).orElse(null);
                existingKitten.setDescription(catitem.getDescription());
                existingKitten.setPrice(catitem.getPrice());
                catitemRepository.save(existingKitten);
            } catch (Exception ex) {
                throw new DatabaseErrorException();
            }
        } else {
            throw new RecordNotFoundException();
        }
        return catitem;
    }

    @Override
    public void deleteCatitem(long id) {
        if (catitemRepository.existsById(id)) {
            catitemRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException();
        }
    }
}