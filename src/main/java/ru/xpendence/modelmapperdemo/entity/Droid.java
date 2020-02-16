package ru.xpendence.modelmapperdemo.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "droids")
@AllArgsConstructor
@NoArgsConstructor
public class Droid extends AbstractEntity {

    private String name;
    private Unicorn unicorn;
    private Boolean alive;

    public Droid(String name, Unicorn unicorn, Boolean alive) {
        this.name = name;
        this.unicorn = unicorn;
        this.alive = alive;
    }

    public Droid(String name, Boolean alive) {
        this.name = name;
        this.alive = alive;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unicorn_id")
    public Unicorn getUnicorn() {
        return unicorn;
    }

    @Column(name = "alive")
    public Boolean getAlive() {
        return alive;
    }
}
