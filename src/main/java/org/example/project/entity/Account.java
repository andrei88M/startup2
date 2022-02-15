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
@Table(indexes = {@Index(name = "l_index", columnList = "login",unique = true)})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account implements Serializable {
    @Id
    private int id;

    @Column
    private String login;

    @Column
    private String password;

    @OneToMany(mappedBy = "senderMessage")
    private Set<Message> senderSet = new HashSet<>();

    @OneToMany(mappedBy = "recipientMessages")
    private Set<Message> recipientSet = new HashSet<>();

    @OneToOne
    @MapsId
    private Worker worker;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && Objects.equals(login, account.login) && Objects.equals(password, account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }
}
