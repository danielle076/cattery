package nl.danielle.cattery.service;

import nl.danielle.cattery.model.Catpart;

import java.util.List;

public interface CatpartService {
    List<Catpart> getAllCatParts();
    Catpart getCatPartById(long id);
    Catpart updateCatpartById(long id, Catpart catpart);
    long saveCatpart(Catpart catPart);
    void deleteCatpart(long id);
}
