package com.choilabo.todo.di

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by sato_shinichiro on 2020-01-10
 */
private typealias ViewModelCreators = Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>

class ViewModelFactory @Inject constructor(
    private val creators: ViewModelCreators
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass]
            ?: creators.findAssignable(modelClass)
            ?: throw IllegalArgumentException("unknown model class " + modelClass)
        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    private fun <T : ViewModel> ViewModelCreators.findAssignable(modelClass: Class<T>): Provider<ViewModel>? =
        entries.firstOrNull { (key, _) -> modelClass.isAssignableFrom(key) }?.value
}

inline fun <reified T : ViewModel> ViewModelProvider.Factory.get(activity: FragmentActivity): T =
    ViewModelProviders.of(activity, this).get(T::class.java)
