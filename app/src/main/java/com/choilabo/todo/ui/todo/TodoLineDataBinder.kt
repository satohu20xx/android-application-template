package com.choilabo.todo.ui.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import com.choilabo.todo.data.todo.entity.Todo
import com.choilabo.todo.databinding.TodoLineViewBinding
import mva3.extension.DBItemBinder

/**
 * Created by sato_shinichiro on 2020-01-10
 */
class TodoLineDataBinder : DBItemBinder<Todo, TodoLineViewBinding>() {

    var listener: Listener? = null

    override fun canBindData(item: Any?): Boolean {
        return item is Todo
    }

    override fun createBinding(parent: ViewGroup): TodoLineViewBinding {
        return TodoLineViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).also {
            it.delete.setOnClickListener { _ ->
                listener?.onDeleteClicked(it.todo)
            }
        }
    }

    override fun bindModel(todo: Todo, binding: TodoLineViewBinding) {
        binding.todo = todo
    }

    interface Listener {

        fun onDeleteClicked(todo: Todo?)
    }
}