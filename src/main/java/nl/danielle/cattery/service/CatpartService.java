package nl.danielle.cattery.service;

import nl.danielle.cattery.model.Catpart;

import java.util.List;

public interface CatpartService {
    List<Catpart> getCatparts();
    Catpart getCatpartById(long id);
    long saveCatpart(Catpart catPart);
    Catpart updateCatpartById(long id, Catpart catpart);
    void deleteCatpart(long id);
}
