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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary = (Salary) o;
        return id == salary.id && Double.compare(salary.allTime, allTime) == 0 && Double.compare(salary.money, money) == 0 && Objects.equals(month, salary.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, allTime, money, month);
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", allTime=" + allTime +
                ", money=" + money +
                ", month='" + month + '\'' +
                '}';
    }
}
