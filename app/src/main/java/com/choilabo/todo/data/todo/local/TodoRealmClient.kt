package com.choilabo.todo.data.todo.local

import com.choilabo.todo.data.clock.Clock
import com.choilabo.todo.data.realm.RealmProvider
import com.choilabo.todo.data.todo.entity.Todo
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import io.realm.RealmResults
import javax.inject.Inject

/**
 * Created by sato_shinichiro on 2017/12/04.
 */

class TodoRealmClient @Inject constructor(
        private val clock: Clock,
        private val realmProvider: RealmProvider
) : TodoDataClient {

    override fun getById(id: String): Todo? {
        return realmProvider.get().where(Todo::class.java)
                .equalTo("id", id)
                .findFirst()
    }

    override fun getAll(): RealmResults<Todo> {
        return realmProvider.get().where(Todo::class.java)
                .sort("updatedAt")
                .findAll()
    }

    override fun save(title: String, description: String): Completable {
        return Completable.fromAction {
            realmProvider.executeTransaction(Realm.Transaction {
                Todo().run {
                    this.title = title
                    this.description = description
                    this.updatedAt = clock.currentTimeMillis()
                    it.insertOrUpdate(this)
                }
            })
        }.subscribeOn(Schedulers.io())
    }

}