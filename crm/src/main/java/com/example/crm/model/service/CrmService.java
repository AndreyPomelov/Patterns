package com.example.crm.model.service;

import com.example.crm.model.entity.Unit;
import com.example.crm.model.entity.User;
import com.example.crm.model.repository.FacadeRepository;
import com.example.crm.model.repository.UnitRepository;
import com.example.crm.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;

/**
 * FACADE-сервис
 */
@Component
@RequiredArgsConstructor
public class CrmService implements FacadeRepository {

    /**
     * Локальное хранилище пользователей, служащее для
     * сокращения количества обращений к базе данных
     */
    private final Map<Integer, User> userMap = new HashMap<>();

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
    @Transactional
    public User getUserById(int id) {
        // Если пользователь существует в локальном хранилище,
        // достаём его оттуда, иначе обращаемся к базе данных
        if (userMap.containsKey(id)) {
            return userMap.get(id);
        } else {
            User user = userRepository.getById(id);
            userMap.put(id, user);
            return user;
        }
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
        // Сохраняем пользователя в локальном хранилище
        // и в базе данных
        userMap.put(user.getId(), user);
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
