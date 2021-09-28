package com.example.crm.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

/**
 * Отдел (подразделение) компании
 */
@Data
@Entity
@Table(name = "unit")
public class Unit {

    /**
     * Идентификатор отдела
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id")
    private int id;

    /**
     * Название отдела
     */
    @Column(name = "name")
    private String name;

    /**
     * Описание отдела
     */
    @Column(name = "description")
    private String description;

    /**
     * Список сотрудников отдела
     */
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<User> users;
}
