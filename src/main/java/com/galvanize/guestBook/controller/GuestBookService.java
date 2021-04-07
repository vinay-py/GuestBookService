package com.galvanize.guestBook.controller;

import com.galvanize.guestBook.GuestBookEntriesEntity;
import com.galvanize.guestBook.GuestBookRepository;
import com.galvanize.guestBook.model.GuestBookEntriesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<GuestBookEntriesDTO> fetchALl() {
        return guestBookRepository.findAll()
                .stream()
                .map(guestBookEntriesEntity -> {
                    return new GuestBookEntriesDTO(guestBookEntriesEntity.getGuestName(),guestBookEntriesEntity.getComment());
                })
                .collect(Collectors.toList());
    }
}
