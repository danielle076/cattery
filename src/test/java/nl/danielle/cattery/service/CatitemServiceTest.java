package nl.danielle.cattery.service;

import nl.danielle.cattery.exception.RecordNotFoundException;
import nl.danielle.cattery.model.Catitem;
import nl.danielle.cattery.repository.CatitemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class CatitemServiceTest {

    @InjectMocks
    CatitemServiceImpl catpartService;

    @Mock
    CatitemRepository catitemRepository;

    @Mock
    Catitem catitem;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);

        Catitem catitem = new Catitem();
        catitem.setId(1L);
        catitem.setDescription("Burmees");
        catitem.setPrice(10.00);
    }

    @Test
    void testGetCatpartById() {

        Mockito.when(catitemRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThrows(RecordNotFoundException.class, () -> {
            catpartService.getCatitemById(1L);

        });
    }

    @Test
    void testDeleteCatpart() {

        Mockito.when(catitemRepository.existsById(1L)).thenReturn(false);
        Assertions.assertThrows(RecordNotFoundException.class, () -> {
            catpartService.deleteCatitem(1L);

        });
    }
}
