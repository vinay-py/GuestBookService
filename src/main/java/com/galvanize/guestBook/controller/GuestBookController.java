package com.galvanize.guestBook.controller;


import com.galvanize.guestBook.model.GuestBookEntriesDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuestBookController {

    List<GuestBookEntriesDTO> guestBookEntriesDTOList;
//    GuestBookService guestBookService;
    @PostMapping("entries")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEntries(){
//        guestBookService.create(guestBookEntriesDTO);

    }

    @GetMapping("entries")
    public String getEntries(){
        return "[{'comment':'Nice Experience'}]";
    }
}
