package com.example.crm.model.builder;

import com.example.crm.model.entity.User;

/**
 * Создатель пользователя
 */
public class UserBuilder {

    /**
     * Экземпляр пользователя
     */
    private final User user;

    /**
     * Конструктор
     */
    public UserBuilder() {
        user = new User();
    }

    /**
     * Установка логина
     *
     * @param login Логин
     * @return Экземпляр билдера
     */
    public UserBuilder login(String login) {
        user.setLogin(login);
        return this;
    }

    /**
     * Установка пароля
     *
     * @param password Пароль
     * @return Экземпляр билдера
     */
    public UserBuilder password(String password) {
        user.setPassword(password);
        return this;
    }

    /**
     * Установка имени
     *
     * @param name Имя
     * @return Экземпляр билдера
     */
    public UserBuilder firstName(String name) {
        user.setName(name);
        return this;
    }

    /**
     * Установка фамилии
     *
     * @param surname Фамилия
     * @return Экземпляр билдера
     */
    public UserBuilder surname(String surname) {
        user.setSurname(surname);
        return this;
    }

    /**
     * Установка флага, является ли пользователь админом
     *
     * @param isAdmin true, если пользователь является админом
     * @return Экземпляр билдера
     */
    public UserBuilder isAdmin(boolean isAdmin) {
        user.setAdmin(isAdmin);
        return this;
    }

    /**
     * Установка идентификатора отдела
     *
     * @param unitId Идентификатор отдела
     * @return Экземпляр билдера
     */
    public UserBuilder unitId(int unitId) {
        user.setUnitID(unitId);
        return this;
    }

    /**
     * Установка месячного оклада
     *
     * @param salary Месячный оклад
     * @return Экземпляр билдера
     */
    public UserBuilder salary(double salary) {
        user.setSalary(salary);
        return this;
    }

    /**
     * Возвращает готовый экземпляр пользователя
     *
     * @return Готовый экземпляр пользователя
     */
    public User build() {
        return user;
    }
    //TODO При дальнейшей разработке предусмотреть в данном классе
    // проверки на null полей экземпляра пользователя.
}
