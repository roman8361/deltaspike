package ru.kravchenko.deltaspike.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * @author Roman Kravchenko
 */

@Entity
@Getter
@Setter
@Table(name = "app_Cat")
public class Cat {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "name")
    private String name;

}
