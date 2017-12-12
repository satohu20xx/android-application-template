package com.choilabo.todo.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.choilabo.todo.R
import com.choilabo.todo.data.todo.local.TodoDataClient
import com.choilabo.todo.databinding.MainAcitivtyBinding
import com.choilabo.todo.ui.base.BaseActivity
import com.choilabo.todo.ui.todo.create.TodoCreateActivity
import com.choilabo.todo.ui.todo.detail.TodoDetailActivity
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by sato_shinichiro on 2017/12/07.
 */

class MainActivity : BaseActivity() {

    @Inject
    lateinit var todoDataClient: TodoDataClient

    private lateinit var mainAdapter: MainAdapter
    private lateinit var binding: MainAcitivtyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<MainAcitivtyBinding>(this, R.layout.main_acitivty)
        binding.content.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            mainAdapter = MainAdapter(todoDataClient.getAll())
            mainAdapter.onItemClick()
                    .subscribe(
                            { startActivity(TodoDetailActivity.createIntent(this@MainActivity, it.id)) },
                            { Timber.e(it) }
                    )
                    .run { disposeOnDestroy(this) }
            adapter = mainAdapter
            setHasFixedSize(true)
        }

        binding.btnCreate.setOnClickListener {
            startActivity(TodoCreateActivity.createIntent(this))
        }
    }

    override fun onResume() {
        super.onResume()
        binding.content.adapter.notifyDataSetChanged()
    }
}
