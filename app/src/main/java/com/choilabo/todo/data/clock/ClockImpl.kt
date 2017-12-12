package com.choilabo.todo.data.clock

import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by sato_shinichiro on 2017/12/07.
 */
@Singleton
class ClockImpl @Inject constructor() : Clock {
    override fun currentTimeMillis(): Long = System.currentTimeMillis()
}