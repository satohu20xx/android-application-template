package com.choilabo.todo.data.todo.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

/**
 * Created by sato_shinichiro on 2017/12/04.
 */
open class Todo : RealmObject() {

    @PrimaryKey
    var id = UUID.randomUUID().toString()

    var title: String = ""
    var description: String = ""
    var updatedAt: Long = 0
}