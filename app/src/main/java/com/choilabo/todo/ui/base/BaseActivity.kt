package com.choilabo.todo.ui.base

import android.os.Bundle
import com.choilabo.todo.data.realm.RealmProvider
import com.choilabo.todo.ui.delegate.DisposableDelegate
import com.choilabo.todo.ui.delegate.LifecycleDisposableDelegate
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by sato_shinichiro on 2017/12/07.
 */

abstract class BaseActivity : DaggerAppCompatActivity(), DisposableDelegate {

    @Inject
    lateinit var realmProvider: RealmProvider
    @Inject
    lateinit var lifecycleDisposableDelegate: LifecycleDisposableDelegate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        realmProvider.reserve()
        lifecycleDisposableDelegate.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        lifecycleDisposableDelegate.onStart()
    }

    override fun onResume() {
        super.onResume()
        lifecycleDisposableDelegate.onResume()
    }

    override fun onPause() {
        super.onPause()
        lifecycleDisposableDelegate.onPause()
    }

    override fun onStop() {
        super.onStop()
        lifecycleDisposableDelegate.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleDisposableDelegate.onDestroy()
    }

    override fun finish() {
        super.finish()
        realmProvider.release()
    }

    override fun disposeOnPause(disposable: Disposable) {
        lifecycleDisposableDelegate.disposeOnPause(disposable)
    }

    override fun disposeOnStop(disposable: Disposable) {
        lifecycleDisposableDelegate.disposeOnStop(disposable)
    }

    override fun disposeOnDestroy(disposable: Disposable) {
        lifecycleDisposableDelegate.disposeOnDestroy(disposable)
    }
}