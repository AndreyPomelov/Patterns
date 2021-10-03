package com.example.crm.model.entity;

import com.example.crm.model.builder.UserBuilder;
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

    /**
     * Создаёт пользователя, используя регулярное выражение.
     * Выражение должно содержать в данном конкретном порядке:
     * логин, пароль, имя, фамилию, числовой идентификатор отдела, месячный оклад.
     * Все параметры должны быть разделены пробелом.
     *
     * @param regex Выражение, описывающее создаваемого пользователя
     * @return Экземпляр пользователя
     */
    public static User create(String regex) {
        String[] parameters = regex.split(" ");
        if (parameters.length != 6) {
            throw new IllegalArgumentException("Передаваемое выражение должно содержать 6 параметров, разделённых пробелами.");
        }
        return new UserBuilder()
                .login(parameters[0])
                .password(parameters[1])
                .firstName(parameters[2])
                .surname(parameters[3])
                .unitId(Integer.parseInt(parameters[4]))
                .salary(Double.parseDouble(parameters[5]))
                .build();
    }
}
