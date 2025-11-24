package com.example.android_week10_ex2

data class EmailModel(
    val id: String,
    val sender: String,
    val subject: String,
    val preview: String,
    val time: String,
    val isStarred: Boolean = false
)