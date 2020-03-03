package ${escapeKotlinIdentifiers(packageName)}

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.choilabo.todo.R
import com.choilabo.todo.databinding.${className}ActivityBinding
import com.choilabo.todo.di.ViewModelFactory
import com.choilabo.todo.di.ViewModelKey
import com.choilabo.todo.di.get
import dagger.Binds
import dagger.android.support.DaggerAppCompatActivity
import dagger.multibindings.IntoMap
import javax.inject.Inject

class ${className}Activity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        viewModelFactory.get<${className}ViewModel>(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<XxxActivityBinding>(
            this,
            R.layout.xxx_activity
        ).also {
            it.lifecycleOwner = this
            it.viewModel = viewModel
        }

        setSupportActionBar(binding.toolbar)
    }

    @dagger.Module
    interface Module {

        @Binds
        @IntoMap
        @ViewModelKey(${className}ViewModel::class)
        fun binds${className}ViewModel(viewModel: ${className}ViewModel): ViewModel
    }
}
