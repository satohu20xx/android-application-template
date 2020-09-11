package com.choilabo.todo.ui.main

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.choilabo.todo.data.todo.entity.Todo
import com.choilabo.todo.databinding.MainViewBinding
import com.choilabo.todo.ui.todo.TodoInputDataBinding
import com.choilabo.todo.ui.todo.TodoLineDataBinder
import mva3.adapter.ItemSection
import mva3.adapter.ListSection
import mva3.adapter.MultiViewAdapter

/**
 * Created by sato_shinichiro on 2020-01-10
 */
class MainView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val todoInputDataBinding = TodoInputDataBinding()
    private val todoLineDataBinder = TodoLineDataBinder()
    private val todoSection = ListSection<Todo>()

    private val binding = MainViewBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    ).also {
        it.recyclerView.layoutManager = LinearLayoutManager(context)
        it.recyclerView.adapter = MultiViewAdapter().also {
            it.registerItemBinders(
                todoInputDataBinding,
                todoLineDataBinder
            )
            it.addSection(ItemSection<TodoInputDataBinding.ViewData>().also {
                it.setItem(TodoInputDataBinding.ViewData)
            })
            it.addSection(todoSection)
        }
    }

    fun setTodo(todo: List<Todo>?) {
        todoSection.set(todo.orEmpty())
    }

    fun setListener(listener: Listener?) {
        todoInputDataBinding.listener = listener
        todoLineDataBinder.listener = listener
    }

    interface Listener :
        TodoInputDataBinding.Listener,
        TodoLineDataBinder.Listener
}