package com.choilabo.todo.ui.todo.create

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.choilabo.todo.R
import com.choilabo.todo.data.todo.local.TodoDataClient
import com.choilabo.todo.databinding.TodoCreateActivityBinding
import com.choilabo.todo.ui.base.BaseActivity
import javax.inject.Inject


/**
 * Created by sato_shinichiro on 2017/12/07.
 */

class TodoCreateActivity : BaseActivity() {

    @Inject
    lateinit var todoDataClient: TodoDataClient

    private lateinit var binding: TodoCreateActivityBinding

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, TodoCreateActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.todo_create_activity)

        binding.btnCreate.setOnClickListener { view ->
            todoDataClient.save(
                    binding.title.text.toString(),
                    binding.description.text.toString()
            )
            finish()
        }
    }
}