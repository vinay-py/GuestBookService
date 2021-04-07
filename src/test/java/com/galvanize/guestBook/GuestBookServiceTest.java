package com.galvanize.guestBook;

import com.galvanize.guestBook.controller.GuestBookService;
import com.galvanize.guestBook.model.GuestBookEntriesDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class GuestBookServiceTest {

    @Mock
    GuestBookRepository mockGuestBookRepository;

    @InjectMocks
    GuestBookService subject;

    @Test
    void create(){
        GuestBookEntriesDTO guestBookEntriesDTO = new GuestBookEntriesDTO("Guest1", "Nice Expetience");
        subject.create(guestBookEntriesDTO);
        verify(mockGuestBookRepository).save(
                new GuestBookEntriesEntity("Guest1", "Nice Expetience")
        );
    }

}
