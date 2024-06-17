package extensions

import com.example.models.Course

fun Course.json(course: Course?): String {
    return "{\"id\": ${course?.id}, " +
            "\"title\": \"${course?.title}\", " +
            "\"complexity\": \"${course?.complexity}\", " +
            "\"isActive\": ${course?.isActive}}"
}