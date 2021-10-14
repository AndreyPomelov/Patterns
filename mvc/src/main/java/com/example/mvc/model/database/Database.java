package com.example.mvc.model.database;

import com.example.mvc.model.entity.Cat;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private final List<Cat> cats;

    public Database() {
        cats = new ArrayList<>();
        cats.add(new Cat("Barsik", 3, "RED"));
        cats.add(new Cat("Tom", 5, "GRAY"));
        cats.add(new Cat("Sylvester", 4, "BLACK"));
    }

    public List<Cat> getCats() {
        return cats;
    }
}
