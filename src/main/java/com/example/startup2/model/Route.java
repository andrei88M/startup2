package com.example.startup2.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Table(indexes = {@Index(name = "nt_index", columnList = "number,typeNumber",unique = true)})
public class Route implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int number;

    @Column
    private String typeNumber;

    @Column
    private LocalTime startTime;

    @Column
    private LocalTime finishTime;

    @Column
    private LocalTime replacementTime;

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    private Set<Schedule> scheduleSet = new HashSet<>();
}
