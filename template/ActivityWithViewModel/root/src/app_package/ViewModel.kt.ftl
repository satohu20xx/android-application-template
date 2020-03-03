package ${escapeKotlinIdentifiers(packageName)}

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ${className}ViewModel @Inject constructor(
) : ViewModel(), ${className}View.Listener {
}
