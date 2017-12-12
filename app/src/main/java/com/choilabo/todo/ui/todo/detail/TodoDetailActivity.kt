package com.choilabo.todo.ui.todo.detail

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.choilabo.todo.R
import com.choilabo.todo.data.todo.local.TodoDataClient
import com.choilabo.todo.databinding.TodoDetailActivityBinding
import com.choilabo.todo.ui.base.BaseActivity
import javax.inject.Inject


/**
 * Created by sato_shinichiro on 2017/12/07.
 */

class TodoDetailActivity : BaseActivity() {

    @Inject
    lateinit var todoDataClient: TodoDataClient

    private lateinit var binding: TodoDetailActivityBinding

    companion object {
        private val KEY_ID = "id"

        fun createIntent(context: Context, id: String): Intent {
            return Intent(context, TodoDetailActivity::class.java)
                    .apply { putExtra(KEY_ID, id) }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<TodoDetailActivityBinding>(this, R.layout.todo_detail_activity)

        intent.getStringExtra(KEY_ID)
                ?.let { todoDataClient.getById(it) }
                ?.run {
                    binding.title.setText(title)
                    binding.description.setText(description)
                }
    }
}