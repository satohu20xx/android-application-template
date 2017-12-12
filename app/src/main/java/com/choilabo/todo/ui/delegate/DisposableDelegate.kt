package com.choilabo.todo.ui.delegate

import io.reactivex.disposables.Disposable


/**
 * Created by sato_shinichiro on 2017/12/12.
 */
interface DisposableDelegate {

    fun disposeOnPause(disposable: Disposable)

    fun disposeOnStop(disposable: Disposable)

    fun disposeOnDestroy(disposable: Disposable)

}