package com.galvanize.guestBook;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GuestbookTestIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    public  void addEntries() throws Exception {
        mockMvc.perform(post("/entries")
            .content("")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }
}
