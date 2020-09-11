package com.choilabo.todo.di

import android.content.Context
import androidx.room.Room
import com.choilabo.todo.data.db.TodoRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * Created by sato_shinichiro on 2020/09/10
 */
@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TodoRoomDatabase =
        Room.databaseBuilder(
            context,
            TodoRoomDatabase::class.java,
            TodoRoomDatabase.DB_NAME
        ).build()
}