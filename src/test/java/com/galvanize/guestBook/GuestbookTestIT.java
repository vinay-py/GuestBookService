package com.galvanize.guestBook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.guestBook.model.GuestBookEntriesDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class GuestbookTestIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    public  void addEntries() throws Exception {
        GuestBookEntriesDTO guestBookEntriesDTO = new GuestBookEntriesDTO("Guest1", "Nice Experience");
        mockMvc.perform(post("/entries")
            .content(objectMapper.writeValueAsString(guestBookEntriesDTO))
            .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated())
        .andDo(document("AddEntry"));


        mockMvc.perform(get("/entries")
        ).andExpect(status().isOk())
        .andExpect(jsonPath("[0].comment").value("Nice Experience"))
        .andExpect(jsonPath("[0].guestName").value("Guest1"))
        .andDo(document("entries", responseFields(
                fieldWithPath("[0].comment").description("Nice Experience"),
                fieldWithPath("[0].guestName").description("Guest1")
        )));
    }
}
