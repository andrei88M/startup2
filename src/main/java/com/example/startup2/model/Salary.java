package com.example.startup2.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Salary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private double allTime;

    @Column
    private double money;

    @Column
    private String month;

    @ManyToOne
    private Worker worker;
}
