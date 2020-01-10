package com.choilabo.todo.data.todo.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by sato_shinichiro on 2020-01-10
 */
@Entity(tableName = "todo_table")
data class Todo(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "updatedAt") val updatedAt: Long
)