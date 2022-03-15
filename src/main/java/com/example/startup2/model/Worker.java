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
public class Worker implements Serializable {
    @Id
    private Integer personnelNumber;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String telephoneNumber;

    @Column
    private String role;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Account account;

    @OneToMany(mappedBy = "worker", fetch = FetchType.EAGER)
    private Set<Salary> salarySet = new HashSet<>();

    @OneToMany(mappedBy = "worker", fetch = FetchType.LAZY)
    private Set<Schedule> scheduleSet = new HashSet<>();

    @OneToMany(mappedBy = "worker", fetch = FetchType.EAGER)
    private Set<AmountTime> workTimeSet = new HashSet<>();
}
