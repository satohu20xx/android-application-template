package com.choilabo.todo.data.todo.local

import com.choilabo.todo.data.todo.entity.Todo
import io.reactivex.Completable
import io.realm.RealmResults

/**
 * Created by sato_shinichiro on 2017/12/05.
 */
interface TodoDataClient {

    fun getById(id: String): Todo?

    fun getAll(): RealmResults<Todo>

    fun save(title: String, description: String) : Completable
}