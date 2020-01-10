package com.choilabo.todo.data.todo.dao

import androidx.room.*
import com.choilabo.todo.data.todo.entity.Todo
import io.reactivex.Flowable

/**
 * Created by sato_shinichiro on 2020-01-10
 */
@Dao
interface TodoDao {

    @Query("SELECT * FROM todo_table ORDER BY updatedAt DESC")
    fun observe(): Flowable<List<Todo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(todo: Todo)

    @Delete
    fun delete(todo: Todo)
}