package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodosTests {

    Todos sut = new Todos();

    @BeforeEach
    public void initData() {
        sut.addTask("Спорт");
        sut.addTask("Уборка");
        sut.addTask("Магазин");
        sut.addTask("Прогулка");
    }

    @Test
    void addTaskTest() {
        List<String> expected = new ArrayList<>(Arrays.asList("Спорт", "Уборка", "Магазин", "Прогулка", "Сон"));
        sut.addTask("Сон");
        Assertions.assertEquals(expected, sut.getTasksList());
    }

    @Test
    void remoteTaskTest() {
        List<String> expected = new ArrayList<>(Arrays.asList("Спорт", "Уборка", "Магазин"));
        sut.removeTask("Прогулка");
        Assertions.assertEquals(expected, sut.getTasksList());
    }

    @Test
    void getAllTasksTest() {
        String expected = "Магазин Прогулка Спорт Уборка";
        String result = sut.getAllTasks();
        Assertions.assertEquals(expected, result);
    }

}
