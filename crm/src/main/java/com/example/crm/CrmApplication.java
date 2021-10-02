package com.example.crm;

import com.example.crm.model.builder.UserBuilder;
import com.example.crm.model.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Главный класс приложения
 */
@SpringBootApplication
public class CrmApplication {

	/**
	 * Точка входа
	 *
	 * @param args Передаваемые при запуске аргументы
	 */
	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
		test();
		test1();
	}

	/**
	 * Тестовый метод для проверки паттерна "Билдер"
	 */
	private static void test() {
		User user = new UserBuilder()
				.login("bender")
				.password("123")
				.firstName("Bender")
				.surname("Rodriguez")
				.isAdmin(false)
				.unitId(1)
				.salary(1000)
				.build();
		System.out.println(user.toString());
	}

	/**
	 * Тестовый метод для проверки паттерна "Интерпретатор"
	 */
	private static void test1() {
		User user = User.create("leela leela123 Leela Turanga 1 2000");
		System.out.println(user.toString());
	}
}
