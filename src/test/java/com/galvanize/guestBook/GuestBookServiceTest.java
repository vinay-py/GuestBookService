package com.galvanize.guestBook;

import com.galvanize.guestBook.controller.GuestBookService;
import com.galvanize.guestBook.model.GuestBookEntriesDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    void fetchALl(){
        GuestBookEntriesEntity guestBookEntriesEntity=new GuestBookEntriesEntity("Guest1","Nice Experience");
        when(mockGuestBookRepository.findAll()).thenReturn(
                List.of(
                        guestBookEntriesEntity,
                        new GuestBookEntriesEntity("Guest2","Awesome Experience")
                )
        );

        List<GuestBookEntriesDTO> actual = subject.fetchALl();

        assertThat(actual).isEqualTo(
                List.of(
                        new GuestBookEntriesDTO("Guest1","Nice Experience"),
                        new GuestBookEntriesDTO("Guest2","Awesome Experience")
                )
        );
    }

}
