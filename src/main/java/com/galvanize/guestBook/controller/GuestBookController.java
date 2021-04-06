package com.galvanize.guestBook.controller;


import com.galvanize.guestBook.model.GuestBookEntriesDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GuestBookController {
    public GuestBookController() {
       guestBookEntriesDTOList=new ArrayList<GuestBookEntriesDTO>();
    }

    ArrayList<GuestBookEntriesDTO> guestBookEntriesDTOList;
//    GuestBookService guestBookService;
    @PostMapping("entries")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEntries(@RequestBody GuestBookEntriesDTO guestBookEntriesDTO ){
        this.guestBookEntriesDTOList.add(guestBookEntriesDTO);
//        guestBookService.create(guestBookEntriesDTO);

    }

    @GetMapping("entries")
    public ArrayList<GuestBookEntriesDTO> getEntries(){
        return this.guestBookEntriesDTOList;
    }
}
