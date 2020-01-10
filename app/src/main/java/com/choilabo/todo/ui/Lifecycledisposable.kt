package com.choilabo.todo.ui

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Created by sato_shinichiro on 2020-01-10
 */
interface LifecycleDisposable : DefaultLifecycleObserver

interface WithLifecycleDisposing {

    val disposableObserver: LifecycleDisposable

    fun onCreateWithDisposables(disposables: CompositeDisposable) {}

    fun onStartWithDisposables(disposables: CompositeDisposable) {}

    fun onResumeWithDisposables(disposables: CompositeDisposable) {}

    fun onPause() {}

    fun onStop() {}

    fun onDestroy() {}
}

private class LifecycleDisposableImpl(private val target: WithLifecycleDisposing) :
    LifecycleDisposable {

    private val createDisposables = CompositeDisposable()
    private val startDisposables = CompositeDisposable()
    private val resumeDisposables = CompositeDisposable()

    override fun onCreate(lifecycleOwner: LifecycleOwner) {
        createDisposables.clear()
        target.onCreateWithDisposables(createDisposables)
    }

    override fun onStart(lifecycleOwner: LifecycleOwner) {
        startDisposables.clear()
        target.onStartWithDisposables(startDisposables)
    }

    override fun onResume(lifecycleOwner: LifecycleOwner) {
        resumeDisposables.clear()
        target.onResumeWithDisposables(resumeDisposables)
    }

    override fun onPause(lifecycleOwner: LifecycleOwner) {
        resumeDisposables.clear()
        target.onPause()
    }

    override fun onStop(lifecycleOwner: LifecycleOwner) {
        startDisposables.clear()
        target.onStop()
    }

    override fun onDestroy(lifecycleOwner: LifecycleOwner) {
        createDisposables.clear()
        target.onDestroy()
    }
}

fun <T> lifecycleDisposable(): ReadOnlyProperty<T, LifecycleDisposable> where T : ViewModel, T : WithLifecycleDisposing =
    object : ReadOnlyProperty<T, LifecycleDisposable> {
        private var lifecycleDisposable: LifecycleDisposable? = null

        override fun getValue(thisRef: T, property: KProperty<*>): LifecycleDisposable =
            lifecycleDisposable
                ?: LifecycleDisposableImpl(thisRef).also { lifecycleDisposable = it }
    }
