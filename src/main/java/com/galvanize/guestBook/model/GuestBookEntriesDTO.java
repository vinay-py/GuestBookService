package com.galvanize.guestBook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuestBookEntriesDTO {
    String guestName;
    String comment;
}
