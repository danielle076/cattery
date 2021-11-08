package nl.danielle.cattery.service;

import nl.danielle.cattery.exceptions.DatabaseErrorException;
import nl.danielle.cattery.exceptions.RecordNotFoundException;
import nl.danielle.cattery.model.Kitten;
import nl.danielle.cattery.model.KittenBuilder;
import nl.danielle.cattery.model.Price;
import nl.danielle.cattery.payload.KittenRequest;
import nl.danielle.cattery.repository.KittenRepository;
import nl.danielle.cattery.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class KittenServiceImpl implements KittenService {

    final KittenRepository kittenRepository;

    final PriceRepository priceRepository;

    public KittenServiceImpl(KittenRepository kittenRepository, PriceRepository priceRepository) {
        this.kittenRepository = kittenRepository;
        this.priceRepository = priceRepository;
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
    public long saveKitten(KittenRequest kittenRequest) {

        Kitten kitten = new KittenBuilder(kittenRequest).buildKitten();
        Price price = new KittenBuilder(kittenRequest).buildPrice();

        Price savedPrice = priceRepository.save(price);
        kitten.setPrice(savedPrice);
        price.setKitten(kitten);

        return kittenRepository.save(kitten).getId();
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

