package com.example.crm.model.entity;

import lombok.Data;
import javax.persistence.*;

/**
 * Пользователь системы (сотрудник компании)
 */
@Data
@Entity
@Table(name = "user")
public class User {

    /**
     * Идентификатор пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    /**
     * Логин
     */
    @Column(name = "login")
    private String login;

    /**
     * Пароль
     */
    @Column(name = "password")
    private String password;

    /**
     * Имя
     */
    @Column(name = "name")
    private String name;

    /**
     * Фамилия
     */
    @Column(name = "surname")
    private String surname;

    /**
     * Является ли администратором
     */
    @Column(name = "is_admin")
    private boolean isAdmin;

    /**
     * Идентификатор отдела, в котором работает пользователь
     */
    @Column(name = "unit_id")
    private int unitID;

    /**
     * Месячный оклад
     */
    @Column(name = "salary")
    private double salary;
}
