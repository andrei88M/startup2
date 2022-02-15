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
@Table(indexes = {@Index(name = "nt_index", columnList = "number,typeNumber",unique = true)})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Route implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private int number;

    @Column
    private int typeNumber;

    @Column
    private String startTime;

    @Column
    private String finishTime;

    @Column
    private String replacementTime;

    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER)
    private Set<Schedule> scheduleSet = new HashSet<>();

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", number=" + number +
                ", typeNumber=" + typeNumber +
                ", startTime='" + startTime + '\'' +
                ", finishTime='" + finishTime + '\'' +
                ", replacementTime='" + replacementTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return number == route.number && typeNumber == route.typeNumber && Objects.equals(id, route.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, typeNumber);
    }
}
