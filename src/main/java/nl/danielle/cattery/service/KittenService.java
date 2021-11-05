package nl.danielle.cattery.service;

import nl.danielle.cattery.model.Kitten;

import java.util.Collection;

public interface KittenService {
    Collection<Kitten> getKittens();
    Kitten getKittenById(long id);
    long saveKitten(Kitten kitten);
    void updateKitten(long id, Kitten kitten);
    void deleteKitten(long id);
}
