package fr.esiea.ex4A;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchesTest {

    @Test
    void Matches(){
        User user = new User("serrier@et.esiea.fr","Alexia","Xeolia","Fr","F","H");
        Assertions.assertEquals("Alexia",user.getUserName());
        Assertions.assertEquals("Xeolia",user.getUserTweeter());
    }
    @Test
    void getName() {
        User user= new User("serrier@et.esiea.fr","Alexia","Xeolia","Fr","F","H");
        Assertions.assertEquals("Alexia", user.getUserName());
    }

    @Test
    void getTwitter() {
        User user= new User("serrier@et.esiea.fr","Alexia","Xeolia","Fr","F","H");
        Assertions.assertEquals("Xeolia", user.getUserTweeter());
    }
}
