package com.galvanize.guestBook;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class GuestBookEntriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String guestName;
    String comment;

    public GuestBookEntriesEntity(String guestName, String comment) {
        this.guestName = guestName;
        this.comment = comment;
    }

}
