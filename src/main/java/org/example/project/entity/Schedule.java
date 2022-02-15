package org.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Schedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private int day;

    @Column
    private String month;

    @Column
    private int year;

    @Column
    private int replacement;

    @ManyToOne
    @JoinColumn
    private Worker worker;

    @ManyToOne
    @JoinColumn
    private Route route;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return day == schedule.day && year == schedule.year && replacement == schedule.replacement && Objects.equals(id, schedule.id) && Objects.equals(month, schedule.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, day, month, year, replacement);
    }
}
