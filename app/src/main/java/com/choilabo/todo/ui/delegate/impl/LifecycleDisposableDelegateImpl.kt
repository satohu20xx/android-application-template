package com.choilabo.todo.ui.delegate.impl

import android.os.Bundle
import com.choilabo.todo.ui.delegate.LifecycleDisposableDelegate
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject


/**
 * Created by sato_shinichiro on 2017/12/12.
 */
class LifecycleDisposableDelegateImpl @Inject constructor() : LifecycleDisposableDelegate {

    private var onPauseDisposable = CompositeDisposable()
    private var onStopDisposable = CompositeDisposable()
    private var onDestroyDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        if (onDestroyDisposable.isDisposed) {
            onDestroyDisposable = CompositeDisposable()
        }
        if (onStopDisposable.isDisposed) {
            onStopDisposable = CompositeDisposable()
        }
        if (onPauseDisposable.isDisposed) {
            onPauseDisposable = CompositeDisposable()
        }
    }

    override fun onStart() {
        if (onStopDisposable.isDisposed) {
            onStopDisposable = CompositeDisposable()
        }
        if (onPauseDisposable.isDisposed) {
            onPauseDisposable = CompositeDisposable()
        }
    }

    override fun onResume() {
        if (onPauseDisposable.isDisposed) {
            onPauseDisposable = CompositeDisposable()
        }
    }

    override fun onPause() {
        onPauseDisposable.dispose()
    }

    override fun onStop() {
        onStopDisposable.dispose()
    }

    override fun onDestroy() {
        onDestroyDisposable.dispose()
    }

    override fun disposeOnPause(disposable: Disposable) {
        onPauseDisposable.add(disposable)
    }

    override fun disposeOnStop(disposable: Disposable) {
        onStopDisposable.add(disposable)
    }

    override fun disposeOnDestroy(disposable: Disposable) {
        onDestroyDisposable.add(disposable)
    }
}