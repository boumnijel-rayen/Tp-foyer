package tn.esprit.tpfoyer.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FoyerServiceImplTest {

    @Mock
    private FoyerRepository foyerRepository;

    @InjectMocks
    private FoyerServiceImpl foyerService;

    @Test
    void testAjouterFoyer() {
        Foyer foyer = new Foyer();
        foyer.setNomFoyer("Foyer A");
        foyer.setCapaciteFoyer(100);

        when(foyerRepository.save(any(Foyer.class))).thenReturn(foyer);

        Foyer saved = foyerService.addFoyer(foyer);

        assertNotNull(saved);
        assertEquals("Foyer A", saved.getNomFoyer());
        verify(foyerRepository, times(1)).save(foyer);
    }

    @Test
    void testGetAllFoyers() {
        List<Foyer> list = Arrays.asList(
                new Foyer(), new Foyer()
        );

        when(foyerRepository.findAll()).thenReturn(list);

        List<Foyer> result = foyerService.retrieveAllFoyers();

        assertEquals(2, result.size());
    }

    @Test
    void testGetFoyerById() {
        Foyer foyer = new Foyer();
        foyer.setIdFoyer(1L);
        foyer.setNomFoyer("Test");

        when(foyerRepository.findById(1L)).thenReturn(Optional.of(foyer));

        Foyer result = foyerService.retrieveFoyer(1L);

        assertNotNull(result);
        assertEquals("Test", result.getNomFoyer());
        verify(foyerRepository).findById(1L);
    }

    @Test
    void testDeleteFoyer() {
        Long id = 1L;

        doNothing().when(foyerRepository).deleteById(id);

        foyerService.removeFoyer(id);

        verify(foyerRepository, times(1)).deleteById(id);
    }
}