package nl.danielle.cattery.service;

import nl.danielle.cattery.exception.RecordNotFoundException;
import nl.danielle.cattery.model.Catpart;
import nl.danielle.cattery.repository.CatpartRepository;
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
public class CatpartServiceTest {

    @InjectMocks
    CatpartServiceImpl catpartService;

    @Mock
    CatpartRepository catpartRepository;

    @Mock
    Catpart catpart;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);

        Catpart catpart = new Catpart();
        catpart.setId(1L);
        catpart.setDescription("Burmees");
        catpart.setPrice(10.00);
    }

    @Test
    void testGetCatpartById() {

        Mockito.when(catpartRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThrows(RecordNotFoundException.class, () -> {
            catpartService.getCatpartById(1L);

        });
    }

    @Test
    void testDeleteCatpart() {

        Mockito.when(catpartRepository.existsById(1L)).thenReturn(false);
        Assertions.assertThrows(RecordNotFoundException.class, () -> {
            catpartService.deleteCatpart(1L);

        });
    }
}
