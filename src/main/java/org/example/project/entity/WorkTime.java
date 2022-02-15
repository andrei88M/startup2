package org.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WorkTime implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private double time;

    @Column
    private String month;

    @Column
    private int day;

    @ManyToOne
    private Worker worker;

    @Override
    public String toString() {
        return "WorkTime{" +
                "id=" + id +
                ", time=" + time +
                ", month='" + month + '\'' +
                ", day=" + day +
                '}';
    }
}
