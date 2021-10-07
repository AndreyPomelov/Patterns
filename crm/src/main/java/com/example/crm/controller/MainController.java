package com.example.crm.controller;

import com.example.crm.model.builder.UserBuilder;
import com.example.crm.model.entity.Unit;
import com.example.crm.model.entity.User;
import com.example.crm.model.service.CrmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.annotation.PostConstruct;

/**
 * Главный контроллер
 */
@Controller
@RequiredArgsConstructor
public class MainController {

    /**
     * Экземпляр FACADE-сервиса
     */
    private final CrmService service;

    /**
     * Тестовый метод для демонстрации работы сервиса
     *
     * @return Пустая страница
     */
    @GetMapping(value = "")
    private String test() {
        // Создаём новый отдел
        Unit unit = new Unit();
        unit.setName("Bending Department");
        unit.setDescription("Department for bending various things");

        // Сохраняем отдел В БД
        service.saveUnit(unit);

        // Создаём нового пользователя
        User user = new UserBuilder()
                .login("bender")
                .password("123")
                .firstName("Bender")
                .surname("Rodriguez")
                .isAdmin(false)
                .unitId(1)
                .salary(1000)
                .build();

        // Сохраняем пользователя в БД
        service.saveUser(user);

        // Достаём из БД экземпляр отдела и выводим в консоль
        Unit unitFromDb = service.getUnitById(1);
        System.out.println(unitFromDb.toString());

        // Достаём из БД экземпляр пользователя и выводим в консоль
        User userFromDb = service.getUserById(1);
        System.out.println(userFromDb.toString());

        return "index";
    }

    /**
     * Тестовый метод для проверки паттерна "Identity Map"
     */
    @PostConstruct
    private void testIdMap() {
        User user1 = service.getUserById(1);
        System.out.println(user1.toString());
        // При повторном поиске пользователя с тем же ID,
        // сервис должен достать пользователя из локального
        // хранилища, а не из базы данных
        User user2 = service.getUserById(1);
        System.out.println(user2.toString());
        User user3 = User.create("leela leela123 Leela Turanga 1 2000");
        user3.setId(10);
        service.saveUser(user3);
        // После сохранения пользователя и обращения к нему же,
        // сервис также должен достать пользователя из
        // локального хранилища
        User user4 = service.getUserById(10);
        System.out.println(user4.toString());
    }
}
