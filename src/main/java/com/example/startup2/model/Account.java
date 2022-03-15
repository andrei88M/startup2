package com.example.startup2.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Account implements Serializable {
    @Id
    private int id;

    @Column
    private String password;

    @OneToOne
    @MapsId
    private Worker worker;

    @OneToMany(mappedBy = "senderMessage")
    private Set<Message> senderSet = new HashSet<>();

    @OneToMany(mappedBy = "recipientMessages")
    private Set<Message> recipientSet = new HashSet<>();


}
