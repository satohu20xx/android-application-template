package ${escapeKotlinIdentifiers(packageName)}

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.choilabo.todo.databinding.${className}ViewBinding

class ${className}View @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding = ${className}ViewBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    fun setListener(listener: Listener?) {
    }

    interface Listener
}