package fr.esiea.ex4A.hello;

import fr.esiea.ex4A.Matches;
import fr.esiea.ex4A.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class HelloControllerIT {

    private final MockMvc mockMvc;

    @MockBean
    private HelloRepository repository;

    HelloControllerIT(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void hello_delegates_to_repository_when_name_param_is_present() throws Exception {
        when(repository.getHelloFor(any())).thenReturn(new HelloData("test"));

        mockMvc
            .perform(MockMvcRequestBuilders.get("/hello?name=test"))
            .andExpect(status().isOk())
            .andExpect(content().json("""
                        {
                            "type":"hello",
                            "name":"test",
                            "completeSentence":"hello test!"}
                        }
                        """));

        verify(repository).getHelloFor("test");
    }

    @Test
    void hello_delegates_to_random_when_name_param_is_absent() throws Exception {
        when(repository.randomHello()).thenReturn(new HelloData("randomtest"));

        mockMvc
            .perform(MockMvcRequestBuilders.get("/hello"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.type").value("hello"))
            .andExpect(jsonPath("$.name").value("randomtest"))
            .andExpect(jsonPath("$.completeSentence").value(allOf(startsWith("hello"), endsWith("!"))));

        verify(repository).randomHello();
    }

    @Test
    void data_it_should_return() throws Exception{

        when(repository.stored(any())).thenReturn(true);

        mockMvc
            .perform(MockMvcRequestBuilders.post("/api/inscription").contentType(MediaType.APPLICATION_JSON_VALUE).content("""
                {
                    "userEmail": "machin@truc.com",
                    "userName": "machin",
                    "userTweeter": "machin45",
                    "userCountry": "FR",
                    "userSex": "M",
                    "userSexPref": "M"
                    }
                """));
    }

    @Test
    void match_return_match_data() throws Exception {

        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/matches?userName=Alexia&userCountry=Fr"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk())
            .andExpect(content().json("""
                [
                    {
                        "name": "Alexia",
                        "twitter": "Xeolia"
                    }
                ]
                """));
    }
}
