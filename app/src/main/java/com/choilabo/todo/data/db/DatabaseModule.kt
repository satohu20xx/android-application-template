package com.choilabo.todo.data.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by sato_shinichiro on 2020-01-10
 */
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideTodoRoomDatabase(
        context: Context
    ): TodoRoomDatabase {
        return Room.databaseBuilder(context, TodoRoomDatabase::class.java, TodoRoomDatabase.DB_NAME)
            .build()
    }
}