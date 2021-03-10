package fr.esiea.ex4A.hello;

import fr.esiea.ex4A.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
class HelloController {

    private final HelloRepository helloRepository;

    HelloController(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    HelloData sayHello(@RequestParam(name = "name", required = false) String name) {
        final HelloData helloData;
        if (name == null || name.isBlank()) {
            helloData = helloRepository.randomHello();
        } else {
            helloData = helloRepository.getHelloFor(name);
        }
        return helloData;
    }
    @PostMapping(path = "/saveData", produces = MediaType.APPLICATION_JSON_VALUE)
    Boolean saveData(@RequestBody Map<String, String> param) {
        User user = new User(param.get("userEmail"),param.get("userName"),param.get("userTweeter"),param.get("userCountry"),param.get("userSex"),param.get("userSexPref") );
        return helloRepository.stored(user);
    }
}
