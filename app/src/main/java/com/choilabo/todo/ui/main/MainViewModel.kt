package com.choilabo.todo.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.choilabo.todo.data.todo.TodoDataModel
import com.choilabo.todo.data.todo.entity.Todo
import kotlinx.coroutines.launch

/**
 * Created by sato_shinichiro on 2020-01-10
 */
class MainViewModel @ViewModelInject constructor(
    private val todoDataModel: TodoDataModel
) : ViewModel(), MainView.Listener {

    val todo = todoDataModel.observe().asLiveData()

    override fun onRegisterClicked(title: String) {
        viewModelScope.launch {
            todoDataModel.save(title)
        }
    }

    override fun onDeleteClicked(todo: Todo?) {
        todo ?: return
        viewModelScope.launch {
            todoDataModel.delete(todo)
        }
    }
}