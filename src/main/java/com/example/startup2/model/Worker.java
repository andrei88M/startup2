package com.example.startup2.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(indexes = {@Index(name = "pn_index", columnList = "personnel_number", unique = true)})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private boolean active;

    private String name;
    private String surname;
    @Column(name = "personnel_number")
    private String personnelNumber;
    private String dateOfBirth;
    private String telephone;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "worker_role", joinColumns = @JoinColumn(name = "worker_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "worker", fetch = FetchType.EAGER)
    private Set<Salary> salarySet = new HashSet<>();

    @OneToMany(mappedBy = "worker", fetch = FetchType.LAZY)
    private Set<Schedule> scheduleSet = new HashSet<>();

    @OneToMany(mappedBy = "worker", fetch = FetchType.EAGER)
    private Set<AmountTime> workTimeSet = new HashSet<>();
}
