package com.geekhub;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManagerImpl();
        System.out.println(taskManager.getCategories());
        taskManager.add(LocalDateTime.of(2016, 12, 1, 15, 10), new Task("fishing", "hobby"));
        taskManager.add(LocalDateTime.of(2016, 11, 1, 4, 10), new Task("hunting", "entertainment"));
        taskManager.add(LocalDateTime.of(2016, 11, 20, 10, 20), new Task("surfing", "hobby"));
        taskManager.add(LocalDateTime.now(), new Task("training", "sport"));
        System.out.println(taskManager.getCategories());
        System.out.println(taskManager.getTasksByCategory("hobby"));
        System.out.println(taskManager.getTasksByCategories("hobby", "entertainment"));
        taskManager.remove(LocalDateTime.of(2016, 12, 1, 15, 10));
        System.out.println(taskManager.getTasksByCategory("hobby"));
        System.out.println(taskManager.getTasksByCategories("hobby", "entertainment"));
        System.out.println(taskManager.getTasksForToday());
    }
}
