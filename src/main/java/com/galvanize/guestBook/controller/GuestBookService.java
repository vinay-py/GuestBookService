package com.galvanize.guestBook.controller;

import com.galvanize.guestBook.GuestBookEntriesEntity;
import com.galvanize.guestBook.GuestBookRepository;
import com.galvanize.guestBook.model.GuestBookEntriesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestBookService {

    private final GuestBookRepository guestBookRepository;

    @Autowired
    public GuestBookService(GuestBookRepository guestBookRepository) {
        this.guestBookRepository = guestBookRepository;
    }


    public void create(GuestBookEntriesDTO guestBookEntriesDTO) {
        guestBookRepository.save(
                new GuestBookEntriesEntity(guestBookEntriesDTO.getGuestName(),
                        guestBookEntriesDTO.getComment()));
    }
}
