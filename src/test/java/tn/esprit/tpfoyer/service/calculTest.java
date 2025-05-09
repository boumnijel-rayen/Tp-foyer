package tn.esprit.tpfoyer.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class calculTest {

    @Test
    void add() {
        calcul c = new calcul();
        assertEquals(4,c.add(2,2));
    }
}