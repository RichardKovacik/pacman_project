package sk.fri.uniza;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmerTest {

    @Test
    public void testujMetoduNaNhodnySmer() {
        Smer nahodny = Smer.dajNahodnySmer();
        for (Smer smer : Smer.values()) {
            if (smer.equals(nahodny)){
                Assertions.assertEquals(smer, nahodny);
            }
        }

    }

}