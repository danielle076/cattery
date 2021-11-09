package nl.danielle.cattery.service;

import nl.danielle.cattery.model.Kitten;
import nl.danielle.cattery.payload.KittenRequest;

import java.util.Collection;

public interface KittenService {
    Collection<Kitten> getKittens();
    Kitten getKittenById(long id);
    long saveKitten(KittenRequest kittenRequest);
    void updateKitten(long id, KittenRequest kittenRequest);
    void deleteKitten(long id);
}
