package fr.esiea.ex4A;

import fr.esiea.ex4A.agify.AgifyClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LauncherTest {

    @Test
    void agifyClient_testBeans() {

            Launcher mock = new Launcher();

        AgifyClient agifyClient = mock.agifyClient();

            assertNotNull(agifyClient);
    }
}
