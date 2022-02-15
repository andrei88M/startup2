package org.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @OneToMany(mappedBy = "worker", fetch = FetchType.EAGER)
    private Set<Schedule> scheduleSet = new HashSet<>();

    @OneToOne
    @PrimaryKeyJoinColumn
    private Account account;

    @OneToMany(mappedBy = "worker", fetch = FetchType.EAGER)
    private Set<Salary> salarySet = new HashSet<>();

    @OneToMany(mappedBy = "worker", fetch = FetchType.EAGER)
    private Set<WorkTime> workTimeSet = new HashSet<>();


}
