package com.choilabo.todo.ui.main

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.choilabo.todo.R
import com.choilabo.todo.data.todo.entity.Todo
import com.choilabo.todo.databinding.MainViewholderBinding
import io.reactivex.processors.PublishProcessor
import io.realm.RealmRecyclerViewAdapter
import io.realm.RealmResults


/**
 * Created by sato_shinichiro on 2017/12/07.
 */

class MainAdapter(
        data: RealmResults<Todo>
) : RealmRecyclerViewAdapter<Todo, MainAdapter.ViewHolder>(data, true) {

    private val onItemClickProcessor: PublishProcessor<Todo> = PublishProcessor.create()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<MainViewholderBinding>(
                LayoutInflater.from(parent.context),
                R.layout.main_viewholder,
                parent,
                false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.binding?.run {
            val todo = getItem(position) ?: return
            title.setText(todo.title)
            content.setOnClickListener { onItemClickProcessor.onNext(todo) }
        }
    }

    fun onItemClick() = onItemClickProcessor.onBackpressureLatest()

    class ViewHolder(val binding: MainViewholderBinding) : RecyclerView.ViewHolder(binding.content) {
    }

}