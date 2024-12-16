package ch.heig.dai.lab.api;

import io.javalin.http.Context;
import java.util.concurrent.ConcurrentHashMap;

public class TasksController {
    private ConcurrentHashMap<Integer, Task> tasks = new ConcurrentHashMap<>();
    private int lastId = 0;

    public void create(Context ctx) {
        Task task = ctx.bodyAsClass(Task.class);
        tasks.put(++lastId, task);
        ctx.status(201).json(task);
    }

    public void read(Context ctx) {
        ctx.json(tasks);
    }

    public void readPending(Context ctx) {
        ConcurrentHashMap<Integer, Task> pending = new ConcurrentHashMap<>();
        tasks.forEach((id, task) -> {
            if (!task.isDone())
                pending.put(id, task);
        });
        ctx.json(pending);
    }

    public void readDone(Context ctx) {
        ConcurrentHashMap<Integer, Task> done = new ConcurrentHashMap<>();
        tasks.forEach((id, task) -> {
            if (task.isDone())
                done.put(id, task);
        });
        ctx.json(done);
    }

    public void readOne(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Task task = tasks.get(id);

        if (task != null)
            ctx.json(task);
        else
            ctx.status(404);
    }

    public void update(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Task task = ctx.bodyAsClass(Task.class);
        tasks.put(id, task);
        ctx.status(204);
    }

    public void markAsDone(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Task task = tasks.get(id);

        if (task != null) {
            task.setDone(true);
            ctx.status(204);
        } else {
            ctx.status(404);
        }
    }

    public void delete(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        tasks.remove(id);
        ctx.status(204);
    }

    public void deleteDone(Context ctx) {
        tasks.values().removeIf(Task::isDone);
        ctx.status(204);
    }

    public void deleteAll(Context ctx) {
        tasks.clear();
        ctx.status(204);
    }
}
