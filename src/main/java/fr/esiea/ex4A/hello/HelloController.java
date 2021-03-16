package fr.esiea.ex4A.hello;

import fr.esiea.ex4A.Matches;
import fr.esiea.ex4A.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        final User user = new User(param.get("userEmail"),param.get("userName"),param.get("userTweeter"),param.get("userCountry"),param.get("userSex"),param.get("userSexPref") );
        return helloRepository.stored(user);
    }

    @GetMapping(path = "/api/matches",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<Matches> match(@RequestParam(name = "userName" , required = true ) String userName,
                 @RequestParam(name = "userCountry", required = true) String userCountry) throws IOException {
        List<Matches> list = new ArrayList<Matches>();
        final User user = new User("serrier@et.esiea.fr","Alexia","Xeolia","Fr","F","H");
        list.add(new Matches(user.getUserName(),user.getUserTweeter()));

        return list;
    }
}
