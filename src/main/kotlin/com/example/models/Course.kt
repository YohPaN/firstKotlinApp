package com.example.models

enum class Complexity {
    Low,
    Medium,
    Hard
}

data class Course(val id: Int, val title: String, val complexity: Complexity, val isActive: Boolean )