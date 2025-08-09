package com.tungnk123

import com.tungnk123.model.Priority
import com.tungnk123.model.Task
import com.tungnk123.model.TaskRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        route("/tasks") {
            get {
                val tasks = TaskRepository.allTasks()
                call.respond(tasks)
            }

            get("/byName/{taskName}") {
                val name = call.parameters["taskName"]
                if (name == null) {
                    call.respond(HttpStatusCode.BadRequest)
                    return@get
                }
                val task = TaskRepository.taskByName(name)
                if (task == null) {
                    call.respond(HttpStatusCode.NotFound)
                    return@get
                }
                call.respond(task)
            }

            get("/byPriority/{priority}") {
                val priorityAsText = call.parameters["priority"]
                if (priorityAsText == null) {
                    call.respond(HttpStatusCode.BadRequest)
                    return@get
                }

                try {
                    val priority = Priority.valueOf(priorityAsText)
                    val tasksByPriority = TaskRepository.tasksByPriority(priority)
                    if (tasksByPriority.isEmpty()) {
                        call.respond(HttpStatusCode.NotFound)
                        return@get
                    }
                    call.respond(tasksByPriority)
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }

            post {
                try {
                    val newTask = call.receive<Task>()
                    TaskRepository.addTask(newTask)
                    call.respond(HttpStatusCode.Created)
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }

            delete("/{taskName}") {
                val taskName = call.parameters["taskName"]
                if (taskName == null) {
                    call.respond(HttpStatusCode.BadRequest)
                    return@delete
                }
                if (TaskRepository.removeTask(name = taskName)) {
                    call.respond(HttpStatusCode.NoContent)
                } else {
                    call.respond(HttpStatusCode.NotFound)
                }
            }
        }
    }
}
