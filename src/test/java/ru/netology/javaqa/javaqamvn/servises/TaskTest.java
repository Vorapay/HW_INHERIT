package ru.netology.javaqa.javaqamvn.servises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test //успешный поиск простой задачи
    public void matchesSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test //провальный поиск простой задачи
    public void noMatchesSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test //успешный поиск эпичной задачи
    public void matchesEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Молоко");

        Assertions.assertEquals(expected, actual);
    }

    @Test //провальный поиск эпичной задачи
    public void noMatchesEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("молоко");

        Assertions.assertEquals(expected, actual);
    }

    @Test //успешный поиск встречи
    public void matchesMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");

        Assertions.assertEquals(expected, actual);
    }

    @Test //провальный поиск встречи
    public void moMatchesMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("Выкатка 2й версии приложения");

        Assertions.assertEquals(expected, actual);
    }


}