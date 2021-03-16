package fr.esiea.ex4A;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void User(){
        User user =new User("serrier@et.esiea.fr","Alexia","Xeolia","Fr","F","H");
        Assertions.assertNotNull(user.getUserEmail());
        Assertions.assertNotNull(user.getUserName());
        Assertions.assertNotNull(user.getUserTweeter());
        Assertions.assertNotNull(user.getUserCountry());
        Assertions.assertNotNull(user.getUserSex());
        Assertions.assertNotNull(user.getUserSexPref());
    }
    @Test
    void getUserEmail() {
        User user= new User("serrier@et.esiea.fr","Alexia","Xeolia","Fr","F","H");
        Assertions.assertEquals("serrier@et.esiea.fr", user.getUserEmail());
    }

    @Test
    void getUserName() {
        User user= new User("serrier@et.esiea.fr","Alexia","Xeolia","Fr","F","H");
        Assertions.assertEquals("Alexia", user.getUserName());
    }

    @Test
    void getUserTweeter() {
        User user= new User("serrier@et.esiea.fr","Alexia","Xeolia","Fr","F","H");
        Assertions.assertEquals("Xeolia", user.getUserTweeter());
    }

    @Test
    void getUserCountry() {
        User user= new User("serrier@et.esiea.fr","Alexia","Xeolia","Fr","F","H");
        Assertions.assertEquals("Fr", user.getUserCountry());
    }

    @Test
    void getUserSex() {
        User user= new User("serrier@et.esiea.fr","Alexia","Xeolia","Fr","F","H");
        Assertions.assertEquals("F", user.getUserSex());
    }

    @Test
    void getUserSexPref() {
        User user= new User("serrier@et.esiea.fr","Alexia","Xeolia","Fr","F","H");
        Assertions.assertEquals("H", user.getUserSexPref());
    }
}
