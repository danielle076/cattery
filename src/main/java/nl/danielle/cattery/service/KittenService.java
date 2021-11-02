package nl.danielle.cattery.service;

import nl.danielle.cattery.model.Kitten;

import java.util.Collection;

public interface KittenService {
    public abstract Collection<Kitten> getKittens();
    public abstract Kitten getKittenById(long id);
    public abstract long saveKitten(Kitten kitten);
    public abstract void updateKitten(long id, Kitten kitten);
    public abstract void deleteKitten(long id);
}
