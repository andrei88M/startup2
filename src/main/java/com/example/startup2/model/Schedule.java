package com.example.startup2.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
