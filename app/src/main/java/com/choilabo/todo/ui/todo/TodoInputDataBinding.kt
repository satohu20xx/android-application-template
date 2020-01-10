package com.choilabo.todo.ui.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import com.choilabo.todo.databinding.TodoInputViewBinding
import mva2.extension.DBItemBinder

/**
 * Created by sato_shinichiro on 2020-01-10
 */
class TodoInputDataBinding : DBItemBinder<TodoInputDataBinding.ViewData, TodoInputViewBinding>() {

    var listener: Listener? = null

    override fun canBindData(item: Any?): Boolean {
        return item is ViewData
    }

    override fun createBinding(parent: ViewGroup): TodoInputViewBinding {
        return TodoInputViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).also {
            it.register.setOnClickListener { _ ->
                it.title.text.toString().takeIf { it.isNotBlank() }?.also {
                    listener?.onRegisterClicked(it)
                }
            }
        }
    }

    override fun bindModel(viewData: ViewData?, binding: TodoInputViewBinding?) {
        // nop
    }

    object ViewData

    interface Listener {

        fun onRegisterClicked(title: String)
    }
}