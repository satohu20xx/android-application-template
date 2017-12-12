package com.choilabo.todo.data.realm

import io.realm.Realm

/**
 * Created by sato_shinichiro on 2017/12/07.
 */

interface RealmProvider {

    fun reserve()

    fun release()

    fun get(): Realm

    fun executeTransaction(transaction: Realm.Transaction)

}