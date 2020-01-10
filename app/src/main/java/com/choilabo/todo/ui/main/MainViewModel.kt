package com.choilabo.todo.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.choilabo.todo.data.todo.TodoModel
import com.choilabo.todo.data.todo.entity.Todo
import com.choilabo.todo.ui.LifecycleDisposable
import com.choilabo.todo.ui.WithLifecycleDisposing
import com.choilabo.todo.ui.lifecycleDisposable
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by sato_shinichiro on 2020-01-10
 */
class MainViewModel @Inject constructor(
    private val todoModel: TodoModel
) : ViewModel(), WithLifecycleDisposing, MainView.Listener {

    val todo = MutableLiveData<List<Todo>>()

    override val disposableObserver: LifecycleDisposable by lifecycleDisposable()

    override fun onResumeWithDisposables(disposables: CompositeDisposable) {
        super.onResumeWithDisposables(disposables)

        todoModel.observe()
            .subscribe({
                todo.postValue(it)
            }, Timber::e)
            .let(disposables::add)
    }

    override fun onRegisterClicked(title: String) {
        todoModel.save(title)
            .subscribe()
    }

    override fun onDeleteClicked(todo: Todo?) {
        todo ?: return
        todoModel.delete(todo)
            .subscribe()
    }
}