package com.example.crm.model.service;

import com.example.crm.model.entity.Unit;
import com.example.crm.model.entity.User;
import com.example.crm.model.repository.FacadeRepository;
import com.example.crm.model.repository.UnitRepository;
import com.example.crm.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * FACADE-сервис
 */
@Component
@RequiredArgsConstructor
public class CrmService implements FacadeRepository {

    /**
     * Экземпляр репозитория пользователей
     */
    private final UserRepository userRepository;

    /**
     * Экземпляр репозитория отделов
     */
    private final UnitRepository unitRepository;

    /**
     * Достать пользователя из БД по идентификатору
     *
     * @param id Идентификатор пользователя
     * @return Экземпляр пользователя
     */
    @Override
    public User getUserById(int id) {
        return userRepository.getById(id);
    }

    /**
     * Достать отдел из БД по идентификатору
     *
     * @param id Идентификатор отдела
     * @return Экземпляр отдела
     */
    @Override
    public Unit getUnitById(int id) {
        return unitRepository.getById(id);
    }

    /**
     * Сохранить пользователя в БД
     *
     * @param user Экземпляр пользователя
     */
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    /**
     * Сохранить отдел в БД
     *
     * @param unit Экземпляр отдела
     */
    @Override
    public void saveUnit(Unit unit) {
        unitRepository.save(unit);
    }
}
