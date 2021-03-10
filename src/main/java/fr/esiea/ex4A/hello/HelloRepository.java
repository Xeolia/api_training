package fr.esiea.ex4A.hello;

import fr.esiea.ex4A.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Repository
class HelloRepository {
    List<User> userList = new ArrayList<>();

    final List<String> names = List.of(
            "Jaguabyss",
            "Coyolax",
            "Gazena",
            "Chickig",
            "Gladiabat",
            "Gladiafly",
            "Steeleen",
            "Marsharak",
            "Berriot",
            "Penguine"
    );
    private final Random random = new Random();

    HelloData randomHello() {
        return new HelloData(names.get(random.nextInt(names.size())));
    }

    HelloData getHelloFor(String name) {
        int letterIndex = name.toLowerCase(Locale.ROOT).charAt(0) - 'a';
        return new HelloData((name + " ").repeat(1 + letterIndex).trim());
    }
    Boolean stored(User user){
        for (User monUser:userList) {
            if(monUser.getUserTweeter().equals(user.getUserTweeter()))
                return false;
        }
        userList.add(user);
        return true;
    }

}
