package com.choilabo.todo.ui.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.choilabo.todo.R
import com.choilabo.todo.databinding.MainActivityBinding
import com.choilabo.todo.di.ViewModelFactory
import com.choilabo.todo.di.ViewModelKey
import com.choilabo.todo.di.get
import dagger.Binds
import dagger.android.support.DaggerAppCompatActivity
import dagger.multibindings.IntoMap
import kotlinx.android.synthetic.main.main_activity.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        viewModelFactory.get<MainViewModel>(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.addObserver(viewModel.disposableObserver)

        DataBindingUtil.setContentView<MainActivityBinding>(
            this,
            R.layout.main_activity
        ).also {
            it.lifecycleOwner = this
            it.viewModel = viewModel
        }

        setSupportActionBar(toolbar)
    }

    @dagger.Module
    interface Module {

        @Binds
        @IntoMap
        @ViewModelKey(MainViewModel::class)
        fun bindsMainViewModel(viewModel: MainViewModel): ViewModel
    }
}
