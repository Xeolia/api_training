package fr.esiea.ex4A;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void User(){
        User user =new User("serrier@et.esiea.fr","Alexia","Xeolia","Fr","F","H");
        Assertions.assertNotNull(user.userEmail);
        Assertions.assertNotNull(user.userName);
        Assertions.assertNotNull(user.userTweeter);
        Assertions.assertNotNull(user.userCountry);
        Assertions.assertNotNull(user.userSex);
        Assertions.assertNotNull(user.userSexPref);
    }
    @Test
    void getUserEmail() {
        User user= new User("serrier@et.esiea.fr","Alexia","Xeolia","Fr","F","H");
        Assertions.assertEquals("serrier@et.esiea.fr", user.userEmail);
    }

    @Test
    void getUserName() {
        User user= new User("serrier@et.esiea.fr","Alexia","Xeolia","Fr","F","H");
        Assertions.assertEquals("Alexia", user.userName);
    }

    @Test
    void getUserTweeter() {
        User user= new User("serrier@et.esiea.fr","Alexia","Xeolia","Fr","F","H");
        Assertions.assertEquals("Xeolia", user.userTweeter);
    }

    @Test
    void getUserCountry() {
        User user= new User("serrier@et.esiea.fr","Alexia","Xeolia","Fr","F","H");
        Assertions.assertEquals("Fr", user.userCountry);
    }

    @Test
    void getUserSex() {
        User user= new User("serrier@et.esiea.fr","Alexia","Xeolia","Fr","F","H");
        Assertions.assertEquals("F", user.userSex);
    }

    @Test
    void getUserSexPref() {
        User user= new User("serrier@et.esiea.fr","Alexia","Xeolia","Fr","F","H");
        Assertions.assertEquals("H", user.userSexPref);
    }
}
