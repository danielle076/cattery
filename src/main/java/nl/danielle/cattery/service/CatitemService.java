package nl.danielle.cattery.service;

import nl.danielle.cattery.model.Catitem;

import java.util.List;

public interface CatitemService {
    List<Catitem> getCatitems();
    Catitem getCatitemById(long id);
    long saveCatitem(Catitem catitem);
    Catitem updateCatitemById(long id, Catitem catitem);
    void deleteCatitem(long id);
}
