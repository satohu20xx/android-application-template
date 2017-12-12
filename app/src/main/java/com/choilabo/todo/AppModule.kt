package com.choilabo.todo

import com.choilabo.todo.data.clock.Clock
import com.choilabo.todo.data.clock.ClockImpl
import com.choilabo.todo.ui.ActivityModule
import dagger.Module
import dagger.Provides

/**
 * Created by sato_shinichiro on 2017/12/07.
 */
@Module(includes = arrayOf(
        ActivityModule::class
))
class AppModule() {

    @Provides
    fun provideApplicationContext(app: App) = app.applicationContext

    @Provides
    fun provideClock(): Clock = ClockImpl();
}
