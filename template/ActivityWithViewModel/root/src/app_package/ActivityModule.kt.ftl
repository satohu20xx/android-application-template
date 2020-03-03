package ${escapeKotlinIdentifiers(packageName)}

import com.choilabo.todo.di.ActivityScope
import ${packageName}.${className}Activity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ${className}ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(${className}Activity.Module::class))
    fun contribute${className}ActivityInjector(): ${className}Activity
}