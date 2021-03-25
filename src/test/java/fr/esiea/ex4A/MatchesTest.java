package fr.esiea.ex4A;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchesTest {

    @Test
    void Matches(){
        Matches matches = new Matches("Alexia","Xeolia");
        Assertions.assertEquals("Alexia",matches.name);
        Assertions.assertEquals("Xeolia",matches.twitter);
    }
}
