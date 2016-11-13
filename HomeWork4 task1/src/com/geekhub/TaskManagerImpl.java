package com.geekhub;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class TaskManagerImpl implements TaskManager {

    private Map<LocalDateTime, List<Task>> tasks = new HashMap<>();

    @Override
    public void add(LocalDateTime date, Task task) {
        List<Task> taskList = tasks.get(date);

        if (taskList == null) {
            taskList = new ArrayList<>();
            tasks.put(date, taskList);
        }
        taskList.add(task);
    }

    @Override
    public void remove(LocalDateTime date) {
        tasks.entrySet()
                .removeIf(p -> p.getKey().equals(date));
    }

    @Override
    public Set<String> getCategories() {
        return tasks.values().stream()
                .flatMap(List::stream)
                .map(Task::getCategory)
                .collect(toSet());
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories(String... categories) {
        Map<String, List<Task>> result = new HashMap<>();
        Collection<List<Task>> values = tasks.values();
        for (List<Task> listTask : values) {
            for (Task task : listTask) {
                List<Task> tasks = result.get(task.getCategory());
                if (tasks == null) {
                    tasks = new ArrayList<>();
                }
                if (asList(categories).contains(task.getCategory())) {
                    tasks.add(task);
                    result.put(task.getCategory(), tasks);
                }
            }
        }
        return result;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        return tasks.values().stream()
                .flatMap(List::stream)
                .filter(p -> p.getCategory().equals(category))
                .collect(toList());
    }

    @Override
    public List<Task> getTasksForToday() {
        return tasks.keySet().stream()
                .filter(p -> p.toLocalDate().equals(LocalDate.now()))
                .map(p -> tasks.get(p))
                .flatMap(List::stream)
                .collect(toList());
    }
}
