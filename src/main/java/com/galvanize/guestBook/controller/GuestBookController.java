package com.galvanize.guestBook.controller;


import com.galvanize.guestBook.model.GuestBookEntriesDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GuestBookController {
    GuestBookService guestBookService;

    public GuestBookController(GuestBookService guestBookService) {
       this.guestBookService = guestBookService;
    }


//    GuestBookService guestBookService;
    @PostMapping("entries")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEntries(@RequestBody GuestBookEntriesDTO guestBookEntriesDTO ){
        guestBookService.create(guestBookEntriesDTO);

    }

    @GetMapping("entries")
    public List<GuestBookEntriesDTO> getEntries(){
        return this.guestBookService.fetchALl();
    }
}
