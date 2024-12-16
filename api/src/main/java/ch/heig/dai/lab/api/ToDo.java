package ch.heig.dai.lab.api;

import io.javalin.*;

public class ToDo 
{
    public static void main( String[] args )
    {
        Javalin api = Javalin.create().start(7000);
        TasksController tasksController = new TasksController();

        // create
        api.post("/tasks", tasksController::create);

        // read
        api.get("/tasks", tasksController::read);
        api.get("/tasks/pending", tasksController::readPending);
        api.get("/tasks/done", tasksController::readDone);
        api.get("/tasks/{id}", tasksController::readOne);

        // update
        api.put("/tasks/{id}", tasksController::update);
        api.put("/tasks/{id}/done", tasksController::markAsDone);

        // delete
        api.delete("/tasks/done", tasksController::deleteDone);
        api.delete("/tasks/{id}", tasksController::delete);
        api.delete("/tasks", tasksController::deleteAll);
    }
}
