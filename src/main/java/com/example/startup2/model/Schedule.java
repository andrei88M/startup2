package com.example.startup2.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Schedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String date;

    @Column
    private int replacement;

    @ManyToOne
    @JoinColumn
    private Worker worker;

    @ManyToOne
    @JoinColumn
    private Route route;
}
