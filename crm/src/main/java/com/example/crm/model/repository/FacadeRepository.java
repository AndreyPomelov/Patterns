package com.example.crm.model.repository;

import com.example.crm.model.entity.Unit;
import com.example.crm.model.entity.User;
import org.springframework.stereotype.Component;

/**
 * FACADE-репозиторий
 */
@Component
public interface FacadeRepository {

    /**
     * Достать пользователя из БД по идентификатору
     *
     * @param id Идентификатор пользователя
     * @return Экземпляр пользователя
     */
    User getUserById(int id);

    /**
     * Достать отдел из БД по идентификатору
     *
     * @param id Идентификатор отдела
     * @return Экземпляр отдела
     */
    Unit getUnitById(int id);

    /**
     * Сохранить пользователя в БД
     *
     * @param user Экземпляр пользователя
     */
    void saveUser(User user);

    /**
     * Сохранить отдел в БД
     *
     * @param unit Экземпляр отдела
     */
    void saveUnit(Unit unit);
}
