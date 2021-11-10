package nl.danielle.cattery.service;

import nl.danielle.cattery.exception.DatabaseErrorException;
import nl.danielle.cattery.exception.RecordNotFoundException;
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
        return kittenRepository.findById(id).orElseThrow(() -> new RecordNotFoundException());
    }

    @Override
    public long saveKitten(KittenRequest kittenRequest) {

        Kitten newKitten = new KittenBuilder(kittenRequest).buildKitten();
        Price newPrice = new KittenBuilder(kittenRequest).buildPrice();

        Price savedPrice = priceRepository.save(newPrice);
        newKitten.setPrice(savedPrice);
        newPrice.setKitten(newKitten);

        return kittenRepository.save(newKitten).getId();
    }

    @Override
    public void updateKitten(long id, KittenRequest kittenRequest) {
        if (kittenRepository.existsById(id)) {
            try {
                Kitten existingKitten = kittenRepository.findById(id).orElse(null);
                Price existingPrice = priceRepository.findById(id).orElse(null);
                existingKitten.setName(kittenRequest.getName());
                existingKitten.setDateOfBirth(kittenRequest.getDateOfBirth());
                existingKitten.setWeight(kittenRequest.getWeight());
                existingKitten.setBreed(kittenRequest.getBreed());
                existingKitten.setFirstVaccination(kittenRequest.getFirstVaccination());
                existingKitten.setSecondVaccination(kittenRequest.getSecondVaccination());
                existingPrice.setBreedPrice(kittenRequest.getBreedPrice());
                existingPrice.setFirstVaccinationPrice(kittenRequest.getFirstVaccinationPrice());
                existingPrice.setSecondVaccinationPrice(kittenRequest.getSecondVaccinationPrice());
                kittenRepository.save(existingKitten);
                priceRepository.save(existingPrice);
            } catch (Exception ex) {
                throw new DatabaseErrorException();
            }
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void deleteKitten(long id) {
        if (kittenRepository.existsById(id)) {
            kittenRepository.deleteById(id);
            priceRepository.deleteById(id);

        } else {
            throw new RecordNotFoundException();
        }
    }
}