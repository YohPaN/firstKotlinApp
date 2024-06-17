package com.example.plugins

import com.example.models.Complexity
import com.example.models.Course
import com.example.models.CourseList
import extensions.json
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import extensions.json

var courseList = HashMap<String, Course>()

fun Application.configureRouting() {
    courseList["1"] = Course(1, "How to do a top", Complexity.Medium, true)
    courseList["2"] = Course(2, "How to do a second course", Complexity.Low, true)
    courseList["3"] = Course(3, "How to do a thir course", Complexity.Hard, false)

    routing {
        get("/") {
            call.respondText("Welcome to OpenClassroom' brand new server!")
        }
        get("/course/top") {
            val course = courseList["1"]
            if (course != null) {
                call.respondText(course.json(course))
            }
        }
        get("/course/{id}") {
            val course = courseList[call.parameters["id"]]
            if (course != null) {
                call.respondText(course.json(course))
            } else {
                call.respondText("{\"status\": 404, \"message\": \"Sorry! No course was found...\"")
            }
        }
    }
}
